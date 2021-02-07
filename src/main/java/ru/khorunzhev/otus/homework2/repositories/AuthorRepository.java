package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.khorunzhev.otus.homework2.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Author findByFullName(String fullName);
    
}
