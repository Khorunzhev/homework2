insert into AUTHOR (`FULLNAME`) values ('ТестИванов');
insert into AUTHOR (`FULLNAME`) values ('ТестСидоров');

insert into GENRE (`NAME`) values ('ТестФантастика');
insert into GENRE (`NAME`) values ('ТестДетектив');

insert into BOOK (`TITLE`, AUTHOR_ID, GENRE_ID) values ('TESTNAME1', 1, 1);
insert into BOOK (`TITLE`, AUTHOR_ID, GENRE_ID) values ('TESTNAME2', 2, 2);
insert into BOOK (`TITLE`, AUTHOR_ID, GENRE_ID) values ('TESTNAME3', 1, 1);

insert into COMMENT (`TEXT`, BOOK_ID) values ('ТестКоммент', 1);
