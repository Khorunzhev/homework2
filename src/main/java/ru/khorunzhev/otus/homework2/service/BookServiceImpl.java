package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.repositories.react.BookRepository;
import ru.khorunzhev.otus.homework2.model.Book;

@Service
@RequiredArgsConstructor
@Log
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Transactional
    @Override
    public Mono<Book> updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id)
                .subscribe(s -> String.format("Book with %s is deleted", id));
    }

    @Transactional(readOnly = true)
    @Override
    public Mono<Book> getBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public Mono<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
