package ru.khorunzhev.otus.homework2.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import reactor.test.StepVerifier;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;


@DataMongoTest
public class BookRepositoryTest {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mt;

    @Test
    void checkFindBookMethod() {
        Author author = Author.builder().fullName("test-FIO").build();
        mt.save(author);

        Genre genre = Genre.builder().name("test-genre").build();
        mt.save(genre);

        Book expectedBook = Book.builder()
                .title("test-TITLE")
                .author(author)
                .genre(genre)
                .build();
        mt.save(expectedBook);

        StepVerifier
            .create(bookRepository.findBookByTitle(expectedBook.getTitle()))
            .expectNext(expectedBook)
            .verifyComplete();
    }

}
