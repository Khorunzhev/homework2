package ru.khorunzhev.otus.homework2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(value = "book")
public class Book {

    @Id
    private String id;

    private String title;

    private Author author;

    private Genre genre;

    @DBRef
    private List<Comment> comments;

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

    public Book(String title, Author author, Genre genre, List<Comment> comments) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.comments = comments;
    }

}
