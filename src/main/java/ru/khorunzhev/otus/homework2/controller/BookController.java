package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Genre;
import ru.khorunzhev.otus.homework2.service.AuthorService;
import ru.khorunzhev.otus.homework2.service.BookService;
import ru.khorunzhev.otus.homework2.service.GenreService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    @GetMapping("/")
    public String listPage(Model model) {
        Flux<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);

        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);

        model.addAttribute("book", new Book());

        return "edit";
    }

    @PostMapping("/create")
    public String editPage(Book book) {
        bookService.updateBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") String id, Model model) {
        Mono<Book> book = bookService.getBookById(id);
        model.addAttribute("book", book);

        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);

        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);

        return "edit";
    }
    
    @PostMapping("/edit")
    public String saveBook(Book book, Model model) {
        Mono<Book> saved = bookService.updateBook(book);
        model.addAttribute(saved);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") String id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
