/*
dcl 

*/

create user test; -- user라는 사용자 계정 추가 비번 설정 없이

-- test1 계정 추가 비번이 1234
create user test1 identified by '1234'; 

-- grant 특정 사용자에게 권한을 주는 것. 
-- grant 권한 on 데이터베이스명.테이블명 to 계정명
-- '%' : 외부에서 접근 허옹, 'localhost' : 내부에서 접근 허용
-- all privileges : 모든 권한(grant 제외)
grant all privileges on diablo3.* to test1@'%';

-- revoke : 권한 회수
revoke all on *.* from test1;

-- 계정 삭제
drop user test1;