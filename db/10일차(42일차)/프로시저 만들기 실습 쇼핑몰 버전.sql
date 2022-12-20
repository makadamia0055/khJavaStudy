use shoppingmall2;

-- 제품번호, 수량, 배송지, 우편주소, 아이디가 주어지면 제품을 구매하는 프로시져를 작성하세요.

drop procedure if exists product_buy;
delimiter $$
create procedure product_buy(
	in _pr_num int,
    in _amount int,
    in _address varchar(50),
    in _id varchar(13),
    in _post_num varchar(10))
begin
	declare _pr_amount int default 0;
    set _pr_amount = (select pr_amount from product where pr_num = _pr_num);
    
	if _pr_amount >= _amount then
    
	insert into buy(bu_num, bu_state, bu_amount, bu_address, bu_post_num, bu_me_id, bu_pr_num)
	value(concat(_id, right(now(),10)),'구매완료', _amount, _address, _post_num, _id, _pr_num);

	update product
		set pr_amount = pr_amount - _amount
		where pr_num = _pr_num;
	end if;
end $$
delimiter ;

call product_buy(2, 4, '서울시 왕십리', 'asd', '12345');
