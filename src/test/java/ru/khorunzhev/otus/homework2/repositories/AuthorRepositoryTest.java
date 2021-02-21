package ru.khorunzhev.otus.homework2.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import reactor.test.StepVerifier;
import ru.khorunzhev.otus.homework2.model.Author;

@DataMongoTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private MongoTemplate mt;

    @Test
    void checkAuthorFindMethod() {
        Author expectedAuthor = Author.builder().fullName("FIO").build();
        mt.save(expectedAuthor);

        StepVerifier
                .create(authorRepository.findByFullName(expectedAuthor.getFullName()))
                .expectNext(expectedAuthor)
                .verifyComplete();

    }
}
