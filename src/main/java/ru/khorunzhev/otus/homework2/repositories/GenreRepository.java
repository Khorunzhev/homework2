package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.khorunzhev.otus.homework2.model.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {

    Genre findByName(String name);

}
