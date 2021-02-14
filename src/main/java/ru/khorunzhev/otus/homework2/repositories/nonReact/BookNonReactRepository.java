package ru.khorunzhev.otus.homework2.repositories.nonReact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Book;


public interface BookNonReactRepository extends MongoRepository<Book, String> {

    Book findBookByTitle(String title);

}
