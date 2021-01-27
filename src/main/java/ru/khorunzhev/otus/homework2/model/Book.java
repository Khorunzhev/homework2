package ru.khorunzhev.otus.homework2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@NoArgsConstructor
@Data
@Builder
@Document(value = "book")
public class Book {

    @Id
    private String id;

    private String title;

    private Author author;

    private Genre genre;

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public Book(String id, String title, Author author, Genre genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public Book(String id, String title, Author author, Genre genre, Set<Comment> comments) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

}
