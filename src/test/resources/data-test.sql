insert into BOOK (`TITLE`) values ('NAME1');
insert into BOOK (`TITLE`) values ('NAME2');
insert into BOOK (`TITLE`) values ('NAME3');

insert into AUTHOR (`FULLNAME`, BOOK_ID) values ('Иванов', 1);
insert into AUTHOR (`FULLNAME`, BOOK_ID) values ('Сидоров', 2);
insert into AUTHOR (`FULLNAME`, BOOK_ID) values ('Иванов', 3);

insert into GENRE (`NAME`, BOOK_ID) values ('Фантастика', 1);
insert into GENRE (`NAME`, BOOK_ID) values ('Детектив', 2);
insert into GENRE (`NAME`, BOOK_ID) values ('Детектив', 3);

insert into COMMENT (`TEXT`, BOOK_ID) values ('Коммент', 1);
