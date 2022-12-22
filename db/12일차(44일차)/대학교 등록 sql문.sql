DROP DATABASE IF EXISTS UNIVERSITY;

CREATE DATABASE IF NOT EXISTS UNIVERSITY;

USE UNIVERSITY;

CREATE TABLE `student` (
	`st_num`	char(10) primary key,
	`st_name`	varchar(20) not null	,
	`st_pr_num`	char(10) ,
	`st_semester`	int not null default(1),
	`st_state`	varchar(20) not null default('재학')
);

CREATE TABLE `professor` (
	`pr_num`	char(10) primary key,
	`pr_name`	varchar(20) not null	,
	`pr_ssn`	char(14) not null,
	`pr_de_num`	CHAR(3)	NOT NULL,
	`pr_state`	varchar(20)	NULL
);

CREATE TABLE `department` (
	`de_num`	char(3) primary key	,
	`de_name`	varchar(20) not null	,
	`de_address`	varchar(20) not null	,
	`de_tel`	varchar(20)	NOT NULL,
	`de_pr_num`	char(10) 
);

CREATE TABLE `lecture` (
	`le_num`	int primary key auto_increment,
	`le_pr_num`	char(10) not null,
	`le_capacity`	int not null	,
	`le_current_capa`	int default(0)	,
	`le_room`	varchar(20)	,
	`le_schedule`	VARCHAR(50) NOT NULL DEFAULT(''),
	`le_point`	int	NOT NULL DEFAULT(0),
	`le_year`	int	NOT NULL,
	`le_term`	VARCHAR(5)	NOT NULL,
	`le_class`	int	NOT NULL DEFAULT(1)
);

CREATE TABLE `course` (
	`co_num`	int primary key auto_increment,
	`co_le_num`	int not null,
	`co_st_num`	char(10) not null,
	`co_type`	varchar(5)	NOT NULL DEFAULT('학점'),
	`co_grade`	varchar(5)	NOT NULL DEFAULT('')
);

CREATE TABLE `major` (
	`ma_num`	int auto_increment	PRIMARY KEY,
	`ma_de_num`	char(3) NOT NULL,
	`ma_st_num`	char(10) NOT NULL,
	`ma_state`	varchar(10) NOT	NULL DEFAULT('전공')
);

CREATE TABLE `score` (
	`sc_num`	int primary key auto_increment,
	`sc_mid`	int not null default(0),
	`sc_final`	int not null default(0),
	`sc_homework`	int not null default(0),
	`sc_attendance`	int not null default(0),
	`sc_total`	int not null default(0),
	`sc_co_num`	int not null
);


ALTER TABLE `student` ADD CONSTRAINT `FK_professor_TO_student_1` FOREIGN KEY (
	`st_pr_num`
)
REFERENCES `professor` (
	`pr_num`
);

ALTER TABLE `professor` ADD CONSTRAINT `FK_department_TO_professor_1` FOREIGN KEY (
	`pr_de_num`
)
REFERENCES `department` (
	`de_num`
);

ALTER TABLE `department` ADD CONSTRAINT `FK_professor_TO_department_1` FOREIGN KEY (
	`de_pr_num`
)
REFERENCES `professor` (
	`pr_num`
);

ALTER TABLE `lecture` ADD CONSTRAINT `FK_professor_TO_lecture_1` FOREIGN KEY (
	`le_pr_num`
)
REFERENCES `professor` (
	`pr_num`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_lecture_TO_course_1` FOREIGN KEY (
	`co_le_num`
)
REFERENCES `lecture` (
	`le_num`
);

ALTER TABLE `course` ADD CONSTRAINT `FK_student_TO_course_1` FOREIGN KEY (
	`co_st_num`
)
REFERENCES `student` (
	`st_num`
);

ALTER TABLE `major` ADD CONSTRAINT `FK_department_TO_major_1` FOREIGN KEY (
	`ma_de_num`
)
REFERENCES `department` (
	`de_num`
);

ALTER TABLE `major` ADD CONSTRAINT `FK_student_TO_major_1` FOREIGN KEY (
	`ma_st_num`
)
REFERENCES `student` (
	`st_num`
);

ALTER TABLE `score` ADD CONSTRAINT `FK_course_TO_score_1` FOREIGN KEY (
	`sc_co_num`
)
REFERENCES `course` (
	`co_num`
);

