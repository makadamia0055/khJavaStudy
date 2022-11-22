package day22_t;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceMain {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		int menu = -1;
		Attendance attendance = new Attendance();
		do {
			printMainMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu, attendance);
			
		}while(menu!=3);
	}

	private static void runMenu(int menu, Attendance attendance) {
		ArrayList<Student> stds = attendance.getStds();
		ArrayList<Log> logs = attendance.getLogs();
		switch(menu) {
		case 1:
			managementStudents(stds);
			break;
		case 2: 
			//managementLogs(logs, stds);
			break;
		case 3:
			printStr("프로그램 종료");
			break;
			default:
				printStr("잘못된 메뉴입니다.");
		}
	}
	private static void managementStudents(ArrayList<Student> stds) {
		printSubMenu(1);
		int subMenu = scan.nextInt();
		scan.nextLine();
		switch(subMenu) {
		case 1: addStudent(stds);
			break;
		case 2:	updateStudent(stds);
			break;
		case 3: deleteStudent(stds);
			break;
		case 4:
			printStr("취소하고 돌아갑니다.");
			break;
			default:
				printStr("메뉴를 잘못 입력했습니다.");
		}
		
	}
	private static void deleteStudent(ArrayList<Student> stds) {
		if(stds==null) {
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		}
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("나이 입력 : ");
		String birth = scan.nextLine();
		Student std = new Student(name, birth);
		int index =stds.indexOf(std);
		
		if(index== -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return;
		}
		
		stds.remove(index);
		printStr("학생 정보를 삭제했습니다.");
		
	}
	

	private static void updateStudent(ArrayList<Student> stds) {
		if(stds==null) {
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		}
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("나이 입력 : ");
		String birth = scan.nextLine();
		Student std = new Student(name, birth);
		int index =stds.indexOf(std);
		
		if(index== -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return;
		}
		System.out.print("수정할 이름 입력 : ");
		name = scan.nextLine();
		System.out.print("수정할 나이 입력 : ");
		birth = scan.nextLine();
		Student searchStd = stds.get(index);
		std = new Student(name, birth);
		stds.set(index, std);
		printStr("학생 정보를 추가했습니다.");
		System.out.println(stds);
	}

	public static void addStudent(ArrayList<Student> stds) {
		if(stds==null) {
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		}
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("나이 입력 : ");
		String birth = scan.nextLine();
		Student std = new Student(name, birth);
		if(stds.indexOf(std)!= -1) {
			printStr("학생 정보를 추가하지 못했습니다");
			return;
		}
		stds.add(std);
		printStr("학생 정보를 추가했습니다.");
		
	}

	private static void printStr(String str) {
		System.out.println(str);
		pb();
	}
	
	private static void printMainMenu() {
		System.out.println();
		pb();
		System.out.println("출석부 관리 프로그램 메뉴");
		System.out.println("1. 학생 관리 메뉴");
		System.out.println("2. 출결 관리 메뉴");		
		System.out.println("3. 프로그램 종료");
		pb();
		System.out.println();
		
		
	}
	private static void printSubMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("학생 관리 메뉴");
			pb();
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 취소");
			pb();
			System.out.print("메뉴선택 : ");
			break;
			
		case 2:
			System.out.println("학생 관리 메뉴");
			pb();
			System.out.println("1. 출석 체크 ");
			System.out.println("2. 출석 확인 - 개별");
			System.out.println("3. 출석 확인 - 날짜별");
			System.out.println("4. 출석 수정");
			System.out.println("5. 출석 삭제");
			System.out.println("6. 취소");
			pb();
			System.out.print("메뉴선택 : ");
			break;
			
			default : printStr("잘못된 메뉴입니다.");
		}
	}

	private static void pb() {
		System.out.println("=======================");
		
	}
}