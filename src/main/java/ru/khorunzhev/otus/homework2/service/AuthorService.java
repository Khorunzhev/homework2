package ru.khorunzhev.otus.homework2.service;

import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;

public interface AuthorService {

    Author getAuthor(String fullName);

}
