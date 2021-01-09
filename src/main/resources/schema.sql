DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS AUTHOR;
DROP TABLE IF EXISTS GENRE;

CREATE TABLE BOOK(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    TITLE VARCHAR(255));

CREATE TABLE AUTHOR(
   ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
   FULLNAME VARCHAR(255),
   BOOK_ID BIGINT,
   CONSTRAINT FK_BOOK_AUTHOR_ID FOREIGN KEY (BOOK_ID) REFERENCES BOOK(ID));

CREATE TABLE GENRE(
  ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  NAME VARCHAR(255),
  BOOK_ID BIGINT,
  CONSTRAINT FK_BOOK_GENRE_ID FOREIGN KEY (BOOK_ID) REFERENCES BOOK(ID));

CREATE TABLE COMMENT(
  ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  TEXT VARCHAR(255),
  BOOK_ID BIGINT,
  CONSTRAINT FK_BOOK_COMMENT_ID FOREIGN KEY (BOOK_ID) REFERENCES BOOK(ID));