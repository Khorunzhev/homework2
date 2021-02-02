package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void createBook(String title, String authorFullName, String genreName);
    void updateBook(String curTitle, String newTitle);
    Book updateBook(Book book);
    void deleteBook(String title);
    void deleteBook(Long id);
    Book getBookByTitle(String title);
    Optional<Book> getBookById(Long id);
    List<Book> getAllBooks();
}
