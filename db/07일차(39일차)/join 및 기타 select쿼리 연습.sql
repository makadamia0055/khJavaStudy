-- 의류 제품들을 높은 가격 순으로 조회
use small_jik;
select pr_num as '제품번호', pr_title as '제품명', pr_price as '제품가격' 
	from product
	join sub_category on sc_num = pr_sc_num
    join main_category on sc_mc_num = mc_num
    where mc_name = '의류'
 order by pr_price desc;

-- 의류 제품들을 낮은 가격 순으로 조회
use small_jik;
select pr_num as '제품번호', pr_title as '제품명', pr_price as '제품가격' 
	from product
	join sub_category on sc_num = pr_sc_num
    join (select * from main_category where mc_name = '의류') as mc on sc_mc_num = mc_num
    order by pr_price asc;
    
    -- join문에서 서브쿼리를 쓸때 as로 네이밍을 꼭 해줘야함.
    
-- 제품별 판매량을 조회 
select pr_title as 제품명, ifnull(sum(ol_amount), 0) as 판매량 from product
join product_option on po_pr_num = pr_num  
left join order_list on ol_po_num = po_num
group by po_pr_num
order by 판매량 desc;

-- 의류 제품 중 제품별 판매량을 조회, 제품명, 판매량을 조회

select pr_title as 제품명, ifnull(pr_amount, 0) as 판매량 from product
left join (sub_category join (select * from main_category where mc_name like '의류') as mc on sc_mc_num =mc_num) on pr_sc_num = sc_num

order by 판매량 desc;


-- 제품별 최신순으로 조회 60개씩 보기, 120개씩 보기
select pr_title as 제품명, pr_reg_date as 등록일 from product
order by pr_reg_date desc
limit 60; -- limit 0, 60;