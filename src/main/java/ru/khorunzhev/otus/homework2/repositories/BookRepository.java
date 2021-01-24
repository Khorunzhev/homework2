package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findBookByTitle(String title);
    List<Book> findAll();

}
