package ru.khorunzhev.otus.homework2.repositories;

import com.mongodb.BasicDBObject;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import ru.khorunzhev.otus.homework2.model.Book;

@RequiredArgsConstructor
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    private final MongoTemplate mongoTemplate;


    @Override
    public void removeCommentArrayElementsById(String id) {
        Update update =
                new Update().pull("comments",
                        new BasicDBObject("id", id));
        mongoTemplate.updateMulti(new Query(), update, Book.class);
    }

    @Override
    public void updateCommentArrayElementsById(String id) {

    }
}
