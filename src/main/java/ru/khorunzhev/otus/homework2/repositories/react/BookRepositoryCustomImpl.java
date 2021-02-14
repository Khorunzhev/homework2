package ru.khorunzhev.otus.homework2.repositories.react;

import com.mongodb.BasicDBObject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;

@RequiredArgsConstructor
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private final ReactiveMongoTemplate mongoTemplate;

    @Override
    public void removeCommentArrayElementsById(String id) {
        Update update =
                new Update().pull("comments",
                        new BasicDBObject("id", id));
        mongoTemplate.updateMulti(new Query(), update, Book.class);
    }


    @Override
    public void updateCommentArrayElementsById(Comment newComment) {
        mongoTemplate.updateMulti(
                new Query(Criteria.where("comments._id").is(newComment.getId())),
                new Update().set("comments.$.text", newComment.getText()),
                Book.class
        );

    }
}