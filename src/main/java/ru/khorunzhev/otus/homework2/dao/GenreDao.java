package ru.khorunzhev.otus.homework2.dao;

import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreDao {

    Genre getByName(String name);

}
