package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.repositories.AuthorRepository;
import ru.khorunzhev.otus.homework2.model.Author;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public Mono<Author> getAuthor(String fullName) {
        return authorRepository.findByFullName(fullName);
    }

    @Override
    public Mono<Author> createAuthor(String fullName) {
        return authorRepository.save(
                Author.builder().fullName(fullName).build());
    }

    @Override
    public Flux<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
