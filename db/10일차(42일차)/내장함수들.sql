use shoppingmall2;
set @a = 'tv';

select * from product where pr_title like '%@a%';
select * from product -- 나중에 자바에서 넘겨준 변수로 검색할 때 이렇게 concat와 사용.
	where pr_title like concat('%', @a, '%');

-- format(숫자, 소숫점 자리수)
select format(100000, 0); -- (숫자, 표시할 소숫점 자리수) 천단위마다 쉼표 삽입

-- left, right(문자열, 숫자값) 문자열에서 특정 숫자값만큼 방향에 따라 문자열 추출)
select right('test.txt', 3);

-- lower(문자열), upper(문자열) 소문자, 대문자 변환
-- Lpad(문자열, 길이, 채울 문자열) RPAD(문자열, 길이, 채울문자열) 문자열을 길이만큼 늘리고, 빈 곳을 채울 문자열로 채움.
-- RTrim(문자열) 좌 우 공백 제거
-- Trim(문자열) 앞뒤 공백제거
-- replace(문자열, 원래문자열, 바꿀문자열) 문자열에서 원래문자열을 찾아 바꿀문자열로 바꿈
-- substring(문자열, 시작위치, 길이); 시작위치부터 길이만큼 반환.


-- 날짜
-- addDate(날짜, 차이) subDate(날짜, 차이) 날짜에서 차이만큼 더하거나 뺀다. 
-- addtime(시간, 차이) subTime(시간, 차이) 시간에서 차이만큼 더하거나 뺀다.
select adddate(now(), interval 1 day);
select adddate(now(), interval 1 week);
select adddate(now(), interval 1 month);
select adddate(now(), interval 1 year);
select subdate(now(), interval 1 day);

use shoppingmall2;

-- 가격이 20000원 이상이만 비쌈, 가격이 5000이하이면 쌈, 아니면 적당이라고 분류.
select pr_title, pr_price,
	case
		when pr_price >= 20000
        then '바쌈'
        when pr_price <= 5000
        then '쌈'
        else '적당'
	end as '가격 판별'
from product;


select pr_title as 품목명, if(pr_price>=20000, '비쌈', if(pr_price<=5000, '쌈', '적당')) as '가격판별' from product;
