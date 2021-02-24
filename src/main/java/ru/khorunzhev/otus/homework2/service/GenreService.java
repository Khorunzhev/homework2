package ru.khorunzhev.otus.homework2.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreService {

    Mono<Genre> getGenre(String title);
    Mono<Genre> createGenre(String title);
    Flux<Genre> getAllGenres();

}
