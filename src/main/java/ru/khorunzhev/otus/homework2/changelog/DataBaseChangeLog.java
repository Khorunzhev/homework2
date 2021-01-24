package ru.khorunzhev.otus.homework2.changelog;

public class DataBaseChangeLog {

    @ChangeSet(order = "001", id = "dropDb", author = "stvort", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

}
