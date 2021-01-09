package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Log
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreService genreService;
    private final AuthorService authorService;

    @Transactional
    @Override
    public void createBook(String title, String authorFullName, String genreName) {
        Genre genreEntity = genreService.createGenre(genreName);
        Author authorEntity = authorService.createAuthor(authorFullName);
        Book book = Book.builder()
                .title(title)
                .author(Set.of(authorEntity))
                .genre(Set.of(genreEntity))
                .build();

        bookRepository.insert(book);
        log.info(String.format("Book %s is created", book));
    }

    @Transactional
    @Override
    public Book updateBook(String curTitle, String newTitle) {
        Book dbBook = bookRepository.getFullInfoByTitle(curTitle);
        bookRepository.updateTitleById(dbBook.getId(), newTitle);
        Book updatedBook = bookRepository.getFullInfoById(dbBook.getId());
        log.info(String.format("Book %s is updated", updatedBook));
        return updatedBook;
    }

    @Transactional
    @Override
    public void deleteBook(final String title) {
        Book bookFromDB = bookRepository.getFullInfoByTitle(title);
        if (bookFromDB != null) {
            bookRepository.delete(bookFromDB);
            log.info(String.format("Book %s is deleted", bookFromDB));
        } else
        {
            log.info(String.format("Book with title %s already deleted", title));
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.getFullInfoByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllFullInfo();
    }
}
