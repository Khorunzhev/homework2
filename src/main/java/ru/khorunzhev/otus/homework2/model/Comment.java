package ru.khorunzhev.otus.homework2.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString(exclude = "id")
@Document(value = "comment")
public class Comment {

    @Id
    private String id;
    private String text;

    Book book;

    public Comment(String text, Book book) {
        this.text = text;
        this.book = book;
    }

}
