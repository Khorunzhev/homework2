package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.repositories.GenreRepository;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @Override
    public Mono<Genre> getGenre(String name) {
        return genreRepository.findByName(name);
    }

    @Transactional
    @Override
    public Mono<Genre> createGenre(String name) {
        return genreRepository
                .findByName(name)
                .switchIfEmpty(
                        Mono.defer(() -> genreRepository
                                .save(Genre.builder().name(name).build()))
                );
    }


    @Override
    public Flux<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
