package ru.khorunzhev.otus.homework2.repositories;

import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.khorunzhev.otus.homework2.model.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Репозиторий на основе Jpa для работы со студентами ")
@DataJpaTest
@Import(BookRepositoryJpaImpl.class)
public class BookRepositoryJPATest {

    private static final long BOOK_ID = 1L;


    @Autowired
    private BookRepositoryJpaImpl bookRepositoryJpa;

    @Autowired
    private TestEntityManager em;

    @Test
    void checkGetByIdMethod() {
        val optionalActualStudent = bookRepositoryJpa.getFullInfoById(BOOK_ID);
        val expectedStudent = em.find(Book.class, BOOK_ID);
        assertThat(optionalActualStudent)
                .usingRecursiveComparison().isEqualTo(expectedStudent);
    }

}
