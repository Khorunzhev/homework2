package ru.khorunzhev.otus.homework2.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Author;

public interface AuthorService {

    Mono<Author> getAuthor(String fullName);
    Mono<Author> createAuthor(String fullName);
    Flux<Author> getAllAuthors();

}
