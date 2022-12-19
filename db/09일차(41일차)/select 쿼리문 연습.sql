-- 아바타-물의 길에 출현한 감독 및 배우들을 조회하는 쿼리
select mp_name as '이름', mc_role as '역할', mp_birth as 생년월일, mp_contry as 국적 from movie_person
	join movie_casting on mc_mp_num = mp_num
    join movie on mc_mo_num = mo_num
    where mo_title like '아바타-물의 길';
    
-- 제임스 카메론의 참여 영화 리스트를 조회하는 쿼리alter
select mo_title as '영화명', mo_opening_date as '개봉일'  from movie_person
	join movie_casting on mc_mp_num = mp_num
    join movie on mc_mo_num = mo_num
    where mp_name = '제임스 카메론';
    
-- 아바타 누적 관객 수를 조회하는 쿼리
select sum(ti_amount) as '누적 관객수' from ticketing 
	join screen_schedule on ti_ss_num = ss_num
    join movie on ss_mo_num = mo_num
    where mo_title like '아바타-물의 길' and ss_date<now();

-- 누적 관객수가 1명 이상인 영화를 조회하는 쿼리
select mo_title as 영화명, sum(ti_amount) as '누적 관객수' from ticketing 
	join screen_schedule on ti_ss_num = ss_num
    join movie on ss_mo_num = mo_num
    where ss_date<now() 
    group by mo_num
    having sum(ti_amount) >=1;