package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);

}
