package ru.khorunzhev.otus.homework2.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Log
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Transactional
    @Override
    public Book updateBook(Book book) {
        Book savedBook = bookRepository.save(book);
        log.info(String.format("Book %s is updated", savedBook));
        return savedBook;
    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
        log.info(String.format("Book with %s is deleted", id));
    }

    @Transactional(readOnly = true)
    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    @HystrixCommand(fallbackMethod = "getDefaultBooks", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getDefaultBooks() {
        log.warning("БД недоступно, отдается дефолтный список книг");
        return List.of(
                new Book(-1L,
                        "Default book",
                        new Author(-1L, "Default author"),
                        new Genre(-1L, "Default genre"),
                        Set.of(new Comment(-1l, "text", null)))
        );
    }
}
