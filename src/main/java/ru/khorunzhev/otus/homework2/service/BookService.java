package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

public interface BookService {

    void createBook(String title, String authorFullName, String genreName);
    void updateBook(String curTitle, String newTitle);
    void updateBook(Book book);
    void deleteBook(String title);
    Book getBookByTitle(String title);
    List<Book> getAllBooks();
}
