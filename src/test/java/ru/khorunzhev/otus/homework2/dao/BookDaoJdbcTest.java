package ru.khorunzhev.otus.homework2.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;

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
                .author(new Author(1L, "Тест Автор1"))
                .genre(new Genre(1L, "Тест жанр1"))
                .build();
        bookDao.insert(expectedBook);

        System.out.println(String.format("Book %s inserted", expectedBook));

        Book actualBook = bookDao.getFullInfoByTitle("INSERT");

        assertThat(expectedBook)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(actualBook);
    }

    @Test
    void shouldGetBook() {
        Book expectedBook = Book.builder()
                .id(1L)
                .title("Тест1")
                .author(new Author(1L, "Тест Автор1"))
                .genre(new Genre(1L, "Тест жанр1"))
                .build();

        Book actualBook = bookDao.getFullInfoById(1);

        assertThat(actualBook).isEqualTo(expectedBook);
    }

    @Test
    void shouldDeleteBook() {
        long checkedId = 1;
        bookDao.deleteById(checkedId);
        assertThatThrownBy(() -> bookDao.getFullInfoById(checkedId)).isInstanceOf(EmptyResultDataAccessException.class);
    }

}
