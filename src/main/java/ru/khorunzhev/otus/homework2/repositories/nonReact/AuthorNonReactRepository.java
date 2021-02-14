package ru.khorunzhev.otus.homework2.repositories.nonReact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Author;

public interface AuthorNonReactRepository extends MongoRepository<Author, String> {

    Author findByFullName(String fullName);
    
}
