package ru.khorunzhev.otus.homework2.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.khorunzhev.otus.homework2.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.namedParameterJdbcOperations = jdbcOperations;
    }

    @Override
    public int count() {
        return namedParameterJdbcOperations.getJdbcOperations().queryForObject("SELECT count(*) FROM BOOK", Integer.class);
    }

    @Override
    public void insert(Book book) {

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("TITLE", book.getTitle())
                .addValue("FK_AUTHOR_ID", book.getFk_author_id())
                .addValue("FK_GENRE_ID", book.getFk_genre_id());
        namedParameterJdbcOperations.update("INSERT INTO BOOK (`TITLE`, FK_AUTHOR_ID, FK_GENRE_ID) values (:TITLE, :FK_AUTHOR_ID, :FK_GENRE_ID)", namedParameters);
    }

    @Override
    public Book update(Book book) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("ID", book.getId())
                .addValue("TITLE", book.getTitle())
                .addValue("FK_AUTHOR_ID", book.getFk_author_id())
                .addValue("FK_GENRE_ID", book.getFk_genre_id());
        namedParameterJdbcOperations.update("UPDATE BOOK SET `TITLE`=:TITLE, FK_AUTHOR_ID=:FK_AUTHOR_ID, FK_GENRE_ID=:FK_GENRE_ID WHERE ID=:ID", namedParameters);
        return getById(book.getId());
    }

    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "SELECT * FROM BOOK where id = :id", params, new BookMapper()
        );
    }

    @Override
    public Book getByTitle(String title) {
        Map<String, Object> params = Collections.singletonMap("title", title;
        return namedParameterJdbcOperations.queryForObject(
                "SELECT * FROM BOOK where TITLE = :title", params, new BookMapper()
        );
    }

    @Override
    public List<Book> getAll() {
        return namedParameterJdbcOperations.query("SELECT * FROM BOOK", new BookMapper());
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
            long fk_author_id = resultSet.getLong("FK_AUTHOR_ID");
            long fk_genre_id = resultSet.getLong("FK_GENRE_ID");
            String title = resultSet.getString("TITLE");
            return new Book(id, title, fk_author_id, fk_genre_id);
        }
    }
}
