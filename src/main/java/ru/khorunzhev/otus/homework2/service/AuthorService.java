package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

public interface AuthorService {

    Author getAuthor(String fullName);
    Author createAuthor(String fullName);
    List<Author> getAllAuthors();

}
