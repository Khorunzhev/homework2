package ru.khorunzhev.otus.homework2.repositories;

import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    int count();

    Book insert(Book book);

    void update(Book book);

    Optional<Book> getFullInfoById(long id);

    Book getFullInfoByTitle(String title);

    List<Book> getAllFullInfo();

    void deleteById(long id);

    void delete(Book book);

}
