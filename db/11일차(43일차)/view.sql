-- view 
-- 데이터 열람만 가능하고, 기입은 안됨. 
-- view는 보안에 도움이 됨. 데이터 그 자체가 아니라 데이터를 보는 selece, 즉 데이터를 보는 시점을 만드는 것에 불과.
-- 데이터는 결국 원본에 가서 조회하기 때문에 view가 유출되어도 보는 방법만 유출될 뿐이지 보는 것은 유출되지 않는다.
use cgv;
-- 예매한 영화이름, 영화관, 좌석이름, 아이디, 상영일, 상영시간.
create view ticket_detail1
as 
select * from ticketing
	join ticketing_seat on ti_num = ts_ti_num
    join seat on se_num = ts_se_num
    join screen_schedule on ss_num = ti_ss_num
    join movie on mo_num = ss_mo_num
    join cinema on ci_num = ss_ci_num;
select * from ticket_detail1;

create view ticket_detail2
as 
select * from ticketing
	join ticketing_seat on ti_num = ts_ti_num
    join seat on se_num = ts_se_num
    join screen_schedule on ss_num = ti_ss_num
    join movie on mo_num = ss_mo_num
    join cinema on ci_num = ss_ci_num;
select * from ticket_detail2;

-- abc 회원이 영화 예매를 위해 사용한 금액은?
select ti_me_id as 아이디, sum(ti_total_price) as '총 금액' from ticket_detail2
	where ti_me_id like 'abc'
    group by ti_me_id;
    