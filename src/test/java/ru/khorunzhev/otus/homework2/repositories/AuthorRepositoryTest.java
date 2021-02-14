package ru.khorunzhev.otus.homework2.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;

@DataJpaTest
public class AuthorRepositoryTest {


    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void checkAuthorFindMethod() {
        Author expectedAuthor = Author.builder().fullName("FIO").build();
        em.persist(expectedAuthor);

        Author actualAuthor = authorRepository.findByFullName(expectedAuthor.getFullName()).block();

        Assertions.assertEquals(expectedAuthor, actualAuthor, "The author are not identical");
    }

}
