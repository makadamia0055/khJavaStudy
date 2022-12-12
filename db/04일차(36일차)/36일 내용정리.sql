/*
DML
	-insert : 데이터 추가
    -update : 데이터 수정
	-delete : 데이터 삭제
	-select : 데이터 조회
    
insert
-문법
insert into 테이블명(속성1, 속성2, ... 속성n)
	values(값1, 값2, .... 값n); - 기입한 값의 개수와 기입한 속성의 개수는 같아야 한다.

insert into 테이블명 values(값1, 값2, ... 값n); 
-- 테이블명 뒤에 속성 기입은 생략가능하나 그러면 values에서 값들이 전체 테이블의 속성 개수와 순서에 맞아야한다. 

insert into 테이블명(속성1, 속성2, ...., 속성n)
	select 값1, 값2, ...., 값m, 속성1, 속성2, ... 속성n-m
		from 테이블명 [where 절]
-- 추가하려는 값을 검색으로 찾아 넣어야하는 경우 사용
    
    
.update
	-문법
update 테이블명 
	set 속성1 = 값1,
		속성2 = 값2,
        ...
        속성n = 값n
        where 절
        
delete from 테이블명 where 절


select
-문법 
select [distinct] 속성1, 속성2, ... 속성n from 테이블
	where절
    order by절
    limit절
    
- where절
	between A and begin
    in(값, 혹은 서브쿼리)
    all(값, 혹은 서브쿼리)
    any(값, 혹은 서브쿼리)
- order by절
	asc: 오름차순(생략시 기본적용) desc :내림차순
    

		
*/