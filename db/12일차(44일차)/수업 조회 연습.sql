-- 2022년 1학기 컴퓨터 개론을 수강하는 학생들 명단을 조회
select st_num as '학번', st_name as '학생명' from course
	join lecture on co_le_num = le_num
    join student on co_st_num = st_num
    where le_year = 2022 and le_term = 1 and le_name like '컴퓨터 개론';
    
-- 2022년 1학기에 2022160001 학생이 수강한 과목명을 조회
select le_name as 강좌명  from course
	join lecture on co_le_num = le_num
    where le_year = 2022 and le_term = 1 and co_st_num = 2022160001;
    



-- 2022년 1학기 컴퓨터 개론을 수강하는 학생 이름과 학점을 조회
select st_name as '학생 이름', co_grade as '학점' from course
	join student on co_st_num = st_num
    join lecture on co_le_num = le_num
    where le_year = 2022 and le_term = 1 and le_name = '컴퓨터 개론';
    
    
-- 컴퓨터 공학부 학생 명단과 교수 명단을 함께 조회

select pr_name as 이름 , '교수' as '직위' from professor
	where substring(pr_num, 5, 3) = (select de_num from department where de_name like '컴퓨터 공학부')
    union
select st_name as 이름, '학생' as '직위' from student join major on ma_st_num = st_num
	where ma_de_num = 160; -- 복수 전공생 때문에 학번에서 추출하는거 포기

-- 2022160001 학생의 성적을 조회하는 쿼리를 작성
select le_name as 강의명, co_grade as 성적 from course
	join lecture on co_le_num = le_num
    where co_st_num = 2022160001;
    
-- 2022160001 학생의 2022년 1학기 평균 학점을 조회
-- A : 4.5 B : 3.5 C: 2.5 D: 1.5 f:0

select sum(
case
	when co_grade = 'A'
    then 4.5
    when co_grade = 'B'
    then 3.5
    when co_grade = 'C'
    then 2.5
    when co_grade = 'D'
    then 1.5
    when co_grade = 'F'
    then 0
end * le_point
) / sum(le_point) as 평점 from course
    join lecture on co_le_num = le_num
    	where co_st_num = 2022160001 and le_year = 2022 and le_term = 1;
    