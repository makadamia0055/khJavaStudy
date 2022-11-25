package day25;

import java.util.Random;
import java.util.Scanner;

import lombok.Data;

public class Ex4_2 {
	private static Scanner scan = new Scanner(System.in);
	/*
	 * 컴퓨터와 가위 바위 보를 하는 프로그램을 작성하세요.
	 * -사용자가 연속 3번 이길때까지 반속
	 */
	public static void main(String[] args) {
		char cnt = 'Y';
		do {
				System.out.println("가위 바위 보 게임 시작");
				System.out.print("사용자 : ");
			try {
				String myRSPstr = scan.next();
				RPS user = RPS.valueOf(myRSPstr);
				RPS com = randomRPS();
				System.out.println("컴퓨터 : " + com);
				State state = resultState(user, com);
				printState(state);
			}catch(IllegalArgumentException e){
				System.out.println("잘못된 입력");
			}
				System.out.println("계속 플레이 하시겠습니까? Y/N");
				cnt = scan.next().toUpperCase().charAt(0);
		}while(cnt!='N');
		System.out.println("게임을 종료합니다.");
		
	}
	private static void printState(State state) {
		switch(state) {
		case WIN:
			System.out.println("사용자가 이겼습니다.");
			break; 
		case DRAW:
			System.out.println("사용자가 비겼습니다.");

			break;
		case LOSE:
			System.out.println("사용자가 졌습니다.");

			break;			
		}
	}
	private static State resultState(RPS user, RPS com) {
		if(user==com) {
			return State.DRAW;
		}
		
		switch(user) {
		case 가위 : 
			return com == RPS.보? State.WIN: State.LOSE;
			
		case 바위 :
			return com == RPS.가위? State.WIN: State.LOSE;
		case 보 : 
			return com == RPS.바위? State.WIN: State.LOSE;
			default:
		}
		return null;
	}
	private static RPS randomRPS() {
		RPS[] rpss = RPS.values();
		int r = (int)(Math.random()*3);
		return rpss[r];
	}
	
}

enum RPS{
	가위, 바위, 보
}

enum State{ // 사용자 기준
	WIN, LOSE, DRAW
}