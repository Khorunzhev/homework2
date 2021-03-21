package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Book;


public interface BookRepository extends ReactiveMongoRepository<Book, String>, BookRepositoryCustom {

    Mono<Book> findBookByTitle(String title);

}
