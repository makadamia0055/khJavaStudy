-- ABC 회원이 반집업 맨투맨(1번제품) 빨강을 2개 장바구니에 담음. 이때 실행되어야 하는 쿼리는
select * from product;
select * from product_option;
select * from basket;
insert into basket(ba_amount, ba_me_id, ba_po_num) value(2, 'abc', 
(select po_num from product_option where po_title like '빨강' and po_pr_num = (select pr_num from product where pr_title like '반집업 맨투맨%')));
-- 다행이 빨강이 po_title에 중복되지 않아서 가능한 쿼리. 

-- abc 회원이 장바구니에 담긴 모든 제품을 구매함. 이때 실행되어야할 쿼리는?
-- 적립 포인트는 제품 금액의 10%, 배송지는 집, 사용포인트는 x
select * from `order`;
insert into `order`(or_total_price, or_price, or_use_point, or_add_point, or_state, or_me_id, or_ab_num)
value((select ba_amount from basket where ba_me_id like 'abc')*(select pr_price from product where pr_num = 1), (select ba_amount from basket where ba_me_id like 'abc')*(select pr_price from product where pr_num = 1), 0, (select ba_amount from basket where ba_me_id like 'abc')*(select pr_price from product where pr_num = 1)/10, '구매완료', 'abc', (select ab_num from address_book where ab_me_id like 'abc' and ab_name like '집'));
insert into order_list(ol_amount, ol_price, ol_po_num, ol_or_num) 
value((select ba_amount from basket where ba_me_id like 'abc'), (select pr_price from product where pr_num = 1), (select po_num from product_option where po_title like '빨강' and po_pr_num = (select pr_num from product where pr_title like '반집업 맨투맨%')),
 1);
 update product_option 
	set po_amount = po_amount-2
    where 
		po_num = 1;
 
 delete from basket where ba_num = 1;
 select distinct ol_po_num as '옵션번호' from order_list where ol_or_num = any(select or_num from `order` where or_me_id like 'abc');
