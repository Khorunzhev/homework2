package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Book;

public interface BookService {

    void create(String title, String authorFullName, String genreName);
    Book update(String curTitle, String newTitle);
    void delete(String title);
}
