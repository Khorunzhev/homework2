package ru.khorunzhev.otus.homework2.repositories;

import ru.khorunzhev.otus.homework2.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {


    Comment insert(Comment comment);

    void update(Comment comment);

    Optional<Comment> getFullInfoById(long id);

    List<Comment> getAllFullInfo();

    void delete(Comment comment);

}
