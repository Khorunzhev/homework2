package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
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

    @ShellMethod(value = "Create book", key = {"cb", "CreateBook"})
    public void createBook(String title, String genre, String author) {
        bookService.create(title, genre, author);
    }

    @ShellMethod(value = "Update book", key = {"ub", "UpdateBook"})
    public void updateBook(@ShellOption({"username", "u"}) String oldTitle, String newTitle) {
        bookService.update(oldTitle, newTitle)
    }

    @ShellMethod(value = "Delete book", key = {"db", "DeleteBook"})
    public void deleteBook(String title) {
        bookService.delete(title);
    }

}
