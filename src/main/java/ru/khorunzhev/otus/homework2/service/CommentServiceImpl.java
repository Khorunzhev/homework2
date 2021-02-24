package ru.khorunzhev.otus.homework2.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.repositories.CommentRepository;


@Service
@AllArgsConstructor
@Log
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookService bookService;

    @Transactional
    @Override
    public Mono<Comment> createComment(String text, String bookTitle) {
        return bookService.getBookByTitle(bookTitle)
                .switchIfEmpty(Mono.empty())
                .flatMap(book -> {
                    Comment comment = Comment.builder().text(text).build();
                    book.getComments().add(comment);
                    bookService.updateBook(book);
                    return commentRepository.save(comment);
                });
    }

    @Transactional
    @Override
    public Mono<Void> updateComment(String id, String newText) {
        return commentRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .doOnNext(comment -> {
                    comment.setText(newText);
                    commentRepository.save(comment);
                })
                .then();
    }

    @Transactional
    @Override
    public Mono<Void> deleteComment(String id) {
        return commentRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .doOnNext(commentRepository::delete)
                .then();
    }

    @Transactional(readOnly = true)
    @Override
    public Flux<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
