package ru.khorunzhev.otus.homework2.repositories;

import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Comment;

public interface BookRepositoryCustom {

    Mono removeCommentArrayElementsById(String id);
    Mono updateCommentArrayElementsById(Comment newComment);

}
