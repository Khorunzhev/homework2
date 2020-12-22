package ru.khorunzhev.otus.homework2.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AuthorDaoJdbc implements AuthorDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public Author getByFullName(String fullname) {
        Map<String, Object> params = Collections.singletonMap("fullname", fullname;
        return namedParameterJdbcOperations.queryForObject(
                "SELECT * FROM AUTHOR where FULLNAME = :fullname", params, new AuthorDaoJdbc.AuthorMapper()
        );
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("ID");
            String fullname = resultSet.getString("FULLNAME");
            return new Author(id, fullname);
        }
    }
}
