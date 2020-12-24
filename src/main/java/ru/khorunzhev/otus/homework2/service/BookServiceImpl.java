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

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final AuthorDao authorDao;

    @Override
    public void createBook(String title, String authorFullName, String genreName) {
        Genre genreEntity = genreDao.getByName(genreName);
        Author authorEntity = authorDao.getByFullName(authorFullName);
        Book book = Book.builder()
                .title(title)
                .author(authorEntity)
                .genre(genreEntity)
                .build();

        bookDao.insert(book);
        log.info(String.format("Book %s is created", book));
    }

    @Override
    public Book updateBook(String curTitle, String newTitle) {
        Book dbBook = bookDao.getFullInfoByTitle(curTitle);
        dbBook.setTitle(newTitle);
        Book updatedBook = bookDao.update(dbBook);
        log.info(String.format("Book %s is updated", updatedBook));
        return updatedBook;
    }

    @Override
    public void deleteBook(final String title) {
        Book bookFromDB = bookDao.getFullInfoByTitle(title);
        bookDao.deleteById(bookFromDB.getId());
        log.info(String.format("Book %s is deleted", bookFromDB));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllFullInfo();
    }
}
