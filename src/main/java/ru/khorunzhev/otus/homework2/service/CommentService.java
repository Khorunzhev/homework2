package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;

public interface CommentService {

    void createComment(String text, Book book);
    Comment updateComment(long id, String newText);
    void deleteComment(long id);
}
