package ru.khorunzhev.otus.homework2.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Book;

public interface BookService {

    Mono<Book> updateBook(Book book);
    void deleteBook(String id);
    Mono<Book> getBookByTitle(String title);
    Mono<Book> getBookById(String id);
    Flux<Book> getAllBooks();
}
