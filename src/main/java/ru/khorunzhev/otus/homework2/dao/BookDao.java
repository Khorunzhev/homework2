package ru.khorunzhev.otus.homework2.dao;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

public interface BookDao {

    int count();

    void insert(Book book);

    Book update(Book book);

    Book getById(long id);

    List<Book> getAll();

    void deleteById(long id);

}
