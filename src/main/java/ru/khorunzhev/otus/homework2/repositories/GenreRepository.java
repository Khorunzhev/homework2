package ru.khorunzhev.otus.homework2.repositories;

import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreRepository {

    Genre getByName(String name);

    Genre insert(Genre name);

}
