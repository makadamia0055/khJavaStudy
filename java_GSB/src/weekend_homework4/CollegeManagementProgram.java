package weekend_homework4;

import java.util.Scanner;

public class CollegeManagementProgram {
	private Scanner scan = new Scanner(System.in);
	
//	-학부 등록/수정/삭제/조회
//	-강좌 등록/수정/삭제/조회
//	-교수 등록/수정/삭제/조회
//	-학생 등록/수정/삭제/조회
//	-수강 신청/취소/
//	-성적 등록/수정/조회

	
	public void run() {
		int menu = -1;
		
		do {
			printMainMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			
		}while(menu != 7);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			printSubMenu(1);
			runSubMenu(1);
			break;
		case 2: 
			printSubMenu(2);

			break;
		case 3: 
			printSubMenu(3);

			break;
		case 4: 
			printSubMenu(4);

			break;
		case 5: 
			printSubMenu(5);

			break;
		case 6: 
			printSubMenu(6);

			break;
		case 7: 
			System.out.println("종료합니다.");
			break;
		default: System.out.println("잘못된 메뉴 선택입니다.");
		}
}

	private void runSubMenu(int menu) {
	switch(menu) {	
		case 1: ; break;
		case 2: ; break;
		case 3: ; break;
		case 4: ; break;
		case 5: ; break;
		case 6: ; break;
		default: System.out.println("잘못된 메뉴 선택입니다.");
		}
	}
	private String returnSubStr(int menu) {
		String str ="";
		switch(menu) {
		case 1: str = "학부"; break;
		case 2: str = "강좌"; break;
		case 3: str = "교수"; break;
		case 4: str = "학생"; break;
		case 5: str = "수강"; break;
		case 6: str = "성적"; break;
		default: System.out.println("잘못된 메뉴 선택입니다.");
		}
		return str;
	}

	private void printSubMenu(int menu) {
		String str =returnSubStr(menu);
		
		if(menu<5) {
			System.out.println(str + " 관리 메뉴");
			System.out.println("----------------");
			System.out.println("1. " + str + " 등록" );
			System.out.println("2. " + str + " 수정" );
			System.out.println("3. " + str + " 삭제" );
			System.out.println("4. " + str + " 조회" );
			System.out.println("5. 뒤로 가기");
			System.out.println("----------------");
			System.out.print("메뉴 선택 : ");

		}else if(menu == 5) {
			System.out.println("수강 신청 관리 메뉴");
			System.out.println("----------------");
			System.out.println("1. 수강 신청" );
			System.out.println("2. 수강 취소" );
			System.out.println("3. 뒤로 가기");
			System.out.println("----------------");
			System.out.print("메뉴 선택 : ");
		}else if(menu == 6) {
			System.out.println(str + " 관리 메뉴");
			System.out.println("----------------");
			System.out.println("1. " + str + " 등록" );
			System.out.println("2. " + str + " 수정" );
			System.out.println("3. " + str + " 조회" );
			System.out.println("4. 뒤로 가기");
			System.out.println("----------------");
			System.out.print("메뉴 선택 : ");
		}else{
			return;
		}
		
	}

	private void printMainMenu() {
		System.out.println("=======메인 메뉴=======");
		System.out.println("1. 학부 관리 메뉴");
		System.out.println("2. 강좌 관리 메뉴");
		System.out.println("3. 교수 관리 메뉴");
		System.out.println("4. 학생 관리 메뉴");
		System.out.println("5. 수강 관리 메뉴");
		System.out.println("6. 성적 관리 메뉴");
		System.out.println("7. 종료");
		System.out.println("======================");
		System.out.print("메뉴 선택 : ");
	}
}
