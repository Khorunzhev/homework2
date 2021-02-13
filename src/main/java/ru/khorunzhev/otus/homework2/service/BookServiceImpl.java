package ru.khorunzhev.otus.homework2.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.List;
import java.util.Optional;

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
    public void deleteBook(String id) {
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
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
