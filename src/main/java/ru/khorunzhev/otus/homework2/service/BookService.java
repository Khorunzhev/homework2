package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

public interface BookService {

    void createBook(String title, String authorFullName, String genreName);
    Book updateBook(String curTitle, String newTitle);
    void deleteBook(String title);
    Book getBookByTitle(String title);
    List<Book> getAllBooks();
}
