package day16;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserManagerMain {

	public static void main(String[] args) {
		/* 회원 정보를 관리하는 프로그램을 작성하세요.
		 * -회원 정보는 아이디, 비번, 이름, 나이, 주민번호로 구성
		 * -기능 1 : 회원 추가
		 * -기능 2 : 회원 검색
		 * -기능 3 : 회원정보 수정
		 * -기능 4 : 회원 삭제
		 * */
		Scanner scan = new Scanner(System.in);
		UserProfiler UP = new UserProfiler(scan); 
		UserManagerService UMS = new UserManagerServiceImp(); 
		//테스트용 코드
		UP.getUserMap().put("jinsun1", new UserProfile("jinsun1", "manbae", "강진선", 54, "192372"));
		UP.getUserMap().put("sunhong2", new UserProfile("sunhong2", "manbae", "민선홍", 54, "192372"));
		UP.getUserMap().put("suinn3", new UserProfile("suinn3", "manbae", "이수인", 54, "192372"));
		UP.getUserMap().put("dohum4", new UserProfile("dohum4", "manbae", "이도흠", 54, "192372"));
		UP.getUserMap().put("suengsu5", new UserProfile("suengsu5", "manbae", "이승수", 54, "192372"));
		UP.getUserMap().put("jungmin6", new UserProfile("jungmin6", "manbae", "정민", 54, "192372"));

		int menu =-1;
		do {
			UMS.printMenu("1. 회원 추가\n"
					+ "2. 회원 검색\n"
					+ "3. 회원 정보 수정\n"
					+ "4. 회원 삭제\n"
					+ "5. 프로그램 종료\n");
			try {
			menu = UMS.selectMenu(scan, 1, 5);
			UMS.runMenu(menu, UP, scan);
			}catch(InputMismatchException e) {
				System.out.println("입력오류가 발생했습니다.\n메인메뉴로 돌아갑니다.");
				scan.nextLine();
				
				continue;
			}
			
		}while(menu!=5);
		
		
		
	}

}
