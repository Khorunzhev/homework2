package ru.khorunzhev.otus.homework2.repositories.react;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

    Mono<Genre> findByName(String name);

}
