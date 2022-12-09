-- 빼기 빼기 띄우고 주석;

-- test 데이터베이스가 존재하지 않으면 하나 생성;
-- 왼쪽에 navigator에서 우클릭 create schemas
-- create database if not exists test;

-- test 데이터베이스 선택;
use test;

-- test 데이터베이스가 존재하면 삭제;
-- drop database if exists test;

-- member 테이블 생성
-- 속성으로 id(최대문자열13, 기본키), 비번(최대문자열 20), 이름을 가짐
Create table if not exists member(
	id varchar(13) primary key, 
    pw varchar(20) not null,
    name varchar(30) not null
);

-- auto_increment : 기본키만 가능, 테이블당 최대 1개만 설정 가능, 자동 증가;
create table board(
	num int auto_increment primary key, 
    title varchar(50) not null, 
    contents longtext not null, 
    -- 부모키의 형식과 맞춰야
    writer varchar(13) not null,
    foreign key(writer) references member(id)
);
-- board 테이블에 조회수 추가
alter table board add views int default 0;

-- board 테이블 조회수 삭제
alter table board drop views;

-- board 테이블 잘못된 조회수 추가
alter table board add views varchar(10);

-- board 테이블 잘못된 조회수 수정
alter table board modify views int default 0;

-- 컬럼 이름만 수정하는 경우 change 기존컬럼명 새컬럼명 데이터타입;
-- 조회수 이름을 views2로 변경
alter table board change views views2 int;

alter table board change views2 views int;

-- board_ibfk_1 제약조건 삭제;
alter table board drop constraint board_ibfk_1;

-- board 테이블에 writer와 member테이블의 id를 외래키로 연결(제약조건 추가);
alter table board add constraint fk_board_writer foreign key(writer) references member(id);

-- 워크벤치에서 추가한 board2 테이블 삭제;
drop table if exists board2;
