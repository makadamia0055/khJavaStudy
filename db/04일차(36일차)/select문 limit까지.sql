-- select 문

select now();
/*
SELECT 
	[distinct] -- 결과의 중복을 제거하고 종류만 출력(java의 set처럼)
	select_expr(속성|식 등등) -- 아래 명령어들 순서는 지켜야함.
	[From table_references(테이블 명)]
	[Where 조건절] -- 조건에 맞는 결과를 조회, 같은 경우 '=='이 아닌 '='을 이용하여 비교, 같지 않다는 !=
    
    -- 속성명 1로 정렬(오름차순|내림차순)한 후, 속성명 1이 같은 값들에 한해 속성명 2로 정렬(오름|내림)
    -- 정렬방법 생략시 asc
    [Order by 속성명 [asc|desc], 속성명2 [asc|desc]
    -- 검색 결과의 개수를 제한 
    -- limit 번지, 개수 : 지정 번지부터 개수까지
    -- limit 개수 : 0번지부터 개수
    [limit절]
*/
-- member 테이블의 me_id와 me_pw 조회
select me_id, me_pw
	from member;
    
-- member 테이블에 있느 모든 회원 정보를 조회

select * from member;

-- member 테이블에 아이디가 abc인 회원정보
select * from member where me_id = 'abc';

-- 관리자의 '아이디'를 조회하는 쿼리

select me_id from member where me_authority = 'ADMIN';

-- 일반 회원의 아이디를 조회하는 코드
select me_id from member where me_authority = 'Member';
select me_id from member where me_authority != 'admin';
select me_id from member where me_authority <> 'admin';
-- sql에서는 <>도 같지 않다라는 표현.

-- 회원 아이디를 오름차순으로 정렬
select * from member order by me_id;

-- 회원들을 생일순으로 내림차순으로 정렬;
select * from member order by me_birth desc;

-- 회원들을 아이디순으로 오름차순으로 정렬하여 처음 2명만 조회
select * from member order by me_id limit 2;
-- 회원들을 아이디순으로 오름차순으로 정렬하여 두번째 2명만 조회
select * from member order by me_id limit 2, 2;
-- 회원들을 아이디순으로 오름차순으로 정렬하여 세번째 2명만 조회
select * from member order by me_id limit 4, 2;

-- n번째 X명 조회 limit(n-1)*x, x

-- 게시글에서 조회수가 1이상 100 이하인 게시글들 조회
select * from board where bo_views >=1 and bo_views <= 100;
select * from board where bo_views >=1 && bo_views <= 100;
select * from board where bo_views between 1 and 100;

-- 게시글에서 카테고리 번호가 1번 또는 2번인 게시글을 전체 조회
select * from board where bo_bc_num =1 or bo_bc_num = 2;
select * from board where bo_bc_num =1 or 2;
select * from board where bo_bc_num =1 || bo_bc_num = 2;
-- 속성 in(a,b) : 속성이 a또는 b값을 가지는 경우
select * from board where bo_bc_num in(1,2);

-- 다음 쿼리문 변환이 틀린 이유? : in은 속성값이 같고, or 결합인 경우만 해당
select * from board where bo_bc_num =1 or bo_bc_num= 2 and bo_bc_num;

select * from board where bo_bc_num in(1, 2, 3);


/* 문자열 검색
-- =는 두 문자열이 완전히 동일해야 true,
-- like을 이용하면 문자열1이 문자열 2에 있는지 확인 가능
... where 속성명 like 문자열
- 와일드 카드 
	_: 한 글자  ... where bo_title like '___' => 제목이 3글자인 게시글들.
    % : 0 글자 이상 ... where bo_title like '공지%' => 제목이 공지로 시작하는 모든 게시물들
				... where bo_title like '%공지' => 제목이 공지로 끝나는 모든 게시물들
                ... where bo_title like '%공지%' => 제목에 공지가 들어가는 모든 게시글들
    
*/

-- 2022년도에 작성된 게시글들을 조회(날짜를 문자열처럼 취급)
select * from board where bo_reg_date like '2022-%';
select * from board where bo_reg_date between '2022-01-01 00:00:00' and '2022-12-31 23:59:59';

-- 서브쿼리 : 쿼리 안에 쿼리문이 또 들어가있는 쿼리문.

-- 카테고리가 공지사항인 게시글들을 조회.
select * from board 
	where bo_bc_num = (select bc_num from board_category where bc_name = '공지사항');
    
-- any : 여러 쿼리 중 하나라도 만족하는 것
-- all : 여러 쿼리 중 모든 것을 만족하는 것.

-- 가전 제품(제품카테고리 1번) 중 가장 비싼 제품보다 가격이 높은 제품들
select * from product 
	where pr_price > all(select pr_price from product where pr_pc_num = 1);
    
-- 궁금증 서브쿼리란 어느 쿼리문을 말하는건가 바깥쿼리? 안쿼리? 아니면 그 형태만?

-- 가전 제품(제품카테고리 1번) 중 가장 싼 제품보다 가격이 높은 제품들
select * from product 
	where pr_price > any(select pr_price from product where pr_pc_num = 1);
    
-- =any(서브쿼리) 는 in(서브쿼리)로 대체가능
-- 가전 제품(제품카테고리 1번)의 제품 들과 같은 가격을 가진 제품
select * from product 
	where pr_price = any(select pr_price from product where pr_pc_num = 1);
select * from product 
	where pr_price in(select pr_price from product where pr_pc_num = 1);
    
-- distict문 중복된 결과가 있을때 중복된 내용 제거하고 출력(java의 set와 비슷)
-- 모든 회원의 권한을 출력(권한만 출력하기 때문에 중복이 가능) -> distinct문을 쓰면 종류만 출력
select distinct me_authority from member;


-- A as B : A를 B로 부르겠다(일시적 수정) - select문으로 검색 결과를 출력할 때만 적용
select distinct me_authority as '권한'  from member;
