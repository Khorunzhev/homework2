package ru.khorunzhev.otus.homework2.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.repositories.BookRepositoryCustom;
import ru.khorunzhev.otus.homework2.repositories.CommentRepository;

@Service
@AllArgsConstructor
@Log
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;

    @Transactional
    @Override
    public void createComment(String text, String bookTitle) {
        Book book = bookService.getBookByTitle(bookTitle);

        book.getComments().add(new Comment(text));

        bookService.updateBook(book);
    }

    @Transactional
    @Override
    public void updateComment(String id, String newText) {
        commentRepository.findById(id)
                .ifPresentOrElse(
                        (Comment comment) ->
                        {
                            comment.setText(newText);
                            commentRepository.save(comment);
                        },
                        () -> log.info("Comment is not exist"));
    }

    @Transactional
    @Override
    public void deleteComment(String id) {
        commentRepository.findById(id).ifPresentOrElse(
                (Comment comment) -> {
                    bookRepository.removeCommentArrayElementsById(comment.getId());
                    commentRepository.delete(comment);
                },
                () -> log.info("Comment is not exist"));
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
