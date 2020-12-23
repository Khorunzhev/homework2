package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.khorunzhev.otus.homework2.dao.AuthorDao;
import ru.khorunzhev.otus.homework2.dao.BookDao;
import ru.khorunzhev.otus.homework2.dao.GenreDao;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;

@Service
@RequiredArgsConstructor
@Log
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final AuthorDao authorDao;

    @Override
    public void create(String title, String authorFullName, String genreName) {
        Genre genreEntity = genreDao.getByName(genreName);
        Author authorEntity = authorDao.getByFullName(authorFullName);
        Book book = Book.builder()
                .title(title)
                .fk_author_id(authorEntity.getId())
                .fk_genre_id(genreEntity.getId())
                .build();

        bookDao.insert(book);
        log.info(String.format("Book %s is created", book));
    }

    @Override
    public Book update(String curTitle, String newTitle) {
        Book dbBook = bookDao.getByTitle(curTitle);
        dbBook.setTitle(newTitle);
        Book updatedBook = bookDao.update(dbBook);
        log.info(String.format("Book %s is updated", updatedBook));
        return updatedBook;
    }

    @Override
    public void delete(final String title) {
        Book bookFromDB = bookDao.getByTitle(title);
        bookDao.deleteById(bookFromDB.getId());
        log.info(String.format("Book %s is deleted", bookFromDB));
    }
}
