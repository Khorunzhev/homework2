package ru.khorunzhev.otus.homework2.events;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;

@Component
@RequiredArgsConstructor
public class MongoCommentCascadeDeleteEventsListener extends AbstractMongoEventListener<Comment> {

    private final BookRepository bookRepository;

    @Override
    public void onAfterDelete(AfterDeleteEvent<Comment> event) {
        super.onAfterDelete(event);
        val source = event.getSource();
        val id = source.get("_id").toString();
        bookRepository.removeCommentArrayElementsById(id);
    }

    @Override
    public void onAfterSave(AfterSaveEvent<Comment> event) {
        super.onAfterSave(event);
        Comment source = event.getSource();
        bookRepository.updateCommentArrayElementsById(source);
    }
}