-- 프로시저 
-- 쿼리의 집합으로 어떠한 동작을 일괄 처리하는 데 사용
-- 자바로 치면 메소드
/*
형식
DELIMITER $$ (문장의 끝을 의미함. 즉 문장의 끝을 $$로 표기하겠다. 기호는 마음대로 정해도 됨.)
CREATE PROCEDURE 스토어드프로시저이름()
([ [IN | OUT ] parameter_name
	{ parameter_type | array of parameter_type}, ...
])
[ DECLARE  variable_declaration; ...[;]
BEGIN
	-- SQL 코딩
END $$
DELIMITER ; (다시 세미콜론으로 종결 연산자를 바꿔줌)


*/ -- call 로 호출


Drop procedure if exists TEST1;
delimiter $$
create procedure Test1()
begin
	show databases;
end $$
delimiter ;
call test1;

Drop procedure if exists TEST2;
delimiter $$
create procedure Test2(
	in num int, -- in out 들어오는 값, 나가는 값을 명시, 매개변수 리턴값.
    out out_num int )
begin
	select out_num;
    set out_num = num;
end $$
delimiter ;
set @T_num = 0;
call test2(2, @t_num);
select @T_num;

use cgv;

Drop procedure if exists member_movie_count;
delimiter $$
create procedure member_movie_count(
	in _id varchar(20)
    )
begin
	-- 지역변수 선언은 위에 모아줘야 함. 
	declare _movie_count int default 0;
		with ticketing_count(ss_mo_num, movie_ticketing_count)
		 as 
		 (select ss_mo_num, count(*) from ticketing
			join screen_schedule on ti_ss_num = ss_num
			where ti_me_id like _id
			group by ss_mo_num) -- 영화별 예매 횟수, 
		select @num:=count(movie_ticketing_count) from ticketing_count;
		set _movie_count = (select @num);
        update member set me_movie_count = _movie_count where me_id = _id;
end $$
    delimiter ;
call member_movie_count('abc');