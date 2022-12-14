use small_jik;
-- null 체크는 is null 또는 is not null로 체크
select * from member where me_name is not null;

-- 문자열에서 특수문자표현=> 앞에 \역슬래쉬 넣어줌.
-- _ 와일드카드로 한글자라는 뜻.
select * from member where me_id like '%\_%';

/*
DML : 데이터 조작어
insert : 디비 사용자가 컴퓨터 DB에 데이터를 추가(등록)하기 위해 사용하는 언어
select : 디비 사용자가 컴퓨터 DB에 등록된 데이터를 조회하기 위해 사용하는 언어
update : 디비 사용자가 컴퓨터 DB에 등록된 데이터를 수정하기 위해 사용하는 언어
delete : 디비 사용자가 컴퓨터 DB에 등록된 데이터를 삭제하기 위해 사용하는 언어
DDL : 데이터 정의어
create : DB 객체를 생성(DB, 테이블, 사용자 등) 할 때 사용하는 언어
drop : DB 객체를 삭제할 때 사용하는 언어
alert : DB 객체를 수정할 때 사용하는 언어

DCL : 데이터 제어어 
사용자 추가, 권한 부여, 트랜잭션 제어 등을 하는 언어
	- tcl : 트랜잭션 제어어 커밋, 롤백 등

grant:
revoke : 


MySql 데이터 타입
문자형
숫자형
날짜형 뒤에 (n)을 못넣음.
이진형 Binary & byte

char와 varchar의 차이
char(10) -> 고정 문자열 10자를 저장, 10자 중 빈곳은 빈 문자열로 저장.
varchar(10) -> 가변 문자열로 최대 문자열 10자 저장 가능.
int(4) -> zf옵션을 선택하면 0001로 저장.

슈퍼키 : 행을 유일하게 식별하게 하는 속성들의 '집합'
후보키 : 슈퍼키에서 불필요한 속성들을 제거한 키 => 최소한의 속성으로 유일하게 식별하게 하는 최소집합.
기본키 : 후보키에서 선정된 키 => 의미상 적절해야 함. 
대리키 : 테이블의 기본키가 복합속성으로 되어 있는 경우 일련번호로 대체하는 속성을 기본키로 선정.
대체키 : 후보키 중 기본키로 선정되지 못한 키.
외래키 : 다른 테이블과 연결하기 위한 키. 다른 테이블을 참조하는 키.

개체 무결성 : 기본키는 중복될 수 없고, null일 수 없다.
참조 무결성 : 외래키는 null이거나, 존재한다면 참조하는 테이블에 있는 값만 사용할 수 있다.

not null : 속성 값에 null을 허용하지 않음.

- 현재시간 
현재시간을 알려주는 select now()
오라클에서는 :  sysdate
-- 속성값이 null인 경우 처리
nvl : 오라클에서 null인 경우 값 처리
ifnull(속성명, 값)

-- 정수를 날짜로 변환
to_date : 오라클
date_format(정수, 형식) : mysql
%Y 4자리 년도, %y : 2자리 년도
%M 영문으로 긴 월, %b 짧은 월(영문)
%m 숫자월(두자리 고정), %c 숫자월
%d 일(두자리 고정), %e 일
%I 시간(12시간 기준), %H 시간(24 시간)
%W 긴 요일(영문), %a 짧은 요일(영문)


*/
select now();
use small_jik;
select ifnull(me_birth, '입력 없음') as 생일 from member;
select date_format(20221214, '%Y년 %m월 %d일');
select date_format(now(), '%Y-%m-%d');

/*
- 조건문
decode(속성, 값, 같으면, 다르면) : 오라클
if(조건식, 참, 거짓) : mysql

case
	when 조건식
	then 값
    when 조건식
    then 값
    else 값
end

*/
select pr_title, if(pr_price < 20000, '가격 쌈', '비쌈') as '가격' from product;
select pr_title, if(pr_price <20000, '가격 쌈', if(pr_price < 30000 , '적당', '비쌈')) as 가격 from product;
select pr_title,
	case
		when pr_price < 20000
        then '가격 쌈'
        when pr_price < 30000
        then '가격 적당'
        else '비쌈'
	end as 가격
    from product;