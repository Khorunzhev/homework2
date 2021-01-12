package ru.khorunzhev.otus.homework2.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.repositories.CommentRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Log
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookService bookService;

    @Transactional
    @Override
    public void createComment(String text, String bookTitle) {
        Book book = bookService.getBookByTitle(bookTitle);

        Comment comment = Comment.builder().text(text).book(book).build();

        commentRepository.insert(comment);
    }

    @Transactional
    @Override
    public void updateComment(long id, String newText) {
        commentRepository.getFullInfoById(id)
                .ifPresentOrElse(
                        (Comment comment) ->
                        {
                            comment.setText(newText);
                            commentRepository.update(comment);
                        },
                        () -> log.info("Comment is not exist"));
    }

    @Transactional
    @Override
    public void deleteComment(long id) {
        if (commentRepository.getFullInfoById(id).isPresent()) {
            Comment dbComment = commentRepository.getFullInfoById(id).get();
            commentRepository.delete(dbComment);
        } else {
            log.info("Comment is not exist");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.getAllFullInfo();
    }
}
