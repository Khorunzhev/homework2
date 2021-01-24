package ru.khorunzhev.otus.homework2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "comment")
@EqualsAndHashCode(exclude = "comment")
@Builder
@Document(value = "book")
public class Book {

    @Id
    private String id;

    private String title;

    private Author author;

    private Genre genre;

    private Set<Comment> comment;

}
