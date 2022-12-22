
-- 컴퓨터 공학부에 2022년 홍길동 교수님이 부임함. 이 때 홍길동 교수님의 정보를 추가하는 작업을 해보세용
-- 이때 교수님 교번은 2022160001이 자동 할당되어야 함. 
Drop procedure if exists insert_professor;
delimiter $$
create procedure insert_professor(
	in _dep varchar(20),
    in _year char(4),
    in _pr_name varchar(20),
    in _state varchar(10),
    in _tel varchar(14)
    )
begin
    declare _pr_de_num char(3) default 0;
    declare _pr_num_count int(3) default 0;
	declare _pr_num char(10) default 0;
	set _pr_de_num = (select de_num from department where de_name like _dep);
    if _pr_de_num is not null then
		set _pr_num_count =
        (select count(*)+1 from professor where pr_num like concat(_year, _pr_de_num, '%'));
        set _pr_num = concat(_year, _pr_de_num, lpad(_pr_num_count, 3, '0'));
		insert into professor(pr_num, pr_name, pr_de_num, pr_state, pr_tel)
            value(_pr_num, _pr_name, _pr_de_num, _state, _tel);
		end if;
    
end $$
delimiter ;

call insert_professor('컴퓨터 공학부', 2022, '홍길동', '재직중', '010-2511-9226');

