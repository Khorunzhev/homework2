insert into AUTHOR (`FULLNAME`) values ('Иванов Иван Иванович');
insert into AUTHOR (`FULLNAME`) values ('Сидоров Сидоро Сидорович');

insert into GENRE (`NAME`) values ('Фантастика');
insert into GENRE (`NAME`) values ('Детектив');


insert into BOOK (`TITLE`, FK_AUTHOR_ID, FK_GENRE_ID) values ('BOOK NAME1', 1, 1);
insert into BOOK (`TITLE`, FK_AUTHOR_ID, FK_GENRE_ID) values ('BOOK NAME2', 2, 2);
insert into BOOK (`TITLE`, FK_AUTHOR_ID, FK_GENRE_ID) values ('BOOK NAME3', 1, 2);
