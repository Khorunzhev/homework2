package ru.khorunzhev.otus.homework2.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.reactivestreams.client.MongoDatabase;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.model.Genre;
import ru.khorunzhev.otus.homework2.repositories.AuthorRepository;
import ru.khorunzhev.otus.homework2.repositories.BookRepository;
import ru.khorunzhev.otus.homework2.repositories.CommentRepository;
import ru.khorunzhev.otus.homework2.repositories.GenreRepository;

import java.util.List;

@ChangeLog(order = "001")
public class DataBaseChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "khorunzhev", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertLibrary", author = "khorunzhev", runAlways = true)
    public void insertLibrary(AuthorRepository authorRepository,
                              GenreRepository genreRepository,
                              CommentRepository commentRepository,
                              BookRepository bookRepository) {
        Author authorIvanov = new Author("Иванов");
        authorRepository.save(authorIvanov);

        Author authorSidorov = new Author("Сидоров");
        authorRepository.save(authorSidorov);

        Genre genreFantastic = new Genre("Фантастика");
        genreRepository.save(genreFantastic);

        Genre genreDetective = new Genre("Детектив");
        genreRepository.save(genreDetective);

        Comment comment = new Comment("Коммент");
        commentRepository.save(comment);

        Book book = new Book("Name1", authorIvanov, genreDetective, List.of(comment));
        bookRepository.save(book);

    }

}