package ru.khorunzhev.otus.homework2.repositories;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

public interface BookRepository {

    int count();

    void insert(Book book);

    Book update(Book book);

    Book getFullInfoById(long id);

    Book getFullInfoByTitle(String title);

    List<Book> getAllFullInfo();

    void deleteById(long id);

}
