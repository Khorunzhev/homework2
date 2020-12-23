package ru.khorunzhev.otus.homework2.model;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class Book {

    private Long id;
    private String title;
    private Long fk_author_id;
    private Long fk_genre_id;

}
