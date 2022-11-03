package day09;

import java.util.Scanner;
import day09.Baseball;
public class BaseballManager {

	public static void main(String[] args) {
		/* 숫자 야구게ㅐ임을 플레이 한 후, 기록을 저장하는 프로그램을 
		 * 작성하세요.
		 * 메뉴
		 * 1. 플레이
		 *  레거시 코드 활용
		 *  플레이 카운터 추가
		 *  플레이 카운터 리턴
		 *  
		 *  플레이 종료 후 이름 입력받기. 
		 *  
		 *  이름 입력받으면 그걸 플레이카운터와 함께 배열에 저장
		 * 	// 컴퓨터가 랜덤으로 숫자 생성
		 * 
		 * 	// 사용자가 숫자 입력
		 * 
		 * 	// 판별
		 * 
		 * 	// 3S 종료
		 * 
		 * 	// new 회수를 기록(최대 5등 횟수가 동일한 경우 먼저 플레이 한 
		 * 	// 사용자 기록을 유지해야함.)
		 * 
		 * 
		 * 2. 기록 확인
		 *  배열에서 베스트 5인 출력
		 *  
		 * 
		 * 
		 * 3. 종료
		 * 
		 * 종료
		 * 
		 * 메뉴선택 2
		 * 1. 홍길동 2회
		 * 2. 임걱정 3회
		 * 3. 이몽룡 3회
		 * 4. 춘향이 4회
		 * */
		int menu =0;
		do {
			printmenu();
			menu = selectMenu();
			
			
			
		} while(menu!=3);
		Baseball bsGame = new Baseball();
		Scanner scan = new Scanner(System.in);
		int currentPlayCnt;
		int[] rslt ;
	switch(menu){
	case 1:
		//do {
		System.out.println("임의의 세 숫자를 입력해주세요.");
		//int[] myNum = scanArray(scan, 3);
		//rslt = bsGame.judge(myNum);
		//bsGame.printJudge(myNum);
		//currentPlayCnt = bsGame.getPlayCnt();
		//System.out.println("현재 " + currentPlayCnt +"회");
		//if(rslt[0]==3) {
			//break;
		//}
		//} while(true);
		
		//System.out.println("-----------");
		//System.out.println("총"+ bsGame.getPlayCnt() + "회 걸렸습니다.");
		//System.out.println("-----------");

		
		break;
	case 2:
		break;
		
	case 3:
		break;
		
		default:
	}
		
		
		
		
		
		
	}
	public static void printmenu() {
		/**
		 * 메뉴를 출력하는 메소드
		 */
		System.out.println("---------------");
		System.out.println("1. 야구게임 플레이");
		System.out.println("2. 스코어 보기");
		System.out.println("3. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요. :  ");
	}
	
	public static int selectMenu() {
	/** 콘솔에서 입력받은 정수(메뉴)를 알려주는 메소드
	 * @return 입력받은 정수(메뉴)
	 */
	Scanner scan1 = new Scanner(System.in);
	int menu = scan1.nextInt();
	if(menu<1||menu>3) {
		System.out.println("유효하지 않은 입력입니다.");
		return 0;
	} else {
		return menu;
	}
		
	}
	
	public static int[] scanArray(Scanner scan, int size) {
		if(size <=0) {
			return null;
		}
		
		int [] arr = new int[size];
		for(int i = 0 ; i< size; i++) {
			arr[i] = scan.nextInt();
		}
		return arr;
	} 
}
