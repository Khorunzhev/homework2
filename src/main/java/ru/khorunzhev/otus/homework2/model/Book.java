package ru.khorunzhev.otus.homework2.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Book {

    private final Long id;
    private final String title;

}
