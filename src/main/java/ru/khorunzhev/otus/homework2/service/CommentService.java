package ru.khorunzhev.otus.homework2.service;

import reactor.core.publisher.Flux;
import ru.khorunzhev.otus.homework2.model.Comment;

public interface CommentService {

    void createComment(String text, String bookTitle);
    void updateComment(String id, String newText);
    void deleteComment(String id);
    Flux<Comment> getAllComments();
}
