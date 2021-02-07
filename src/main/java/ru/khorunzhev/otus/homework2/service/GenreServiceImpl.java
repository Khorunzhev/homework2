package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.repositories.GenreRepository;
import ru.khorunzhev.otus.homework2.model.Genre;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public Genre getGenre(String name) {
        return genreRepository.findByName(name);
    }

    @Transactional
    @Override
    public Genre createGenre(String name) {
        Genre dbGenre = genreRepository.findByName(name);
        if (dbGenre == null) {
            Genre newGenre = Genre.builder().name(name).build();
            return genreRepository.save(newGenre);
        } else {
            return dbGenre;
        }
    }
}
