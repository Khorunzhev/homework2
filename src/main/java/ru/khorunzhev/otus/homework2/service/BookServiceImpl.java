package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final GenreService genreService;
    private final AuthorService authorService;

    @Override
    public void createBook(String title, String authorFullName, String genreName) {
        Genre genreEntity = genreService.getGenre(genreName);
        Author authorEntity = authorService.getAuthor(authorFullName);
        Book book = Book.builder()
                .title(title)
                .author(authorEntity)
                .genre(genreEntity)
                .build();

        bookRepository.insert(book);
        log.info(String.format("Book %s is created", book));
    }

    @Override
    public Book updateBook(String curTitle, String newTitle) {
        Book dbBook = bookRepository.getFullInfoByTitle(curTitle);
        dbBook.setTitle(newTitle);
        Book updatedBook = bookRepository.update(dbBook);
        log.info(String.format("Book %s is updated", updatedBook));
        return updatedBook;
    }

    @Override
    public void deleteBook(final String title) {
        Book bookFromDB = bookRepository.getFullInfoByTitle(title);
        if (bookFromDB != null) {
            bookRepository.deleteById(bookFromDB.getId());
            log.info(String.format("Book %s is deleted", bookFromDB));
        } else
        {
            log.info(String.format("Book with title %s already deleted", title));
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllFullInfo();
    }
}
