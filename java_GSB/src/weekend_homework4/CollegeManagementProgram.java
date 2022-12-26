package weekend_homework4;

import java.sql.SQLException;
import java.util.Scanner;

public class CollegeManagementProgram {
	private Scanner scan = new Scanner(System.in);
	private DBManager dbm = new DBManager();
//	-학부 등록/수정/삭제/조회
//	-강좌 등록/수정/삭제/조회
//	-교수 등록/수정/삭제/조회
//	-학생 등록/수정/삭제/조회
//	-수강 신청/취소/
//	-성적 등록/수정/조회

	
	public void run() {
		int menu = -1;
		dbm.connect();
		do {
			printMainMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			
		}while(menu != 7);
	}

	private void runMenu(int menu) {
		int submenu = -1;
		switch(menu) {	
		case 1: case 2: case 3: case 4: 
			
			submenu = -1;
			do {
				printSubMenu(menu);
				submenu = scan.nextInt();
				scan.nextLine();
				try {
					runSubMenu(menu, submenu);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}while(submenu !=5);
			
			
			
			break;
			
		case 5: 
			submenu = -1;
		do {
			printSubMenu(menu);
			submenu = scan.nextInt();
			scan.nextLine();
			try {
				runSubMenu(menu, submenu);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}while(submenu !=3);
		
		break;
		
		case 6: 
			
			submenu = -1;
			do {
				printSubMenu(menu);
				submenu = scan.nextInt();
				scan.nextLine();
				try {
					runSubMenu(menu, submenu);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}while(submenu !=4);
			
			 break;
		case 7: 
			
			System.out.println("종료합니다.");
			dbm.connectClose();
			break;
			
		default: System.out.println("잘못된 메뉴 선택입니다.");
		}
	}
	private void runSubMenu(int menu, int submenu) throws SQLException {
		Object obj = returnObj(menu);
		switch(menu) {
		case 1: case 2: case 3: case 4: 
			
			switch(submenu) {
			case 1: 
				dbm.insertObj(obj);
				break;
			case 2: 
				dbm.updateObj(obj);
				break;
			case 3: 
				dbm.deleteObj(obj);
				break;
			case 4: 
				dbm.selectObj(obj);
				break;
			case 5: break;
			default: System.out.println("잘못된 메뉴 선택입니다.");
			}
			
			
			break;
		case 5: 
			switch(submenu) {
			case 1: 
				dbm.insertObj(obj);
				break;
			case 2: 
				dbm.deleteObj(obj);
				break;
			case 3: 
				
				break;
			default: System.out.println("잘못된 메뉴 선택입니다.");
			}
			
			 break;
		case 6: 
			
			switch(submenu) {
			case 1: 
				dbm.insertObj(obj);
				break;
			case 2: 
				dbm.updateObj(obj);
				break;
			case 3: 
				dbm.selectObj(obj);
				break;
			case 4: break;
			default: System.out.println("잘못된 메뉴 선택입니다.");
			}
			
			 break;
		case 7: 
			System.out.println("종료합니다.");
			break;
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
	
	private Object returnObj(int menu) {
		Object obj = null;
		switch(menu) {
		case 1: obj = new Department(); break;
		case 2: obj = new Lecture(); break;
		case 3: obj = new Professor(); break;
		case 4: obj = new Student(); break;
		case 5: obj = new Course(); break;
		case 6: obj = new Score(); break;
		default: System.out.println("잘못된 메뉴 선택입니다.");
		}
		return obj;
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
