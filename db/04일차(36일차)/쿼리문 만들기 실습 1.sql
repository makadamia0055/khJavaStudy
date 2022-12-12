-- 가전, 의류, 식품, 취미용품, 애견용품을 제품카테고리에 추가하는 쿼리를 작성하세요

insert into product_category(pc_name) values('가전'), ('의류'), ('식품'), ('취미용품'), ('애견용품');

update product_category
	set pc_num = pc_num-6;
    
select * from product_category;

-- 가전(50인치 tv, 50인치 tv팜, 10대, 10000원)
-- 가전(100인치 tv, 100인치 tv팜, 20대, 23000원)
-- 가전(무풍에어컨, 무풍에어컨 팜, 30대, 320000원)
-- 의류(셔츠, 겨울용 셔츠 팜, 15개, 1000원)
-- 식품(스테이크, 부드러운 스테이크 팜, 40, 2000
-- 취미용품(등산화, 안전한 등산화, 5개, 5000
-- 애견용품, 개껌, 오래가는 개껌, 3개, 10000원

insert into product(pr_title, pr_contents, pr_amount, pr_price, pr_pc_num) 
	values('50인치 tv', '50인치 tv팜', 10, 10000, 1), 
		('100인치 tv', '100인치 tv팜', 20, 23000, 1), 
		('무풍에어컨', '무풍에어컨 팜', 30, 320000, 1),
		('셔츠', '겨울용 셔츠 팜', 15, 1000, 2), 
		('스테이크', '부드러운 스테이크 팜', 40, 2000, 3), 
		('등산화', '안전한 등산화', 5, 5000, 4), 
		('개껌', '오래가는 개껌', 3, 10000, (select pc_num from product_category where pc_name like '애견용품'));

select * from product;
-- abc 회원이 50인치 tv 한대를 구매함. 주소는 서울시 강남, 우편번호는 12345
select * from member;

insert into buy(bu_num, bu_state, bu_amount, bu_address, bu_post_num, bu_me_id, bu_pr_num)
	values('001', '결제 완료', 1, '서울시 강남구', '12345', 'abc', 1);
    
update product
	set
		pr_amount = pr_amount -1
        
     where pr_num = 1;
     -- where (select pr_num from product where pr_title like "50 인치 %") ;
     -- 변경하는 문에서 변경대상을 서브쿼리문으로 검색할 수 없는듯?
     
/*
- insert values문 : 추가하는 값들을 모두 알고 있는 경우
	insert into 테이블명 values();
- insert select문 : 일부 값들을 검색을 통해 가져와야 하는 경우
	insert into 테이블명 select ....
*/
-- 식품, 음료수, 콜라, 100개, 1000
insert into product(pr_title, pr_contents, pr_amount, pr_price, pr_pc_num)
	select '음료수', '콜라', 100, 1000, pc_num from product_category where pc_name = '식품';
select * from product;
