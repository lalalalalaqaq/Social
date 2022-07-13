# 第一次执行
create database my_db;

use my_db;

# 用户表
create table my_db.user
(
    id bigint auto_increment comment 'id'
        primary key,
    username varchar(256) null comment '用户昵称',
    userAccount varchar(256) null comment '账号',
    avatarUrl varchar(1024) null comment '用户头像',
    gender tinyint null comment '性别',
    userPassword varchar(512) not null comment '密码',
    phone varchar(128) null comment '电话',
    email varchar(512) null comment '邮箱',
    userStatus int default 0 not null comment '状态 0 - 正常',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete tinyint default 0 not null comment '是否删除',
    userRole int default 0 not null comment '用户角色 0 - 普通用户 1 - 管理员',
    fanscount int default 0 null comment '粉丝数',
    followcount int default 0 null comment '关注数',
    lastdate timestamp null comment '最后登录时间'
)comment '用户';


create table my_db.subscribe
(
    id int auto_increment
        primary key,
    be_subuser varchar(256) not null comment '被关注用户',
    subuser varchar(256) not null comment '关注者/粉丝',
    isDelete int default 0 null comment '0:仍在关注 1:取关',
    createTime datetime default CURRENT_TIMESTAMP not null comment '第一次建立关系的时间',
    updateTime datetime default CURRENT_TIMESTAMP not null comment '关系变动最新时间'
) comment '关注表';





