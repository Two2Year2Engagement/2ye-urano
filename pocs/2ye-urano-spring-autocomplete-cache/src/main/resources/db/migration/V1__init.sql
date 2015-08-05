CREATE TABLE PERSON (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY,
	first_name varchar(255) not null,
	last_name varchar(255) not null
);

insert into PERSON (first_name, last_name) values ('Dave', 'Syer');
insert into PERSON (first_name, last_name) values ('Dave', 'Hola');
insert into PERSON (first_name, last_name) values ('Dave', 'John');
insert into PERSON (first_name, last_name) values ('Rafa', 'Silva');
insert into PERSON (first_name, last_name) values ('Rafa', 'Pereira');
insert into PERSON (first_name, last_name) values ('Rafa', 'Santos');
insert into PERSON (first_name, last_name) values ('Rafael', 'Alemao');
insert into PERSON (first_name, last_name) values ('ElRafa', 'Mexicano');
insert into PERSON (first_name, last_name) values ('Pedro', 'Pereira');
insert into PERSON (first_name, last_name) values ('Pedro', 'Jeronimo');
insert into PERSON (first_name, last_name) values ('Pedro', 'Caseiro');
insert into PERSON (first_name, last_name) values ('João', 'Santos');
insert into PERSON (first_name, last_name) values ('João', 'Luiz');
insert into PERSON (first_name, last_name) values ('João', 'Felipe');