--liquibase formatted sql

--changeset webmakaka:1
create table if not exists users (
    id integer primary key ,
    name varchar(100),
    address varchar(100)
);

create sequence if not exists users_sequence start 1000 increment 1;

--rollback drop table users;
--rollback drop sequence users_sequence;