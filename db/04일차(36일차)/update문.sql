/*
-- 열명 A의 값이 값A인 행에서, 열1의 값을 값1로, 열2의 값을 값2로, ....열n의 값을 n으로 수정하는 쿼리문
-- 일반적으로 where의 대상이 되는 열명A에는 기본키 명을 사용.
-- where = 조건절.
-- update 문에서 where 문을 생략하면, 전체 행을 수정한다는 뜻.
-- mysql 워크벤치에서 where절을 생략하려면 옵션을 변경해야함.]
-- edit - prefrence - sql Editor 최하단의 safe save

update 테이블명
	set
		열1 = 값1,
        열2 = 값2,
        ...
        열n = 값n
        where 열명A = 값A;product_category
*/

-- 1번 카테고리인 공지를 공지사항으로 수정

update board_category
set bc_name = '공지사항'
where bc_num = 1;

-- 모든 게시글의 조회수를 1로 수정
update board
	set 
		bo_views = 1;
        
update board
	set
		bo_title = '공지사항입니다',
        bo_contents = '오늘은 12일 입니다.'
        where
        bo_num = 1;
	


