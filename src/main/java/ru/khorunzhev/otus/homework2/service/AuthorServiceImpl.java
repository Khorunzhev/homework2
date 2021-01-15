package ru.khorunzhev.otus.homework2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.khorunzhev.otus.homework2.model.Genre;
import ru.khorunzhev.otus.homework2.repositories.AuthorRepository;
import ru.khorunzhev.otus.homework2.model.Author;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public Author getAuthor(String fullName) {
        return authorRepository.getByFullName(fullName);
    }

    @Transactional
    @Override
    public Author createAuthor(String fullName) {
        Author dbAuthor = authorRepository.getByFullName(fullName);
        if (dbAuthor == null) {
            Author newAuthor = Author.builder().fullName(fullName).build();
            return authorRepository.insert(newAuthor);
        } else {
            return dbAuthor;
        }
    }
}
