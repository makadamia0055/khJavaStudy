drop procedure if exists insert_score;
delimiter $$
create procedure insert_score(
	in _st_num varchar(10),
    in _year int,
    in _semester int,
    in _lecture_name varchar(30),
	in _mid int,
    in _final int,
    in _homework int,
    in _attendance int

)
begin
	declare _le_num int;
	declare _total int;
    declare _co_num int;
	declare _type varchar(5);
    declare _grade varchar(5);
    set _le_num = (select le_num from lecture where le_year = _year and le_term = _semester and le_name = _lecture_name);
    if _le_num is not null then
		set _co_num =(select co_num from course where co_le_num = _le_num and co_st_num = _st_num);
        if _co_num is not null then
			set _total = ((_mid * 0.4) + (_final * 0.4) + (_attendance * 0.1) + (_homework * 0.1));
			insert into score(sc_mid, sc_final, sc_homework, sc_attendance, sc_total, sc_co_num)
            value(_mid, _final, _homework, _attendance, _total, _co_num);
            
			set _type = (select co_type from course where co_num = _co_num);
            if _type = '학점' then
				if _total >= 90 and _total <= 100 then
                set _grade = 'A';
                end if;
                if _total >= 80 and _total < 90 then
                set _grade = 'B';
                end if;
                if _total >= 70 and _total < 80 then
                set _grade = 'C';
                end if;
                if _total >= 60 and _total < 70 then
                set _grade = 'D';
                end if;
                if _total >= 0 and _total < 60 then
                set _grade = 'F';
                end if;
                update course set co_grade = _grade where co_num = _co_num;
			end if;
		end if;
	end if;


end $$
delimiter ;

call insert_score(2022160001, 2022, 1, '컴퓨터 개론', 100, 80, 100, 90);