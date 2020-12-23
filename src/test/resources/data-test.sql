insert into AUTHOR (`FULLNAME`) values ('Тест Автор1');
insert into AUTHOR (`FULLNAME`) values ('Тест Автор2');

insert into GENRE (`NAME`) values ('Тест жанр1');
insert into GENRE (`NAME`) values ('Тест жанр2');


insert into BOOK (`TITLE`, AUTHOR_ID, GENRE_ID) values ('Тест1', 1, 1);
insert into BOOK (`TITLE`, AUTHOR_ID, GENRE_ID) values ('Тест2', 2, 2);
insert into BOOK (`TITLE`, AUTHOR_ID, GENRE_ID) values ('Тест3', 1, 2);
