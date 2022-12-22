-- 160, '컴퓨터 공학부', 'KH교육원 1관 1층', '02-123-4567'
-- 123, '기계 공학부' , 'kh 교육원 1관 2층' , '02-123-4568'
-- 135, '전자 공학부', 'kh 교육원 2관 3층', '02-123-1234'
insert into department(de_num, de_name, de_address, de_tel)
values('160', '컴퓨터 공학부', 'KH교육원 1관 1층', '02-123-4567'),
('123', '기계 공학부' , 'kh 교육원 1관 2층' , '02-123-4568'),
('135', '전자 공학부', 'kh 교육원 2관 3층', '02-123-1234');
select * from department;

-- 컴퓨터 공학부에 2022년 홍길동 교수님이 부임함. 이 때 홍길동 교수님의 정보를 추가하는 작업을 해보세용
-- 이때 교수님 교번은 2022160001이 자동 할당되어야 함. 
Drop procedure if exists professor_pr_num_maker;
delimiter $$
create procedure professor_pr_num_maker(
	in _de_name varchar(20),
    in _year int(4),
    in _pr_name varchar(20)
    )
begin
	declare _pr_num_count int(3) zerofill default((select count(*) from professor)+1);
    declare _pr_de_num char(3) default((select de_num from department where de_name = _de_name));
	insert into professor(pr_num, pr_name, pr_de_num, pr_state)
    value(concat(_year, _pr_de_num, _pr_num_count), _pr_name, _pr_de_num, '재직중');

end $$
delimiter ;


