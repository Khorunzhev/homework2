package ru.khorunzhev.otus.homework2.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.khorunzhev.otus.homework2.model.Author;

@DataMongoTest
public class AuthorRepositoryTest {


    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void checkAuthorFindMethod() {
        Author expectedAuthor = Author.builder().fullName("FIO").build();
        mongoTemplate.save(expectedAuthor);

        Author actualAuthor = authorRepository.findByFullName(expectedAuthor.getFullName());

        Assertions.assertEquals(expectedAuthor, actualAuthor, "The author are not identical");
    }

}
