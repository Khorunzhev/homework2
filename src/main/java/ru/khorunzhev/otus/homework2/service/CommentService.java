package ru.khorunzhev.otus.homework2.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;

public interface CommentService {

    Mono<Book> createComment(String text, String bookTitle);
    Mono updateComment(String id, String newText);
    Mono deleteComment(String id);
    Flux<Comment> getAllComments();
}
