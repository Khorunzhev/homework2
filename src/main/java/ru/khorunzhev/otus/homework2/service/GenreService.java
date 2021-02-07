package ru.khorunzhev.otus.homework2.service;

import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreService {

    Genre getGenre(String title);
    Genre createGenre(String title);

}
