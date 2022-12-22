-- 학생 정보 추가를 위한 프로시저
Drop procedure if exists insert_student;
delimiter $$
create procedure insert_student(
	in _major_dep varchar(20),
    in _year char(4),
    in _st_name varchar(20),
    in _state varchar(10),
    in _semester int,
    in _pr_name varchar(20)
    )
begin	
		declare _major_num char(3) ;
        declare _st_num char(10) default 0;
        declare _st_count int(3) default 0;
        declare _pr_num char(10) ;
        set _major_num = (select de_num from department where de_name like _major_dep);
        if _major_num is not null 
			then 
            set _st_count = (select count(*)+1 from student where st_num like concat(_year, _major_num, '%'));
            set _st_num = concat(_year, _major_num, lpad(_st_count, 3, 0));
			set _pr_num = (select pr_num from professor where substring(pr_num, 5, 3) like _major_num and pr_name like _pr_name);
			if _pr_num is not null
				then 
				insert into student(st_num, st_name, st_pr_num, st_state, st_semester)
				value( _st_num, _st_name, _pr_num, _state, _semester);
				insert into major(ma_de_num, ma_st_num) value(_major_num, _st_num);
			end if;
        end if;
end $$
delimiter ;

call insert_student('컴퓨터 공학부', '2022', '고길동', '재학중', 1, '홍길동');
