package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.model.Genre;
import ru.khorunzhev.otus.homework2.repositories.AuthorRepository;
import ru.khorunzhev.otus.homework2.model.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public Author getAuthor(String fullName) {
        return authorRepository.findByFullName(fullName);
    }

    @Override
    public Author createAuthor(String fullName) {
        Author dbAuthor = authorRepository.findByFullName(fullName);
        if (dbAuthor == null) {
            Author newAuthor = Author.builder().fullName(fullName).build();
            return authorRepository.save(newAuthor);
        } else {
            return dbAuthor;
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
