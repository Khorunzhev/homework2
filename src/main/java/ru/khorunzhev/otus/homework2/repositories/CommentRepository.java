package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.khorunzhev.otus.homework2.model.Comment;


public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {

}
