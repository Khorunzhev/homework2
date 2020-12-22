package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;
import ru.khorunzhev.otus.homework2.service.AuthorService;
import ru.khorunzhev.otus.homework2.service.BookService;
import ru.khorunzhev.otus.homework2.service.GenreService;

@ShellComponent
@RequiredArgsConstructor
public class BookShellController {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    @ShellMethod(value = "Create book", key = {"cb", "CreateBook"})
    public void createBook(String title, String genre, String author) {
        Genre genreEntity = genreService.get(genre);
        Author authorEntity = authorService.get(author);
        authorService.get(author);
        Book book = Book.builder()
                        .title(title)
                        .fk_author_id(authorEntity.getId())
                        .fk_genre_id(genreEntity.getId())
                        .build();
        bookService.create(book);
    }

    @ShellMethod(value = "Update book", key = {"ub", "UpdateBook"})
    public void updateBook() {
        //bookCRUDService.update
    }

    @ShellMethod(value = "Delete book", key = {"db", "DeleteBook"})
    public void deleteBook(String title) {
        bookService.delete(title);
    }

}
