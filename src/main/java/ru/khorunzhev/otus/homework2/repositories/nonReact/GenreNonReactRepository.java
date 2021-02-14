package ru.khorunzhev.otus.homework2.repositories.nonReact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreNonReactRepository extends MongoRepository<Genre, String> {

    Genre findByName(String name);

}
