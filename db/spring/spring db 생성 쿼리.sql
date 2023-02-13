 
DROP database if exists spring;

create database if not exists spring;

use spring;

drop table if exists `member`;


CREATE TABLE `member` (
	`me_id`	varchar(13)	NOT NULL,
	`me_pw`	varchar(255)	not NULL,
	`me_email`	varchar(50)	not NULL,
	`me_birthday`	date	not NULL,
	`me_authority`	int	not NULL default 0,
	`me_join_time`	datetime	NULL
);
drop table if exists `member_ok`;


CREATE TABLE `member_ok` (
	`mo_me_id`	varchar(13)	NOT NULL,
	`mo_num`	char(6)	not NULL,
	`mo_valid_time`	datetime	not NULL
);
drop table if exists `board`;
CREATE TABLE `board` (
	`bo_num`	int auto_increment	NOT NULL primary key,
	`bo_title`	varchar(50)	not NULL,
	`bo_content`	longtext	not NULL,
	`bo_register_date`	datetime default now()	not NULL,
	`bo_update_date`	datetime	NULL,
	`bo_views`	int default 0	not NULL,
	`bo_up`	int default 0	not NULL,
	`bo_down`	int default 0	not NULL,
	`bo_ori_num`	int	NOT NULL,
	`bo_me_id`	varchar(13)	NOT NULL,
	`bo_bt_num`	int	NOT NULL
);

drop table if exists `file`;
CREATE TABLE `file` (
	`fi_num`	int auto_increment	NOT NULL primary key,
	`fi_ori_name`	varchar(50)	not NULL,
	`fi_name`	varchar(255)	not NULL,
	`fi_bo_num`	int	NOT NULL
);
drop table if exists `board_type`;

CREATE TABLE `board_type` (
	`bt_num`	int auto_increment	NOT NULL primary key,
	`bt_type`	varchar(10)	not NULL,
	`bt_name`	varchar(50)	not NULL,
	`bt_r_autority`	int	not NULL default 0,
	`bt_w_autority`	int	not NULL default 1
);
drop table if exists `comment`;

CREATE TABLE `comment` (
	`co_num`	int auto_increment	NOT NULL primary key,
	`co_content`	longtext	not NULL,
	`co_register_date`	dateTime	not NULL default now(),
	`co_update_date`	datetime	NULL,
	`co_ori_num`	int	NOT NULL,
	`co_me_id`	varchar(13)	NOT NULL,
	`co_bo_num`	int	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `member_ok` ADD CONSTRAINT `PK_MEMBER_OK` PRIMARY KEY (
	`mo_me_id`
);


ALTER TABLE `member_ok` ADD CONSTRAINT `FK_member_TO_member_ok_1` FOREIGN KEY (
	`mo_me_id`
)
REFERENCES `member` (
	`me_id`
);

