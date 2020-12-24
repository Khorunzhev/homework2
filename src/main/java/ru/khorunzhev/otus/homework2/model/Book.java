package ru.khorunzhev.otus.homework2.model;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
public class Book {

    private Long id;
    private String title;
    private Author author;
    private Genre genre;

}
