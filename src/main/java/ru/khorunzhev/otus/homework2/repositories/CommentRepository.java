package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khorunzhev.otus.homework2.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {

}
