package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;

public interface BookService {

    void create(Book book);
    Book update(Book book);
    void delete(String title);
}
