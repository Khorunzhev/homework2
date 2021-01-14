package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    Genre findByName(String name);

}
