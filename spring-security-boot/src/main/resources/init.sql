drop table if exists user;
create table user
(
    id        bigint(20) not null primary key comment '用户id',
    username  varchar(64),
    password  varchar(64),
    full_name varchar(255),
    mobile    varchar(11)

) engine innodb
  default charset = utf8;