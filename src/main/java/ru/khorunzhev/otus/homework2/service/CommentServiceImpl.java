package ru.khorunzhev.otus.homework2.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.repositories.react.CommentRepository;

@Service
@AllArgsConstructor
@Log
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookService bookService;

    @Transactional
    @Override
    public void createComment(String text, String bookTitle) {
        bookService.getBookByTitle(bookTitle)
                .subscribe(book -> {
                    Comment comment = Comment.builder().text(text).build();
                    book.getComments().add(comment);
                    commentRepository.save(comment);
                    bookService.updateBook(book);
                });
    }

    @Transactional
    @Override
    public void updateComment(String id, String newText) {
        commentRepository.findById(id)
                .subscribe(comment -> {
                    comment.setText(newText);
                    commentRepository.save(comment);
                });
    }

    @Transactional
    @Override
    public void deleteComment(String id) {
        commentRepository
                .findById(id)
                .subscribe(comment -> {
                    deleteComment(comment.getId());
                });
    }

    @Transactional(readOnly = true)
    @Override
    public Flux<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
