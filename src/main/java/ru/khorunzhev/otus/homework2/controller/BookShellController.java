package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.service.BookCRUDService;

@ShellComponent
@RequiredArgsConstructor
public class BookShellController {

    private final BookCRUDService bookCRUDService;

    @ShellMethod(value = "Create book", key = {"cb", "CreateBook"})
    public void createBook(String title, Long genre, Long author) {

        Book book = Book.builder()
                        .title(title)
                        .fk_author_id(1L)
                        .fk_genre_id(1L)
                        .build();
        bookCRUDService.create(book);
    }

    @ShellMethod(value = "Update book", key = {"ub", "UpdateBook"})
    public void updateBook() {
        //bookCRUDService.update
    }

    @ShellMethod(value = "Delete book", key = {"db", "DeleteBook"})
    public void deleteBook(String title) {
        bookCRUDService.delete(title);
    }

}
