package ru.khorunzhev.otus.homework2.actuator.health;

import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;

import java.util.List;

@AllArgsConstructor
@Component
public class BooksHealthIndicator implements HealthIndicator {

    private static final String BOOK_ARE_NOT_EXIST_ERROR = "Книги отсутствуют :(";
    private static final String BOOK_EXIST = "Книги присутствуют :)";

    private final BookRepository bookRepository;

    @Override
    public Health health() {
        List<Book> lb = bookRepository.findAll();

        if (lb.size() == 0) {
            return Health.down()
                    .status(Status.OUT_OF_SERVICE)
                    .withDetail("message", BOOK_ARE_NOT_EXIST_ERROR)
                    .build();
        } else {
            return Health.up().withDetail("message", BOOK_EXIST).build();
        }
    }

}
