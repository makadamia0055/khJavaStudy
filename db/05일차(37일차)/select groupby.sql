/*
SELECT select_expr
	[FROM table_references]
    [WHERE where_condition]
    [GROUP BY {col_name | expr | position}]
    [HAVING where_condition]
    [ORDER BY {col_name | expr | position}]
    
group by
- 같은 속성을 가지는 값으로 묶을 때 사용.
- 여러 속성을 같이 사용하여, 여러 속성이 같은 행들을 묶어서 사용.
- 집계함수와 같이 사용됨.
*/
SET sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));

-- 카테고리별 등록된 제품 수 
select pr_pc_num as '카테고리 번호', count(pr_num) as '카테고리별 등록된 제품 수' from product group by pr_pc_num;
-- 5 점대 버전에서는 

/*
집계함수
AVG() 평균
SUM() 합
max() min()
count() 행의 개수
count(distinct) 중복 제거하고 행의 개수
*/

-- 카테고리별 등록된 제품 수가 최소 2개 이상인 카테고리 번호들
select pr_pc_num as '카테고리 번호', count(pr_num) as '카테고리별 등록된 제품 수' 
	from product 
    where count(pr_num) >=2 -- 집계함수의 조건 절은 where이 아니라 having절에 걸어야 한다.
    group by pr_pc_num;

select pr_pc_num as '카테고리 번호', count(pr_num) as '카테고리별 등록된 제품 수' 
	from product 
    group by pr_pc_num
    having count(pr_num)  >=2; 
    
select pr_pc_num as '카테고리 번호', count(pr_num) as '카테고리별 등록된 제품 수' 
	from product 
    group by pr_pc_num
    having `카테고리별 등록된 제품 수`  >=2; -- 위에서 설정된 닉네임을 역따옴표를 쓰면 밑에서도 사용가능

-- 카테고리별 가장 비싼 제품 가격을 조회하는 쿼리문
select pr_pc_num as 카테고리번호, max(pr_price) as '가장 비싼 제품 가격'
	from product
    group by pr_pc_num;
    
-- max 가 작용하는 위치를 잘 확인할 것. 아래의 예시는 틀린 예시.
   
select pr_pc_num as 카테고리번호, pr_price as '가장 비싼 제품 가격'
	from product
    group by pr_pc_num
    having max(pr_price);
-- group by 되고 나서 그 값으로 max()가 걸린다.

-- cf) as는 별칭 지을 때는 생략가능하나 다른 용법일 때는 생략 불가한 경우가 있다.

create view product_view as select * from product;


-- 사용자별 총 구매 금액을 조회
select bu_me_id as '사용자 ID', 
bu_amount*(select pr_price from product where pr_num = bu_pr_num) as '총액'
	from buy
    group by bu_me_id;

-- 사용자별 총 구매 개수를 조회
select bu_me_id as '사용자 ID', 
	sum(bu_amount) as '총 구매 개수'
    from buy
    group by bu_me_id;
