package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>, BookRepositoryCustom {

    Book findBookByTitle(String title);
    List<Book> findAll();

}
