package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.stereotype.Repository;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

@Repository
public class BookRepositoryJpaImpl implements BookRepository {

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book getFullInfoById(long id) {
        return null;
    }

    @Override
    public Book getFullInfoByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> getAllFullInfo() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
