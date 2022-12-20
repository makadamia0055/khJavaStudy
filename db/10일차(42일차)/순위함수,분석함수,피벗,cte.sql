-- 
/* 순위함수 Over(
[partition by <partition_by_list>]
ORDER by<order_by_list>)
*/

--  Row_number 1부터 차례대로 증가 같은 값 있어도 차등으로
-- dense_rank 값이 같을 때 같은 등수로 처리, 차순위 그냥 +1
-- Rank 값이 같을 때 같은 등수로, 차순위 +전 순위 같은 값의 수+1
-- ntile(n) 등수를 총 n개까지 분할
	
use shoppingmall2;
select 
	row_number() over(order by pr_amount desc) as 보유량순위,
	pr_title as 제품명,
    pr_amount as 보유량
    from product;
    
select 
	row_number() over(order by pr_price desc) as 가격순위,
	pr_title as 제품명,
    pr_price as 제품가격
    from product;
    
select 
	dense_rank() over(order by pr_price desc) as 가격순위,
	pr_title as 제품명,
    pr_price as 제품가격
    from product;
    
select 
	rank() over(order by pr_price desc) as 가격순위,
	pr_title as 제품명,
    pr_price as 제품가격
    from product;
select 
	ntile(3) over(order by pr_price desc) as 가격순위,
	pr_title as 제품명,
    pr_price as 제품가격
    from product;

-- 분석함수 lead(속성) 현재 ()안의 값을 기준으로 다음 튜플의 ()컬럼 값을 가져옴.
-- lead(속성, n, x) : 속성의 다음 n개 값을 가져오고 없으면 x로 대체
-- lag(속성) : lead 의 반대
-- lag(속성, n, x) : lead(속성, n, x)의 반대
-- first_value(속성) : 첫번째 값을 가져옴.\
select *, lead(pr_title) over (order by pr_num asc) as '다음행 값' from product;

select 
	row_number() over(order by pr_price desc)
	pr_title, pr_price,
	pr_price - lead(pr_price, 1, pr_price) over (order by pr_price desc) as '가격 차이' from product;
    
select 
	row_number() over(order by pr_price desc)
	pr_title, pr_price,
	pr_price - lag(pr_price, 1, pr_price) over (order by pr_price desc) as '가격 차이' from product;
select 
	row_number() over(order by pr_price desc)
	pr_title, pr_price,
	pr_price - first_value(pr_price) over (order by pr_price desc) as '가격 차이' from product;
    

-- cume_dist() : 누적백분율
select 
	row_number() over(order by pr_price desc)
	pr_title, pr_price,
	cume_dist() over (order by pr_price desc)*100 as '누적백분율' from product;
    
-- 피벗
/*
한 열에 포함된 여러값들을 토대로 그냥 내가 잘 뽑아서 하나의 테이블을 만드는 거
*/

-- with와 cte
/* 비재귀적 cte(common table Expression)
with cte_테이블명(열이름)
as
{

<쿼리문>
}
select 열이름 from CTE_테이블이름;

*/

select pr_pc_num as 분류번호, avg(pr_price) as 평균가격 from product
	group by(pr_pc_num);
    
with cte_product_avg(분류번호, 평균가격)
	as 
    (select pr_pc_num , avg(pr_price) from product group by(pr_pc_num))
    select * from cte_product_avg order by 분류번호 asc;