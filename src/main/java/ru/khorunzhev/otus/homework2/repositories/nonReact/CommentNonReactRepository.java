package ru.khorunzhev.otus.homework2.repositories.nonReact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.khorunzhev.otus.homework2.model.Comment;


public interface CommentNonReactRepository extends MongoRepository<Comment, String> {

}
