package ru.khorunzhev.otus.homework2.events;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.repositories.CommentRepository;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MongoBookCascadeSaveEventsListener extends AbstractMongoEventListener<Book> {

    private final CommentRepository commentRepository;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        super.onBeforeConvert(event);
        val book = event.getSource();
        if (book.getComments() != null) {
            book.getComments().stream().filter(e -> Objects.isNull(e.getId())).forEach(commentRepository::save);
        }
    }
}
