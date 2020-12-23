package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.service.BookService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class BookShellController {

    private final BookService bookService;

    @ShellMethod(value = "Create book", key = {"cb", "CreateBook"})
    public void createBook(String title, String genre, String author) {
        bookService.create(title, genre, author);
    }

    @ShellMethod(value = "Update book", key = {"ub", "UpdateBook"})
    public void updateBook(@ShellOption({"curTitle", "ct"}) String curTitle, @ShellOption({"newTitle", "nt"})  String newTitle) {
        bookService.update(curTitle, newTitle);
    }

    @ShellMethod(value = "Delete book", key = {"db", "DeleteBook"})
    public void deleteBook(String title) {
        bookService.delete(title);
    }

    @ShellMethod(value = "Get all books", key = {"allb", "GetAllBooks"})
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

}
