package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.service.BookService;
import ru.khorunzhev.otus.homework2.service.CommentService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class CommentShellController {

    private final CommentService commentService;

    @ShellMethod(value = "Create comment", key = {"cm", "CreateComment"})
    public void createComment(String text, String bookTitle) {
        commentService.createComment(text, bookTitle);
    }

    @ShellMethod(value = "Update comment", key = {"uc", "UpdateComment"})
    public void updateComment(@ShellOption({"curID", "ci"}) String curId, @ShellOption({"newText", "nt"})  String newText) {
        commentService.updateComment(curId, newText);
    }

    @ShellMethod(value = "Delete comment", key = {"dc", "DeleteComment"})
    public void deleteComment(String id) {
        commentService.deleteComment(id);
    }

    @ShellMethod(value = "Get all comment", key = {"allc", "GetAllComments"})
    public Iterable<Comment> getAllComments() {
        return commentService.getAllComments();
    }
}
