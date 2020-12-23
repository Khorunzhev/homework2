package ru.khorunzhev.otus.homework2.dao;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    Book update(Book book);

    Book getById(long id);

    Book getByTitle(String title);

    List<Book> getAll();

    void deleteById(long id);

}
