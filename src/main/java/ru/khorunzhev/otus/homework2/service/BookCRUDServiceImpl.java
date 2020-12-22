package ru.khorunzhev.otus.homework2.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.khorunzhev.otus.homework2.dao.BookDao;
import ru.khorunzhev.otus.homework2.model.Book;

@Service
@RequiredArgsConstructor
@Log
public class BookCRUDServiceImpl implements BookCRUDService {

    private final BookDao bookDao;

    @Override
    public void create(final Book book) {
        bookDao.insert(book);
        log.info(String.format("Book %s is created", book));
    }

    @Override
    public Book update(final Book book) {
        return null;
    }

    @Override
    public boolean delete(final Book book) {
        return false;
    }
}
