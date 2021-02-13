package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book updateBook(Book book);
    void deleteBook(String id);
    Book getBookByTitle(String title);
    Optional<Book> getBookById(String id);
    List<Book> getAllBooks();
}
