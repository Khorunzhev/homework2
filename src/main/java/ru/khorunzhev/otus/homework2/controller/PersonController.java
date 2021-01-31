package ru.khorunzhev.otus.homework2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.service.BookService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class PersonController {

    private final BookService bookService;

    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        Person person = bookService.getBookByTitle(id).orElseThrow(NotFoundException::new);
        model.addAttribute("person", person);
        return "edit";
    }
    
    @PostMapping("/edit")
    public String savePerson(
            Person person,
            Model model
                            ) {
        Person saved = repository.save(person);
        model.addAttribute(saved);
        //Ошибка! Нужен редирект!
        return "edit";
    }
}
