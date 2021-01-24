package ru.khorunzhev.otus.homework2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(value = "genre")
public class Genre {

    @Id
    private String id;
    private String name;

    public Genre (String name) {
        this.name = name;
    }

}
