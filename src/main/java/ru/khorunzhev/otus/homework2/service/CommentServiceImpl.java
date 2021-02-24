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
        Comment comment = Comment.builder().text(text).build();
        return bookService.getBookByTitle(bookTitle)
                .switchIfEmpty(Mono.empty())
                .flatMap(book -> {
                    book.getComments().add(comment);
                    return bookService.updateBook(book);
                })
                .flatMap((book) -> commentRepository.save(comment));
    }

    @Transactional
    @Override
    public Mono<Comment> updateComment(String id, String newText) {
        return commentRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .flatMap(comment -> {
                    comment.setText(newText);
                    return commentRepository.save(comment);
                });
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
