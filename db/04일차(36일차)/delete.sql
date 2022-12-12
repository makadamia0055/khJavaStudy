-- delete 문
/*
-- delete from 테이블명 where 조건절;
-- 조건절에는 일반적으로 기본키가 옴.

*/
select * from board_category;

-- 3번 카테고리인 문의 카테고리를 제거하는 쿼리문

delete from board_category
	where bc_num = 3;

-- board_category에 새로운 값을 추가해도 삭제된 3번이 아닌 4번으로 작성됨.
-- auto_increment는 값을 기억함. 

select * from board_category;
