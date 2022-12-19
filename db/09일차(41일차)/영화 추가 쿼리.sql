-- 올빼미 영화 등록 쿼리 작성

insert trailer(tr_title, tr_file_name) value('올빼미_박스오피스 1위 리뷰 예고편', 'http://h.vod.cgv.co.kr:80/vodCGVa/86481/86481_210223_1200_128_960_540.mp4');
insert movie(mo_title, mo_contents, mo_age, mo_run, mo_opening_date, mo_state, mo_tr_num) 
value('올빼미', '맹인이지만 뛰어난 침술 실력을 지닌 경수는 
어의 이형익에게 그 재주를 인정받아 궁으로 들어간다.
그 무렵, 청에 인질로 끌려갔던 소현세자가 8년 만에 귀국하고,
인조는 아들을 향한 반가움도 잠시 정체 모를 불안감에 휩싸인다.
그러던 어느 밤, 어둠 속에서는 희미하게 볼 수 있는 경수가
소현세자의 죽음을 목격하게 되고
진실을 알리려는 찰나 더 큰 비밀과 음모가 드러나며
목숨마저 위태로운 상황에 빠진다.
아들의 죽음 후 인조의 불안감은 광기로 변하여 폭주하기 시작하고
세자의 죽음을 목격한 경수로 인해 관련된 인물들의 민낯이 서서히 드러나게 되는데...', '15세 관람', 118, '2022.11.23', '상영중', 3);
insert movie_genre(mg_mo_num, mg_ge_name) value(2, '스릴러');
insert movie_person(mp_name, mp_birth, mp_contry) values
('안태진', null, '대한민국'), ('류준열', '1986-09-25', '대한민국'), ('유해진', '1970-1-4', '대한민국'),  ('최무성', '1968.01.12', '대한민국'), ('조성하', '1966.08.08', '대한민국'), ('박명훈', '1975.05.28', '대한민국'), ('김성철', '1991-12-31', '대한민국'), ('안은진', '1991-05-06', '대한민국'), ('조윤서', '1993-01-04', '대한민국');
select * from movie_person;
insert movie_casting(mc_role, mc_mo_num, mc_mp_num)
values('감독', 2, 25), ('배우', 2, 26),('배우', 2, 27),('배우', 2, 28),('배우', 2, 29),('배우', 2, 30),
('배우', 2, 31),('배우', 2, 32),('배우', 2, 33);
alter table trailer add column tr_mo_num int not null;
alter table trailer add constraint fk_tr_mo_num foreign key(tr_mo_num) references movie(mo_num);

insert into screen_schedule(ss_date, ss_time, ss_total_seat, ss_possible_seat, ss_mo_num, ss_ci_num)
values('2022-12-20', '13:50', 10, 10, 2, 2), ('2022-12-20', '11:00', 10, 10, 2, 6), ('2022-12-20', '17:10', 10, 10, 2, 6);