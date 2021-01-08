package ru.khorunzhev.otus.homework2.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "GENRE")
public class Genre {

    private Long id;
    private String name;

}
