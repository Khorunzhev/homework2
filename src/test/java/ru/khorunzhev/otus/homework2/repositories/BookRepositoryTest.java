package ru.khorunzhev.otus.homework2.repositories;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;


@DataJpaTest
public class BookRepositoryTest {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void checkFindBookMethod() {
        Author author = Author.builder().fullName("FIO").build();
        em.persist(author);

        Genre genre = Genre.builder().name("genre").build();
        em.persist(genre);

        Book expectedBook = Book.builder()
                .title("TITLE")
                .author(author)
                .genre(genre)
                .build();

        em.persist(expectedBook);

        Book actualBook = bookRepository.findBookByTitle(expectedBook.getTitle());

        Assertions.assertEquals(expectedBook, actualBook, "The books are not identical");
    }

}
