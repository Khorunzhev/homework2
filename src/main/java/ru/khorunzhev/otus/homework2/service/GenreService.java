package ru.khorunzhev.otus.homework2.service;

import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.util.List;

public interface GenreService {

    Genre getGenre(String title);
    Genre createGenre(String title);
    List<Genre> getAllGenres();

}
