package ru.khorunzhev.otus.homework2.repositories;

import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;

public interface AuthorRepository {

    Author getByFullName(String fullName);

    Author insert(Author book);
}
