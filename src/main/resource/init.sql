create database if not exists parking default charset='utf8';

create table if not exists t_order (
    id int unsigned primary key auto_increment comment "主键",
    order_id varchar(50) not null default '' comment '订单ID',
    car_no varchar(8) not null default '' comment '车牌',
    enter_time datetime not null default '1971-01-01 00:00:01' comment '入场时间',
    out_time datetime not null default '1971-01-01 00:00:01' comment '出场时间',
    fee decimal(10, 1) not null default '0.0' comment '停车费',
    status tinyint not null default 0 comment '状态',
    gmt_create timestamp not null default '1971-01-01 00:00:01' comment '订单创建时间',
    gmt_update timestamp not null default '1971-01-01 00:00:01' on update current_timestamp comment '订单修改时间'
) engine=InnoDB default charset='utf8';
