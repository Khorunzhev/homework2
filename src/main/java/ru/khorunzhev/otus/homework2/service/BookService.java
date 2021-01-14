package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;

public interface BookService {

    void createBook(String title, String authorFullName, String genreName);
    void updateBook(String curTitle, String newTitle);
    void deleteBook(String title);
    Book getBookByTitle(String title);
    Iterable<Book> getAllBooks();
}
