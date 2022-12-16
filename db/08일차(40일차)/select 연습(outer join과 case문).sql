-- 영화 아바타 상영시간 조회하는 쿼리
-- 정렬은 영화관 순으로
select ci_name as '상영관', ss_time as '상영 시간' from screen_schedule
	join movie on ss_mo_num = mo_num
    join cinema on ss_ci_num = ci_num
    where mo_title like '아바타-물의 길' and mo_state like '상영중'
    and ss_date >= now()
    order by ci_num;
    
-- 18일 9:50에 상영하는 아바타의 예매 가능 좌석들을 조회
select se_name as '좌석명', 
case
	when ts_num is null
	then 'O'
    else 'X'
end as '예약 가능'
 from screen_schedule
	join (select * from movie where mo_title like '아바타-물의 길' and mo_state like '상영중') as mo on ss_mo_num = mo_num
	join cinema on ss_ci_num = ci_num
    join seat on ci_num = se_ci_num
    left join ticketing_seat on ts_se_num = se_num
	where ss_date = '2022-12-18' and ss_time = '09:50:00' and se_state ='사용가능';
    
-- abc 회원이 18일 9:50에 상영하는 아바타 a1, a2 두자리를 예매했다. 이때 필요한 작업을 쿼리로 작성
-- 단, 작업의 편의를 위해 18일 9시 50분에 상영하는 아바타라는 정보 대신 상영번호가 5번으로 활용

insert into ticketing(ti_amount, ti_ss_num, ti_me_id, ti_total_price)
value(2, 5, 'abc', 20000);
select * from screen_schedule
	join cinema on ss_ci_num = ci_num
    join seat on se_ci_num = ci_num
    where ss_num= 5 and se_name = 'A2';

insert into ticketing_seat(ts_se_num, ts_ti_num) 
values( (select se_num from screen_schedule
	join cinema on ss_ci_num = ci_num
    join seat on se_ci_num = ci_num
    where ss_num= 5 and se_name = 'A1')  ,1), 
    
    ( (select se_num from screen_schedule
	join cinema on ss_ci_num = ci_num
    join seat on se_ci_num = ci_num
    where ss_num= 5 and se_name = 'A2') , 1);

update screen_schedule
	set
		ss_possible_seat= ss_possible_seat -2
        where ss_num = 5;
 
SET sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));
SELECT @@sql_mode;
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- 아바타 물의 길을 상영하는 극장 정보
select mo_state as '아바타2 상영정보', th_name as '극장' from screen_schedule
	join (select * from movie where mo_title = '아바타-물의 길' and mo_state like '상영중')as mo on ss_mo_num = mo_num
    join cinema on ss_ci_num = ci_num
    left join theater on ci_th_num = th_num
    group by th_num;

-- CGV 강남에서 상영하는 영화를 조회
select mo_title as '강남CGV에서 하는 영화' from theater
	join cinema on ci_th_num = th_num
    join screen_schedule on ss_ci_num = ci_num
    join movie on ss_mo_num = mo_num
    where th_name like 'CGV강남' and ss_date >=now()
    group by mo_title;
    