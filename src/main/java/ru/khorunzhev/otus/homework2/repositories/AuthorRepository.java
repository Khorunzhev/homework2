package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khorunzhev.otus.homework2.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByFullName(String fullName);
    
}
