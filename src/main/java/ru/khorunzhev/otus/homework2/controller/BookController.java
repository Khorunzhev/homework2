package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.service.BookService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        return "edit";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") Long id, Model model) {
        Book book = bookService.getBookById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("book", book);
        return "edit";
    }
    
    @PostMapping("/edit")
    public String saveBook(Book book, Model model) {
        Book saved = bookService.updateBook(book);
        model.addAttribute(saved);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
