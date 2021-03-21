package ru.khorunzhev.otus.homework2.repositories;

import com.mongodb.client.result.UpdateResult;
import reactor.core.publisher.Mono;
import ru.khorunzhev.otus.homework2.model.Comment;

public interface BookRepositoryCustom {

    Mono<UpdateResult> removeCommentArrayElementsById(String id);
    Mono<UpdateResult> updateCommentArrayElementsById(Comment newComment);

}
