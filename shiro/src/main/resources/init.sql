create database if not exists shiro collate utf8mb4_bin;

drop table if exists user ;
create table user(
id bigint primary key auto_increment comment '主键' ,
username varchar(40) comment '角色名称',
password varchar(40) comment '密码',
salt varchar(40) comment '盐',
index idx_un(username)
)ENGINE=InnoDB charset =utf8mb4 comment '角色表';

drop table if exists role ;
create table role(
id bigint primary key auto_increment comment '主键' ,
name varchar(60) comment '角色名称',
index idx_name(name)
)ENGINE=InnoDB charset =utf8mb4 comment '角色表';

drop table if exists perm;
create table perm(
id bigint primary key auto_increment comment '主键' ,
name varchar(80) comment '权限字符串',
url varchar(256) comment '权限url',
index idx_name(name)
)ENGINE=InnoDB charset =utf8mb4 comment '权限表';

drop table if exists user_role;
create table user_role(
id bigint primary key auto_increment comment '主键' ,
user_id bigint comment '用户id',
role_id bigint comment '角色id',
index idx_uid(user_id),
index idx_rid(role_id)
)ENGINE=InnoDB charset =utf8mb4 comment '用户角色映射表';

drop table if exists role_perm;
create table role_perm(
id bigint primary key auto_increment comment '主键' ,
role_id bigint comment '角色id',
perm_id bigint comment '权限id',
index idx_pid(perm_id),
index idx_rid(role_id)
)ENGINE=InnoDB charset =utf8mb4 comment '用户权限角色表';


