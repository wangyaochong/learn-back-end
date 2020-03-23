create database if not exists tx default character set utf8;

create table tx.account
(
    id       bigint primary key auto_increment comment '主键',
    username varchar(20) comment '用户名',
    balance  decimal(18, 2) comment '账户余额'
) ENGINE = InnoDB
  charset = utf8 comment '账户表';

insert into tx.account(username, balance)
values ('Jerry', 800),
       ('Tom', 10000);

create table tx.book
(
    id        bigint primary key auto_increment comment '主键',
    book_name varchar(30) comment '书名',
    price     decimal(10, 2) comment '价格'
) engine = InnoDB
  charset = utf8 comment '图书表';

insert into tx.book(book_name, price)
values ('三国演义', 10),
       ('红楼梦', 20),
       ('水浒传', 30);

create table tx.book_stock
(
    id      bigint primary key auto_increment comment '主键',
    book_id bigint comment '图书id',
    stock   int comment '库存'
) engine = InnoDB
  charset = utf8 comment '图书库存表';
insert into tx.book_stock(book_id, stock)
values (1, 50),
       (2, 100),
       (3, 150);
