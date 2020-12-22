package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.khorunzhev.otus.homework2.dao.AuthorDao;
import ru.khorunzhev.otus.homework2.model.Author;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public Author get(String fullName) {
        return authorDao.getByFullName(fullName);
    }

    @Override
    public void create(Author author) {

    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public void delete(String fullName) {

    }
}
