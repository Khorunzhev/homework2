package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBooksByTitle(String title);

}
