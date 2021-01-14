package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.khorunzhev.otus.homework2.model.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long> {

}
