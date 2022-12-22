-- '컴퓨터 개론', '월 1, 2' 3(학점), 1분반, 2022, 1, '2022160001'
-- '자바', '화 1, 2, 3, 4', 3, 1, 2022, 1, '2022160001'
insert into lecture(le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num)
values('컴퓨터 개론', '월 1, 2', 3, 1, 2022, 1, '2022160001');
insert into lecture(le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num)
values('자바', '화 1, 2, 3, 4', 3, 1, 2022, 1, '2022160002');

-- 고길동 학생이 컴퓨터 개론과 자바를 수강
-- 나길동 학생이 자바를 수강

insert into course(co_le_num, co_st_num)
values((select le_num from lecture where le_year = 2022 and le_term = 1 and le_name like '컴퓨터 개론'), '2022160001'),
((select le_num from lecture where le_year = 2022 and le_term = 1 and le_name like '자바'), 2022160001);

insert into course(co_le_num, co_st_num)
value((select le_num from lecture where le_year = 2022 and le_term = 1 and le_name like '자바'), 2022160002);

-- 2022년 1학기 컴퓨터 개론을 수강하는 고길동 학생의 성적을 등록하려고 한다.
-- 중간은 100, 기말은 80, 출석 100, 과제 100점이고, 비율은 4, 기말 4, 출석 1, 과제 1로 
-- 성적이 계산되어 총점에 저장.
-- 학점은  100~ 90 이상 A, 89~80이상 B 80미만 70 이상 C, 70미만, 60이상 D, 나머지 F

