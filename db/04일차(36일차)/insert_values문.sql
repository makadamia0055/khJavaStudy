use shoppingmall2;

/*
insert into member(me_id, me_pw, me_name, me_birth, me_authority)
	values('abc', '123', '홍길동', '2000-01-01', 'MEMBER');
  */
  
  -- 전체 열(속성) 명을 나열하지 않아도 가능, 단 생략한 열이 null허용이나 기본값이 존재하는 열이어야 한다.
  -- me_authority를 생략해도 default값이 MEMBER로 설정되어 있어서 default값이 자동으로 들어감.
  insert into member(me_id, me_pw, me_name, me_birth) 
  values('qwe', '123', '고길동', '2001-01-01');
	
    -- 열 순서를 바꿔도 가능
   -- 속성 값을 명시하는 경우 그 순서에만 값을 맞춰주면 제대로 입력됨.
  insert into member(me_id, me_name, me_birth, me_pw)
  values('asd', '이순신', '2001-01-01', '123'); 
  
  -- 열 명을 전체 생략해도 가능. 단, 테이블 생성 시 추가했던 열 순으로 값들을 입력해야 함.
  insert into member values('qwe123', 'qwe123', '홍씨', '1990-06-13', 'MEMBER')
  , ('zxc123', 'zxc123', '박씨', '1991-08-11', 'MEMBER');
    
   insert into board_category(bc_name) values('공지'), ('자유'), ('문의');
   
   insert into board(bo_title, bo_contents, bo_me_id, bo_bc_num) 
   values('제목1', '내용1', 'qwe', 1);
   
    select * from member;
    
    
    
    