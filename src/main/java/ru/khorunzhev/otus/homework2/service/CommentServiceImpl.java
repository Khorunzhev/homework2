package ru.khorunzhev.otus.homework2.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import ru.khorunzhev.otus.homework2.model.Book;
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
                .zipWith(commentRepository.save(comment))
                .flatMap(tuple2 -> {
                    tuple2.getT1().getComments().add(tuple2.getT2());
                    return bookService.updateBook(tuple2.getT1());
                })
                .map(book -> book.getComments().stream()
                        .filter(bookComment -> comment.getText().equals(bookComment.getText()))
                        .findAny()
                        .orElse(null));
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
