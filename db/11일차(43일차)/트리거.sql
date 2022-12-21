/*
-- 트리거 
테이블에 부착(attach)되는 프로그램코드
해당 테이블에 데이터 삽입, 수정, 삭제 작업이 발생하면 자동으로 실행
트리거는 제약조건과 더불어 데이터 무결성을 보장하는 장치의 역할을 함

-- 트리거에서 추가/수정/삭제된 데이터를 가져올 때는 NEW|OLD를 사용
-- INSERT : NEW
	-- INSERT 된 데이터는 트리거에서 가져올 수는 있으나 수정할 수 없음. 
	-- 트리거 내에서 NEW값을 변경 불가능하다는 말.
-- UPDATE : OLD(값이 변경되기 전 데이터), NEW(값이 변경된 후 데이터)
-- DELETE : OLD(삭제된 데이터)

형태
DROP TRIGGER IF EXISTS 트리거명;
DELIMITER //
CRREATE TRIGGER 트리거명
-- BEFORE : 테이블에 데이터가 삭제|추가|수정 되기 전에 트리거가 실행, new 데이터에 수정이 가능함
-- AFTER : 테이블에 데이터가 삭제|추가|수정 되기 전에 트리거가 실행, new 데이터에 수정이 불가함.
BEFORE| AFTER DELETE|INSERT|UPDATE -- 이벤트를 감지하는 것.
ON 테이블명
FOR EACH ROW
BEGIN
-- 실행코드
END //
DELIMITER ;

*/
-- 제품을 구매했을 때 수량이 바뀌게

USE SHOPPINGMALL2;
DROP TRIGGER IF EXISTS INSERT_BUY;
DELIMITER $$
CREATE TRIGGER INSERT_BUY
AFTER INSERT
ON BUY
FOR EACH ROW
BEGIN
-- 추가된 데이터는 NEW를 통해 가져옴. 
UPDATE PRODUCT 
	SET PR_AMOUNT = PR_AMOUNT - NEW.BU_AMOUNT
	WHERE PR_NUM = NEW.BU_PR_NUM ; 

END $$
DELIMITER ;

INSERT INTO BUY(BU_NUM, BU_AMOUNT, BU_ADDRESS, BU_POST_NUM, BU_ME_ID, BU_PR_NUM)
VALUE('QWE20221221', 1, '서울시 강남', '12345', 'QWE', 2);

USE SHOPPINGMALL2;
DROP TRIGGER IF EXISTS UPDATE_BUY;
DELIMITER $$
CREATE TRIGGER UPDATE_BUY
AFTER UPDATE
ON BUY
FOR EACH ROW
BEGIN
-- 추가된 데이터는 NEW를 통해 가져옴. 
IF NEW.BU_AMOUNT = OLD.BU_AMOUNT AND NEW.BU_STATE = '구매취소' THEN

UPDATE PRODUCT 
	SET PR_AMOUNT = PR_AMOUNT + OLD.BU_AMOUNT
	WHERE PR_NUM = NEW.BU_PR_NUM ; -- 이부분은 이쿼리에서 OLD든 NEW든 무관
	
    ELSE 
		IF NEW.BU_AMOUNT != OLD.BU_AMOUNT THEN
			UPDATE PRODUCT
				SET PR_AMOUNT = PR_AMOUNT + OLD.BU_AMOUNT -NEW.BU_AMOUNT
                WHERE PR_NUM = OLD.BU_PR_NUM;
			END IF;
		END IF;
END $$
DELIMITER ;

UPDATE BUY SET BU_STATE ='구매취소' WHERE BU_NUM = '001';
UPDATE BUY SET BU_AMOUNT = BU_AMOUNT +2 WHERE BU_NUM = 'QWE20221221';