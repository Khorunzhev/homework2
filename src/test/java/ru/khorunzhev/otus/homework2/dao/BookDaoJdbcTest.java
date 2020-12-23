package ru.khorunzhev.otus.homework2.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.khorunzhev.otus.homework2.model.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@JdbcTest
@Import(BookDaoJdbc.class)
public class BookDaoJdbcTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void shouldInsertBook() {

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

    @Test
    void shouldGetBook() {
        Book expectedBook = Book.builder()
                .id(1L)
                .title("Тест1")
                .fk_author_id(1L)
                .fk_genre_id(1L)
                .build();

        Book actualBook = bookDao.getById(1);

        assertThat(actualBook).isEqualTo(expectedBook);
    }

    @Test
    void shouldDeleteBook() {
        long checkedId = 1;
        bookDao.deleteById(checkedId);
        assertThatThrownBy(() -> bookDao.getById(checkedId)).isInstanceOf(EmptyResultDataAccessException.class);
    }

}
