drop table if exists test.user;
create table test.user
(
    id        bigint(20) not null primary key auto_increment comment '用户id',
    username  varchar(64),
    password  varchar(64),
    full_name varchar(255),
    mobile    varchar(11)

) engine innodb
  default charset = utf8;
INSERT INTO test.user (id, username, password, full_name, mobile)
VALUES (1, 'zhangsan', '123', 'zhangsan', '1111'),
       (2, 'lisi', '456', 'lisi', '2222');


drop table if exists test.role;
create table test.role
(
    id          bigint primary key auto_increment,
    role_name   varchar(255),
    description varchar(255),
    create_time datetime,
    update_time datetime,
    status      char
) engine innodb
  default charset = utf8;
insert into test.role(id, role_name, description, create_time, update_time, status)
values (1, 'role1', 'role1', now(), now(), 1),
       (2, 'role2', 'role2', now(), now(), 1);



drop table if exists test.user_role;
create table test.user_role
(
    user_id     bigint,
    role_id     bigint,
    create_time datetime,
    update_time datetime
) engine innodb
  default charset = utf8;
insert into test.user_role(user_id, role_id, create_time, update_time)
VALUES (1, 1, now(), now()),
       (2, 2, now(), now());



drop table if exists test.permission;
create table test.permission
(
    id          bigint auto_increment primary key,
    code        varchar(255),
    description varchar(255),
    url         varchar(255)
) engine innodb
  default charset = utf8;

insert into test.permission(id, code, description, url)
VALUES (1, 'p1', '测试资源p1', '/r1'),
       (2, 'p2', '测试资源p2', '/r2');


drop table if exists test.role_permission;
create table test.role_permission
(
    role_id       bigint,
    permission_id bigint
) engine innodb
  default charset = utf8;
insert into test.role_permission(role_id, permission_id)
VALUES (1, 1),
       (2, 2);

