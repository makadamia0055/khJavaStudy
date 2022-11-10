package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx03 {

	public static void main(String[] args) {
		/* 다음과 같은 메뉴를 출력하고 정수를 입력받는 코드를 작성하세요.
		 * 단, 종료를 선택하면 프로그램이 종료되고, 정수가 아닌문자열이 입력되어도 프로그램이 계속 진행되게 하시오
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 * */ 
		Scanner scan = new Scanner(System.in);
		int menu=0;
		do {
			printMenu();
		
		try {
		menu=scan.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("잘못된 입력 오류. 숫자를 입력해주세요.");
			scan.nextLine(); // 입력버퍼 초기화
		}
			
		}while(menu!=3);
		
		
		
	}

	private static void printMenu() {
		System.out.println("메뉴\n"
				+ "1.플레이\n"
				+ "2.기록확인\n"
				+ "3.종료\n");
		System.out.print("메뉴선택 : ");
	}

}
