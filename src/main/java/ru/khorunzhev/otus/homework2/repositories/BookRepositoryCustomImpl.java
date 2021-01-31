package ru.khorunzhev.otus.homework2.repositories;

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
        val query = Query.query(Criteria.where("$id").is(new ObjectId(id)));
        val update = new Update().pull("comments", query);
        mongoTemplate.updateMulti(new Query(), update, Book.class);
    }

    @Override
    public void updateCommentArrayElementsById(String id) {

    }
}
