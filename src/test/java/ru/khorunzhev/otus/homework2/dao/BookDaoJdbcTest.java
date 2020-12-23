package ru.khorunzhev.otus.homework2.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.khorunzhev.otus.homework2.model.Book;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(BookDaoJdbc.class)
public class BookDaoJdbcTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void insert() {

        Book expectedBook = Book.builder()
                .id(10L)
                .title("INSERT")
                .fk_author_id(1L)
                .fk_genre_id(1L)
                .build();
        bookDao.insert(expectedBook);

        System.out.println(String.format("Book %s inserted", expectedBook));

        Book actualBook = bookDao.getByTitle("INSERT");

        assertThat(expectedBook)
                .isEqualToIgnoringGivenFields(actualBook,"id");
    }

}
