package day10;

import java.util.Scanner;

public class PlayerRecorder {

	private Player[] playerRecord = new Player[5];

	
	public PlayerRecorder() {
		// 테스트용 디폴트 코드
		
		setRecord("강호동", 3, 0);
		setRecord("유재석", 4, 1);
		setRecord("신동엽", 5, 2);
		setRecord("기안84", 6, 3);
		setRecord("이말년", 7, 4);
		
		
	}
	public void setNewRecord(int record) {
		if(isNewRecord(record)) {
		
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		Player tmp = new Player(name, record);
		int index = findindex(record);
		int i;
		for(i = 0; i <=3-index ; i--) {
			playerRecord[i++] = playerRecord[i];
			
		}
		setRecord(tmp, i);
		
		// 뒤에서부터 밀고 마지막값 삭제하여 자리 냄.
		
		// index 값으로 다시 정리 필요
		
		
		
		} else {
			// 기록달성 실패
		}
		
	}
	
	
	
	public void setRecord(String name, int record, int i) {
		this.playerRecord[i].setRcdName(name);
		this.playerRecord[i].setRcdScore(record);
	}
	
	public void setRecord(Player player, int i) {
		this.playerRecord[i].setRcdByUser(player);
	}
	
	
	// 레코드가 가득 차있지 않을 상태까지 생각해야함.
	public boolean isNewRecord(int record) {
		boolean rst = false;
		for(int i =0 ; i<5; i++) {
			if(playerRecord[i].getRcdScore()>record) {
				rst = true;
			} else {
				rst = false;
			}
		}
		return rst;
	}
	public int findindex(int record) {
		int i;
		for(i =0 ; i<5; i++) {
			if(playerRecord[i].getRcdScore()>record) {
				return i;
			} else {
				return 0;
			}
		}
		return i;
	}
	
}
