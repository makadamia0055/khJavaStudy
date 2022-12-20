/* 영화를 예매하면, 예매 내역을 추가하는 프로시져를 작성하세요.
*/
-- 예매 좌석

Drop procedure if exists movie_ticketing;
delimiter $$
create procedure movie_ticketing
	(in id varchar(20),
    in _ss_NUM int,
    in _seat1 varchar(10),
    in _seat2 varchar(10),
    in _seat3 varchar(10))
begin
	Declare _count int default 0;
    declare _total_price int default 0;
    declare _se_num int default 0;
    declare _ti_num int default 0;
    if _seat1 is not null then
		set _count = _count +1;
        set _total_price = _total_price + (select se_price from seat where se_num = _seat1);
	end if;
    if _seat2 is not null then
		set _count = _count +1;
        set _total_price = _total_price + (select se_price from seat where se_num = _seat2);
	end if;
    if _seat3 is not null then 
		set _count = _count +1;
        set _total_price = _total_price + (select se_price from seat where se_num = _seat3);
	end if;
    
	insert ticketing(ti_amount, ti_ss_num, ti_me_id, ti_total_price) 
	value(_count, _ss_num, _me_id, _total_price);
 if _seat1 is not null then
		set _se_num
        = (select se_num from screen_schedule
        join cinema on ss_ci_num = ci_num
        join seat on se_ci_num = ci_num where ss_num = _ss_num and se_name = _seat1);
        insert into ticketing_seat(ts_se_num, ts_ti_num) value();
	end if;

	
	update screen_schedule
		set ss_possible_seat = ss_possible_seat - @_amount
		where ss_num = @_ss_num;
end $$
delimiter ;