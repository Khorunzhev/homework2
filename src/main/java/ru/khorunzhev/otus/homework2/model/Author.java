package ru.khorunzhev.otus.homework2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Data
@Document(value = "author")
public class Author {

    @Id
    private String id;
    private String fullName;

    public Author (String fullName) {
        this.fullName = fullName;
    }
}
