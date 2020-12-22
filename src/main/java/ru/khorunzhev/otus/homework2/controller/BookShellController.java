package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.khorunzhev.otus.homework2.service.BookCRUDService;

@ShellComponent
@RequiredArgsConstructor
public class BookShellController {

    private final BookCRUDService bookCRUDService;

    @ShellMethod(value = "Create book", key = {"cb", "CreateBook"})
    public void createBook() {
        bookCRUDService.create();
    }

    @ShellMethod(value = "Update book", key = {"ub", "UpdateBook"})
    public void updateBook() {
        bookCRUDService.update("survey.launched");
    }

    @ShellMethod(value = "Update book", key = {"ub", "UpdateBook"})
    public void deleteBook() {
        bookCRUDService.delete("survey.launched");
    }

}
