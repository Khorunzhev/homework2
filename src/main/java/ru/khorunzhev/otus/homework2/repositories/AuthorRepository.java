package ru.khorunzhev.otus.homework2.repositories;

import ru.khorunzhev.otus.homework2.model.Author;

public interface AuthorRepository {

    Author getByFullName(String fullName);
}
