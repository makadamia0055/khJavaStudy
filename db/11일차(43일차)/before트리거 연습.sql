-- 예매를 취소했을 때 예매 가능 좌석을 수정하는 트리거를 추가하고, 확인
USE CGV;

DROP TRIGGER IF EXISTS CANCEL_TICKETING;
DELIMITER $$
CREATE TRIGGER CANCEL_TICKETING
before DELETE
ON TICKETING
FOR EACH ROW
BEGIN 
	-- before로 해도 old가 작동하더라(선생님 코드 보니까)
    delete from ticketing_seat where ts_ti_num = old.ti_num;
	UPDATE SCREEN_SCHEDULE
		SET SS_POSSIBLE_SEAT = SS_POSSIBLE_SEAT + OLD.TI_AMOUNT
		WHERE SS_NUM = OLD.TI_SS_NUM;
    

END $$
DELIMITER ;

DELETE FROM TICKETING
	WHERE TI_NUM = 3;
SELECT * FROM  SCREEN_SCHEDULE;

