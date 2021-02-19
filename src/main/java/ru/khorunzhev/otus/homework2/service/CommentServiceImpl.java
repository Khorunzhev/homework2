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
    public Mono createComment(String text, String bookTitle) {
        return bookService.getBookByTitle(bookTitle)
                .switchIfEmpty(Mono.empty())
                .map(book -> {
                    Comment comment = Comment.builder().text(text).build();
                    book.getComments().add(comment);
                    commentRepository.save(comment);
                    return bookService.updateBook(book);
                });
    }

    @Transactional
    @Override
    public Mono updateComment(String id, String newText) {
        return commentRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .map(comment -> {
                    comment.setText(newText);
                    return commentRepository.save(comment);
                });
    }

    @Transactional
    @Override
    public Mono deleteComment(String id) {
        return commentRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .map(comment -> {
                   return deleteComment(comment.getId());
                });
    }

    @Transactional(readOnly = true)
    @Override
    public Flux<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
