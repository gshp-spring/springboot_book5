-- security : user account
DROP table if EXISTS account;
create table account (
  account_name VARCHAR(255) not null,
  password VARCHAR(255) not null,
  id serial,
  enable bool DEFAULT true
);

drop table if EXISTS entity;
create table entity (
  id bigserial,
  created TIMESTAMP null,
  summary VARCHAR(255) null,
  title VARCHAR(255) null
);
