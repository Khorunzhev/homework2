package ru.khorunzhev.otus.homework2.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Book {

    private final Long id;
    private final String title;
    private final Long fk_author_id;
    private final Long fk_genre_id;

}
