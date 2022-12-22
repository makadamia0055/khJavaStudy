-- 트리거를 이용하여 성적을 추가하는 작업을 해보세요.
-- 수강 번호는 2번, 중간 100, 기말은 80, 출석 100, 과제 90

drop trigger if exists insert_score;

delimiter $$
create trigger insert_score
before insert
on score
for each row
begin
declare _grade varchar(5);

if new.sc_mid is not null and new.sc_final is not null and new.sc_homework is not null and new.sc_total is not null
	then

	set new.sc_total =
		(new.sc_mid * 0.4) + (new.sc_final * 0.4) + (new.sc_attendance * 0.1) + (new.sc_homework * 0.1);
        
        
	if (select co_type from course where co_num = new.sc_co_num) like '학점'
		then 
		if new.sc_total >= 90 and new.sc_total <= 100 then
                set _grade = 'A';
                end if;
                if new.sc_total >= 80 and new.sc_total < 90 then
                set _grade = 'B';
                end if;
                if new.sc_total >= 70 and new.sc_total < 80 then
                set _grade = 'C';
                end if;
                if new.sc_total >= 60 and new.sc_total < 70 then
                set _grade = 'D';
                end if;
                if new.sc_total >= 0 and new.sc_total < 60 then
                set _grade = 'F';
                end if;
                update course set co_grade = _grade where co_num = new.sc_co_num;
		end if;

end if;


end $$
delimiter ;

insert into score(sc_mid, sc_final, sc_homework, sc_attendance, sc_co_num)
value(100, 80, 90, 100, 2);