create table users (
  username varchar(256),
  password varchar(256),
  enabled boolean
);

create table authorities (
  username varchar(256),
  authority varchar(256)
);

insert into users (username, password, enabled) values ('user', 'user', true);

insert into authorities (username, authority) values ('user', 'ROLE_ADMIN');