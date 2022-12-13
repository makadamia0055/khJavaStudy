-- 회원 등록
select * from small_jik.member;
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_authority`, `me_point`) VALUES ('abc', 'abc', 'ABC마트', 'MEMBER', '0');
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_birth`, `me_authority`, `me_point`) VALUES ('qwe', 'qwe', '홍길동', '2000-01-01', 'MEMBER', '0');
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_authority`, `me_point`) VALUES ('admin', 'admin', '관리자', 'ADMIN', '0');
INSERT INTO `small_jik`.`member` (`me_id`, `me_pw`, `me_name`, `me_birth`, `me_authority`, `me_point`) VALUES ('hi', 'hi', '고길동 ', '2002-1-23', 'MEMBER', '0');

/*
카테고리 등록
- 의류
	- 여성
	- 남성
    - 아동
    - 남녀공용
- 식품
	- 과일
    - 채소
    - 과자
	- 쌀
- 가전
	- TV
    - 냉장고
    - 에어컨
    
- 스포츠
	- 수영
    - 골프
    - 자전거

- 문구
	- 사무용품
    - 미술용품
*/
select * from main_category;
-- insert main_category(mc_name) values('의류'), ('식품'), ('가전'), ('스포츠'), ('문구');
select * from sub_category;
-- insert sub_category(sc_mc_num, sc_name) values(1, '여성'), (1, '남성'), (1, '아동'), (1, '남녀공용'), (2, '과일'), (2, '채소'), (2, '과자'), (2, '쌀'), (3, 'TV'), (3, '냉장고'), (3, '에어컨'), (4, '수영'), (4, '골프'), (4, '자전거'), (5, '사무용품'), (5, '미술용품');
-- 아래와 같은 코드도 된다.
-- insert into sub_category(sc_name, sc_mc_num) select '여성', mc_num from main_category where mc_name ='의류';

/*
abc : 집, 서울시 강남, 12345
		회사, 서울시 강북, 23456
hi : 집, 경기도 안산, 45678
	회사, 서울시 강북, 23456
qwe : 집, 충북 청주, 32145
	처가, 서울시 강남, 12345
*/
select * from address_book;
/* insert into address_book(ab_name, ab_address, ab_post_num, ab_me_id) 
values('집', '서울시 강남', '12345', 'abc'), ('회사', '서울시 강북', '23456', 'abc'),
	('집', '경기도 안산', '45678', 'hi'), ('회사', '서울시 강북', '23456', 'hi'),
    ('집', '충북 청주', '32145', 'qwe'), ('처가', '서울시 강남', '12345', 'qwe');
*/

/*
- 의류 - 여성, 반집업 맨투맨, 세컨그라운드 여성용 반집업 맨투맨, now(), 10, 17000
	- 빨강, 노랑, 흰색, 
- 의류 - 여성, 세미 크롭 맨투맨, 바블링브룩 여성용 세미 크롭 맨투맨, now(), 10, 19900
	- S, M, L
- 의류 - 남성, 긴팔 카라티, 빅사이즈 클럽 긴팔 카라티, now(), 20, 24900
	- 흰색 S, 흰색 M, 흰색 L, 남색 S, 남색 M, 남색 L
- 의류 - 남성, 7부 브이넥 티셔츠, 해리슨 남성용 브이넥 7부 티셔츠, now(), 20, 24900
	- XS , S, M, L, XL
- 의류 남녀공용, 기모 조거팬츠, 우드피카 기모 조거팬츠, now(), 5, 24800
	-24인치 ,  26인치, 28인치, 30인치, 32인치
- 의류 - 남녀공용, 슬롭 스키니, 블랙 기모 글림 스키니, now(), 100, 51840
	-60CM, 64CM, 68CM, 72CM
*/

select * from product;
/*
insert into product(pr_title, pr_contents,  pr_amount, pr_price, pr_sc_num) 
 values('반집업 맨투맨', '세컨그라운드 여성용 반집업 맨투맨', 10, 17000, (select sc_num from sub_category where sc_name like '여성')), 
	('세미 크롭 맨투맨', '바블링브룩 여성용 세미 크롭 맨투맨',  10, 19900, (select sc_num from sub_category where sc_name like '여성')), 
	('긴팔 카라티', '빅사이즈 클럽 긴팔 카라티',  20, 24900, (select sc_num from sub_category where sc_name like '남성')), 
	('7부 브이넥 티셔츠', '해리슨 남성용 브이넥 7부 티셔츠',  20, 24900, (select sc_num from sub_category where sc_name like '남성')), 
	('기모 조거팬츠', '우드피카 기모 조거팬츠',  5, 24800, (select sc_num from sub_category where sc_name like '남녀공용')), 
	('슬롭 스키니', '블랙 기모 글림 스키니',  100, 51840, (select sc_num from sub_category where sc_name like '남녀공용'));
*/
desc product;
select * from product_option;
insert into product_option(po_title, po_amount, po_pr_num) 
values('빨강', 5,  (select pr_num from product where pr_title like '반집업 맨투맨')), 
('노랑', 5,  (select pr_num from product where pr_title like '반집업 맨투맨')),
('흰색', 5,  (select pr_num from product where pr_title like '반집업 맨투맨')),
('S', 5,  (select pr_num from product where pr_title like '세미 크롭 맨투맨')),
('M', 5,  (select pr_num from product where pr_title like '세미 크롭 맨투맨')),
('L', 5,  (select pr_num from product where pr_title like '세미 크롭 맨투맨')),
('흰색 S', 5,  (select pr_num from product where pr_title like '긴팔 카라티')),
('흰색 M', 5,  (select pr_num from product where pr_title like '긴팔 카라티')),
('흰색 L', 5,  (select pr_num from product where pr_title like '긴팔 카라티')),
('남색 S', 5,  (select pr_num from product where pr_title like '긴팔 카라티')),
('남색 M', 5,  (select pr_num from product where pr_title like '긴팔 카라티')),
('남색 L', 5,  (select pr_num from product where pr_title like '긴팔 카라티')),
('XS', 5,  (select pr_num from product where pr_title like '7부 브이넥 티셔츠')),
('S', 5,  (select pr_num from product where pr_title like '7부 브이넥 티셔츠')),
('M', 5,  (select pr_num from product where pr_title like '7부 브이넥 티셔츠')),
('L', 5,  (select pr_num from product where pr_title like '7부 브이넥 티셔츠')),
('XL', 5,  (select pr_num from product where pr_title like '7부 브이넥 티셔츠')),
('24 인치', 5,  (select pr_num from product where pr_title like '기모 조거팬츠')),
('26 인치', 5,  (select pr_num from product where pr_title like '기모 조거팬츠')),
('28 인치', 5,  (select pr_num from product where pr_title like '기모 조거팬츠')),
('30 인치', 5,  (select pr_num from product where pr_title like '기모 조거팬츠')),
('32 인치', 5,  (select pr_num from product where pr_title like '기모 조거팬츠')),
('60CM', 5,  (select pr_num from product where pr_title like '슬롭 스키니')),
('64CM', 5,  (select pr_num from product where pr_title like '슬롭 스키니')),
('68CM', 5,  (select pr_num from product where pr_title like '슬롭 스키니')),
('72CM', 5,  (select pr_num from product where pr_title like '슬롭 스키니'));