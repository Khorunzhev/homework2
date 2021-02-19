package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Author;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

    Mono<Author> findByFullName(String fullName);
    
}
