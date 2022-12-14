/*
join 두 테이블을 연관된 키를 중심으로 묶는 것.
외래키로 지정된 속성이 있거나, 그에 준하는 역할을 수행할 수 있는 키를 중심으로 수행
알고 있는 데이터와 조회하는 데이터가 서로 다른 테이블에 있고, 테이블들을 속성으로 연결할 수 있는 경우에 사용.

join의 종류
내부(inner) 조인 : 공통된 데이터를 통해서 교집합을 구하는 것.
				두 테이블을 연결할 때 연결의 중점이 되는 속성이 존재하는 값들만 연결. 교집합만 출력.
외부(outer) 조인 : 공통된 데이터를 통해서 합집합을 구하는 것.
				두 테이블을 연결할 때 연결되는 속성이 없는 값들도 연결. 합집합을 출력

select 속성명들 from 테이블1
	join 테이블2
    on 테이블1.속성명1 = 테이블2.속성명2
    [where 절]
    [group by절]
    [having 절]
    [order by절]
    [limit 절]
    -속성명 1과 속성명 2가 이름이 같으면 반드시 테이블명을 써줘야함.
    - 속성명 1과 속성명 2가 다르면 테이블 명을 생략할 수 있음.

*/
-- 제품명과 옵션명을 함께 조회하려고 한다. 
select * from product;
select * from product_option;

select product.*, po_title from product
	join product_option
    on pr_num = po_pr_num;
    
SELECT 
    pr_title, po_title, po_amount
FROM
    product
        JOIN
    product_option ON pr_num = po_pr_num;
    
/*
join할 테이블이 여러개일때

select 속성명들 from 테이블1
	join 테이블2
		on 테이블1.속성명1 = 테이블2.속성명2
	join 테이블3
		on 테이블2.속성명3 = 테이블3.속성명4

*/

-- abc 회원이 구매한 제품 이름
 
 select distinct or_me_id as '아이디', pr_title as '구매 제품 이름' from order_list
	join `order`
    on `order`.or_num = order_list.ol_or_num
    
    join product_option
    on ol_po_num = po_num
    
    join product
    on po_pr_num = pr_num
    
    where or_me_id like 'abc';
    
-- abc 회원이 구매한 제품들이 배송된 주소지를 조회.

select or_me_id as 아이디, ab_name as '배송지명', ab_address as '배송주소' from `order`
	join address_book
    on or_ab_num = ab_num
    where or_me_id like 'abc';

-- 의류로 등록된 모든 제품과 옵션 조회
select mc_name as 분류, pr_title as 제품명, po_title as 옵션명 from product
	join product_option
	on pr_num = po_pr_num
	join sub_category
	on pr_sc_num = sc_num
	join main_category
	on sc_mc_num = mc_num
	where mc_name like '의류';
    
/*
outer join

select 
left|right (어느 대상을 중점으로 조인할 것인가
도메인 기준으로 교점집합이 기본키인 경우가 더 범위가 넓다. 
왜냐하면 기본키로 등록되어있기 때문에 다 등록되어 있음. -> 값의 범위가 최대임. 
그래서 결국 더 집합 범위상 더 넓음.


*/

-- 분류별 등록된 제품명을 조회
select mc_name as 분류, sc_name as 소분류, ifnull(pr_title, '등록된 제품 없음') as 제품명 from product
	right join sub_category
	on pr_sc_num = sc_num
	right join main_category
	on sc_mc_num = mc_num
	