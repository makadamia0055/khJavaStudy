-- 유니온 : 두 쿼리의 결과를 행으로 합치는 연산자

use shoppingmall2;
/*
- union, union all : 합집합( join과 다르게 속성이 늘어나지는 않음)
	- 속성 이름들이 같아야 함.
- union : 중복을 제거
- union all : 중복을 제거하지 않음, union보다 빠름(중복을 제거하는 작업이 없어서)
*/
select * from product where pr_amount > 10
	union -- 중복된 제이터 제거
select * from product where pr_price > 10000;

select * from product where pr_amount > 10
	union all -- 중복된 데이터도 포함
select * from product where pr_price > 10000;

select pr_num as 번호, pr_title as 내용 from product
	union -- 서로 다른 값들로 유니온을 실행시 합쳐지긴 하나 개판남.
select pc_num as 번호, pc_name as 내용 from product_category;


-- in, not in
-- 해당조건을 만족하는 것으로 조건을 검.
-- select userName from usertable where userName not in (select ....)

-- with rollup 삽입시되는 부분까지 합계 group by 를 기준으로 
use shoppingmall2;

select pr_pc_num, sum(pr_amount) from product group by pr_pc_num with rollup;

use cgv;
select ss_mo_num, ss_ci_num, sum(ss_possible_seat) as '예매 가능 총 좌석' from screen_schedule
group by ss_mo_num, ss_ci_num
with rollup;
