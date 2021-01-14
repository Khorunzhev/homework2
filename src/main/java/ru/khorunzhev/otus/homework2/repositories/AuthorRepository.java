package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findByFullName(String fullName);
    
}
