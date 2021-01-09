package ru.khorunzhev.otus.homework2.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.repositories.CommentRepository;

@Service
@AllArgsConstructor
@Log
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookService bookService;

    @Override
    public void createComment(String text, String bookTitle) {
        Book book = bookService.getBookByTitle(bookTitle);

        Comment comment = Comment.builder().text(text).book(book).build();

        commentRepository.insert(comment);
    }

    @Override
    public void updateComment(long id, String newText) {
        if (commentRepository.getFullInfoById(1).isPresent()) {
            Comment dbComment = commentRepository.getFullInfoById(1).get();
            dbComment.setText(newText);
            commentRepository.update(dbComment);
        } else {
            log.info("Comment is not exist");
        }
    }

    @Override
    public void deleteComment(long id) {
        if (commentRepository.getFullInfoById(1).isPresent()) {
            commentRepository.delete(commentRepository.getFullInfoById(1).get());
        } else {
            log.info("Comment is not exist");
        }
    }
}
