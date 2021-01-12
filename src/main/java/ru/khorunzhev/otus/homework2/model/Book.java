package ru.khorunzhev.otus.homework2.model;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "comment")
@EqualsAndHashCode(exclude = "comment")
@Builder
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private Genre genre;

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 3)
    @OneToMany(targetEntity = Comment.class, mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Comment> comment;

}
