DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS AUTHOR;
DROP TABLE IF EXISTS GENRE;


CREATE TABLE AUTHOR(
       ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
       FULLNAME VARCHAR(255));

CREATE TABLE GENRE(
      ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
      NAME VARCHAR(255));

CREATE TABLE BOOK(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    TITLE VARCHAR(255),
    AUTHOR_ID BIGINT REFERENCES AUTHOR(ID),
    GENRE_ID BIGINT REFERENCES GENRE(ID)
    );

CREATE TABLE COMMENT(
  ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  TEXT VARCHAR(255),
  BOOK_ID BIGINT);