/*
DMS

CRUD
- create => insert : 데이터를 DBMS에 추가
- read 	=> 	select : DBMS에 있는 데이터를 조회
- update => update : DBMS에 있는 데이터를 수정
- delete => delete : DBMD에 있는 데이터를 삭제

CF) CREATE table ... select
	-기존 테이블 검색 결과 이용하여 새 테이블 생성
		- 단 제약조건은 복사가 안됨(외래키 같은)
		- 검색된 데이터들도 추가 됨.
        - 기존 운영되는 데이터들을 복사해서 사용할 필요가 있을때 사용.
*/
        
select * from board;
create table board2(select bo_num as num, bo_title as title, bo_contents as contents, bo_reg_date as reg_date,  bo_views as views, bo_me_id as writer from board);
select * from board2;

/*
SELECT 문 문법

SELECT [ALL|DISTINCT|DISTINCTROW] - 중복과 관련된 명령어(다 보여주기-디폴트|중복제거|행별로 중복제거
	select_expression - 선택의 대상, 함수, 식 기술. 
    최소 1개의 열람 대상 기술 필요. 다중으로 선택 가능
    [FROM table_raferences
    [WHERE ]
    [GROUP BY {col_name | expr | position] -> 집계함수를 사용하는 부분
    [HAVING where_condition] -> 집계함수의 조건을 지어주는 부분
    [ORDER BY ]
    
*/

