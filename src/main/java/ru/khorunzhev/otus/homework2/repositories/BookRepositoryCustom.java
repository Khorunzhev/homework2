package ru.khorunzhev.otus.homework2.repositories;


import ru.khorunzhev.otus.homework2.model.Comment;

public interface BookRepositoryCustom {

    void removeCommentArrayElementsById(String id);
    void updateCommentArrayElementsById(Comment newComment);

}
