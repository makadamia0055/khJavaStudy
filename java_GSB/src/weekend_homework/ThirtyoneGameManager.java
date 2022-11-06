package weekend_homework;

import java.util.Scanner;

import weekend_homework.ThirtyoneGame.Com;

public class ThirtyoneGameManager {
	public static void main(String[] args) {
		
		
		/*
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 */
		
		ThirtyoneGame toG = new ThirtyoneGame();
		int menu=0;
		do {
			
			printMenu();
			menu = scanMenu();
			runMenu(menu, toG);
			
		} while(menu!=3);
		
		
	}

	public static void printMenu() {
		System.out.println();
		System.out.println("-----------------");
		System.out.println("1. 플레이");
		System.out.println("2. 기록 확인");
		System.out.println("3. 종료");
		System.out.println("-----------------");
		System.out.println();
		
	}
	
	public static int scanMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택해주세요 : ");
		int menu;
		do {
		menu = scan.nextInt();
		if(menu<1||menu>3) {
			System.out.println("잘못된 입력입니다.");
		} else {
			break;
		}
		}while(true);
				
		return menu;
	}
	
private static void runMenu(int menu, ThirtyoneGame toG) {
		
	
	switch(menu){
	case 1:
		runGame(toG);
		break;
	case 2:
		System.out.println();
		System.out.printf("총 %d 게임\n", toG.getWinCount(1)+toG.getWinCount(2));
		System.out.printf("인간 %d승 %d패\n", toG.getWinCount(2), toG.getWinCount(1));
		System.out.printf("컴퓨터 %d승 %d패\n", toG.getWinCount(1), toG.getWinCount(2));
		System.out.println();		
		break;
		
		
	case 3:
		System.out.println("게임을 종료합니다.");
		
		break;
	}
	
}

	


public static void runGame(ThirtyoneGame toG) {
	toG.startGame();
	int[] gameArr=toG.getThirtyoneArr();
	Com com = toG.getCom();
	//반복문 do while
	do {
		//컴퓨터 p1, 사용자 p2;
	// 컴 스타트 자리찾기 -롤(난수생성) -/움직임 결과 출력/- -(표시-판정)-넘기기
	
		int p1Index = toG.countStep(gameArr);
		System.out.println();
		System.out.println("컴퓨터가 "+ (p1Index+1)+"에서 출발!");
		int p1Step = toG.getCom().ranNum();
		toG.step(gameArr, p1Step, 1);
		toG.printStep(p1Index, p1Step);
		if(gameArr[30]!=0) {
			System.out.println("\"31!!\"");
			break;
		}
		
		int p2Index = toG.countStep(gameArr);
		System.out.println();
		System.out.println("→ 플레이어가 "+ (p2Index+1)+"에서 출발!");
		int p2Step = toG.scanMynum();
		toG.step(gameArr, p2Step, 2);
		toG.printStep(p2Index, p2Step);

		if(gameArr[30]!=0) {
			System.out.println("\"31!!\"");
			break;
		}
		
	// 사용자 스타트 자리찾기 -롤(입력받기)-/움직임 결과 출력/- -(표시 -판정) - 넘기기
	
	} while(true);	
		int winner = toG.whoIsWinner(gameArr);
		if(winner==1) {
			System.out.println("컴퓨터가 이겼습니다.");
			toG.setWinCount(winner);
		} else if(winner ==2) {
			System.out.println("인간이 이겼습니다.");
			toG.setWinCount(winner);

		} else {
			System.out.println("버그");
		}
		
	}
}
