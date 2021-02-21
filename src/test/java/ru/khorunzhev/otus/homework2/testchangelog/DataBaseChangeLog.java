package ru.khorunzhev.otus.homework2.testchangelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;
import ru.khorunzhev.otus.homework2.model.Genre;

import java.util.List;

@ChangeLog(order = "001")
public class DataBaseChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "khorunzhev", runAlways = true)
    public void dropDb(MongoDatabaseFactory db) {
        db.getMongoDatabase().drop();
    }

    @ChangeSet(order = "002", id = "insertLibrary", author = "khorunzhev", runAlways = true)
    public void insertLibrary(MongoOperations mongoOperations) {
        Author authorIvanov = new Author("test-Иванов");
        mongoOperations.save(authorIvanov);

        Author authorSidorov = new Author("test-Сидоров");
        mongoOperations.save(authorSidorov);

        Genre genreFantastic = new Genre("test-Фантастика");
        mongoOperations.save(genreFantastic);

        Genre genreDetective = new Genre("test-Детектив");
        mongoOperations.save(genreDetective);

        Comment comment = new Comment("test-Коммент");
        mongoOperations.save(comment);

        Book book = new Book("test-Name1", authorIvanov, genreDetective, List.of(comment));
        mongoOperations.save(book);

    }

}