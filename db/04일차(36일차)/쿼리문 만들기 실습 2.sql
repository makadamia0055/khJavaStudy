-- 가전 제품을 조회하는 쿼리문

select * from product
	where pr_pc_num = (select pc_num from product_category where pc_name like "가전%");
    
-- 제품명으로 TV를 검색
select * from product
	where pr_title like '%tv%';
    
-- abc 회원이 구매 확정한 목록을 보여주는 쿼리문 작성
select * from buy
	where (bu_me_id like 'abc') 
    and (bu_state like '결제 완료');