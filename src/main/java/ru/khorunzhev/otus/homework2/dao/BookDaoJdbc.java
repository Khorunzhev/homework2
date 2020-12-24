package ru.khorunzhev.otus.homework2.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public int count() {
        return namedParameterJdbcOperations.getJdbcOperations().queryForObject("SELECT count(*) FROM BOOK", Integer.class);
    }

    @Override
    public void insert(Book book) {

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("TITLE", book.getTitle())
                .addValue("AUTHOR_ID", book.getAuthor().getId())
                .addValue("GENRE_ID", book.getGenre().getId());
        namedParameterJdbcOperations.update("INSERT INTO BOOK (`TITLE`, AUTHOR_ID, GENRE_ID) values (:TITLE, :AUTHOR_ID, :GENRE_ID)", namedParameters);
    }

    @Override
    public Book update(Book book) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("ID", book.getId())
                .addValue("TITLE", book.getTitle())
                .addValue("AUTHOR_ID", book.getAuthor().getId())
                .addValue("GENRE_ID", book.getGenre().getId());
        namedParameterJdbcOperations.update("UPDATE BOOK SET `TITLE`=:TITLE, AUTHOR_ID=:AUTHOR_ID, GENRE_ID=:GENRE_ID WHERE ID=:ID", namedParameters);
        return getFullInfoById(book.getId());
    }

    @Override
    public Book getFullInfoById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        try {
            return namedParameterJdbcOperations.queryForObject(
                    "SELECT b.ID, b.TITLE, b.AUTHOR_ID, a.FULLNAME, b.GENRE_ID, g.NAME FROM BOOK b  " +
                            "INNER JOIN AUTHOR a on b.AUTHOR_ID = a.ID " +
                            "INNER JOIN GENRE g on b.GENRE_ID = g.ID " +
                            "WHERE b.ID = :id", params, new BookMapper()
            );
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public Book getFullInfoByTitle(String title) {
        Map<String, Object> params = Collections.singletonMap("title", title);
        try {
            return namedParameterJdbcOperations.queryForObject(
                    "SELECT b.ID, b.TITLE, b.AUTHOR_ID, a.FULLNAME, b.GENRE_ID, g.NAME FROM BOOK b  " +
                        "INNER JOIN AUTHOR a on b.AUTHOR_ID = a.ID " +
                        "INNER JOIN GENRE g on b.GENRE_ID = g.ID " +
                        "WHERE b.TITLE = :title", params, new BookMapper()
            );
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Book> getAllFullInfo() {
        return namedParameterJdbcOperations.query(
             "SELECT b.ID, b.TITLE, b.AUTHOR_ID, a.FULLNAME, b.GENRE_ID, g.NAME FROM BOOK b  " +
                "INNER JOIN AUTHOR a on b.AUTHOR_ID = a.ID " +
                "INNER JOIN GENRE g on b.GENRE_ID = g.ID", new BookMapper());
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("ID", id);
        namedParameterJdbcOperations.update(
                "DELETE FROM BOOK where ID = :ID", params
        );
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("ID");
            String title = resultSet.getString("TITLE");
            return Book.builder()
                    .id(id)
                    .title(title)
                    .author(new Author(resultSet.getLong("AUTHOR_ID"), resultSet.getString("FULLNAME")))
                    .genre(new Genre(resultSet.getLong("GENRE_ID"), resultSet.getString("NAME")))
                    .build();
        }
    }
}
