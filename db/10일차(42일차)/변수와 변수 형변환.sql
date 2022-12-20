-- 변수 선언 방법 set @변수명 = 값;
-- 변수 값 출력 selece @변수명;

set @num = 10; -- @num에 10을 저장
select @num; -- @num을 출력
select @num :=20; -- @num에 20을 저장하고 출력
-- @num -- 일반변수 : 세션이 종료되면 없어지는 변수
-- @@sql_mode -- 글로벌 변수 : 글로벌적으로 저장되는 변수는 @@를 붙임.
show variables; -- 전역 변수들을 조회하는 명령어
-- 변수 형변환 함수 cast( 변환값 as 데이터형) convert(변환값, 데이터형)
-- 실수 1.23을 정수 1로 변환
select cast(1.23 as signed integer);
select convert(1.23 , signed integer);