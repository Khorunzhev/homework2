package ru.khorunzhev.otus.homework2.dao;

import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;

public interface AuthorDao {

    Author getByFullName(String fullName);
}
