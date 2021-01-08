package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khorunzhev.otus.homework2.repositories.GenreRepository;
import ru.khorunzhev.otus.homework2.model.Genre;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Genre getGenre(String name) {
        return genreRepository.getByName(name);
    }
}
