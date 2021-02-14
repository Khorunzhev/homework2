package ru.khorunzhev.otus.homework2.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.internal.MongoDatabaseImpl;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.model.Genre;
import ru.khorunzhev.otus.homework2.repositories.nonReact.AuthorNonReactRepository;
import ru.khorunzhev.otus.homework2.repositories.nonReact.BookNonReactRepository;
import ru.khorunzhev.otus.homework2.repositories.nonReact.CommentNonReactRepository;
import ru.khorunzhev.otus.homework2.repositories.nonReact.GenreNonReactRepository;

import java.util.List;

@ChangeLog(order = "001")
public class DataBaseChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "khorunzhev", runAlways = true)
    public void dropDb(MongoDatabaseFactory db) {
        db.getMongoDatabase().drop();
    }

    @ChangeSet(order = "002", id = "insertLibrary", author = "khorunzhev", runAlways = true)
    public void insertLibrary(AuthorNonReactRepository authorRepository,
                              GenreNonReactRepository genreRepository,
                              CommentNonReactRepository commentRepository,
                              BookNonReactRepository bookRepository) {
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