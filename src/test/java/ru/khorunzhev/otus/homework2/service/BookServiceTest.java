package ru.khorunzhev.otus.homework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.khorunzhev.otus.homework2.dao.AuthorDao;
import ru.khorunzhev.otus.homework2.dao.BookDao;
import ru.khorunzhev.otus.homework2.dao.GenreDao;
import ru.khorunzhev.otus.homework2.model.Book;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class BookServiceTest {

    @Autowired
    private BookServiceImpl bookService;


    @MockBean
    private BookDao bookDao;
    @MockBean
    private GenreDao genreDao;
    @MockBean
    private AuthorDao authorDao;

    @Test
    public void checkBookUpdate() {


    }

}
