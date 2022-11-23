package day22_t;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AttendanceMain {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		int menu = -1;
		Attendance attendance = new Attendance();
		do {
			try {	
				printMainMenu();
				menu = scan.nextInt();
				scan.nextLine();
				runMenu(menu, attendance);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
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
			managementLogs(logs, stds);
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
	private static void addStudent(ArrayList<Student> stds) {
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
	private static void managementLogs(ArrayList<Log> logs, ArrayList<Student> stds) {
		printSubMenu(2);
		int subMenu = scan.nextInt();
		scan.nextLine();
		
		pb();
		switch(subMenu) {
		case 1: checkLog(stds, logs); 
				sortLogs(logs); // 일지 정렬
		break;
		case 2: // 개별체크
			printLogsByStudent(logs);
			break;
		case 3:
			printLogsByDate(logs);
			break;
		case 4:
			updateLogs(logs);// 수정 
			break;
		case 5: // 삭제 
			deleteLogs(logs);
			break;
		case 6: printStr("취소합니다."); break;
		default: printStr("잘못된 메뉴 선택입니다.");
		}
		
	}

	private static void checkLog(ArrayList<Student> stds, ArrayList<Log> logs) {
		// 날짜 입력
		System.out.print("출석부 날짜(yy.MM.dd) : ");
		String date  = scan.nextLine();
		pb();
		if(checkLogDate(logs, date)) {
			printStr("이미 기입된 날짜입니다.");
			return ;
		}
		
		
		
		
		
		// 이미 입력된 날짜인지 확인 필요.
		
		//출석 상태 정보 출력(결석 : X, 출석 : O, 지각: /, 조퇴 : \)
		printStr("결석 : X, 출석 : O, 지각: /, 조퇴 : \\");
		//StudentLog를 리스트로 생성
		ArrayList<StudentLog> stdLogs = new ArrayList<StudentLog>();
		
		
		//반복 
		for(Student std : stds) {
			System.out.println(std.getName() + "(" + std.getBirthday() + ") : ");
			String state = scan.nextLine();
			StudentLog stdLog = new StudentLog(std, state);
			stdLogs.add(stdLog);
		}
		Log log = new Log(stdLogs, date);
		
		logs.add(log);
	
		//StudentLog를 생성 // Student와 출석 상태 저장
			// 학생 이름과 생일 출력
			// 출석 상태 입력 받기
			// Log의 필드에 존재하는 StudentLog 리스트에 StudentLog 추가 
		
		//StudentLog 리스트와 날짜를 이용하여 Log객체를 생성
		
		// Attendance의 필드에 존재하는 Log 리스트에 생성된 Log 객체를 추가
	}

	private static boolean checkLogDate(ArrayList<Log> logs, String date) {
		if(logs==null||date==null) {
			throw new RuntimeException("일지 리스트가 없거나 입력된 날짜가 없습니다.");
		}
		if(logs.size()==0) {
			return false;
		}
		for(Log tmp : logs) {
			if(tmp.getDate().equals(date)) {
				return true;
			}
		}
		return false;
	}
	
	private static void sortLogs(ArrayList<Log> logs) {
		if(logs==null || logs.size() == 0) {
			return;
		}
			Collections.sort(logs, (o1, o2)->o1.getDate().compareTo(o2.getDate()));
		}
	private static void printLogsByStudent(ArrayList<Log> logs) {
		if(logs==null || logs.size()==0) {
			printStr("등록된 출석일지가 없습니다.");
			return;
		}
		// 이름을 입력 받고 
		System.out.println("이름 : ");
		String name = scan.nextLine();
		pb();
		for(Log log : logs) {
			for(StudentLog slog : log.getSlogs()) {
				if(slog.getStd().getName().equals(name)){
					System.out.println(log.getDate() +" : " + slog.getState());
				}
			}
		}
	}
	private static void printLogsByDate(ArrayList<Log> logs) {
		// 날짜 입력 받고 
		System.out.println("날짜 입력 : ");
		String date = scan.nextLine();
		// 날짜와 일치하는 출석 기록 확인
		// 학생 이름(생일) : 출석상태
		for(Log log : logs) {
			if(log.getDate().equals(date)) {
				for(StudentLog slog : log.getSlogs()) {
					String name = slog.getStd().getName();
					String birth = slog.getStd().getBirthday();
					System.out.println(name + "("+ birth + ") : " + slog.getState());
				}
			}
		}
		
	}
	private static void updateLogs(ArrayList<Log> logs) {
		//날짜를 입력
		System.out.println("날짜 입력 : ");
		String date = scan.nextLine();
		pb();
		
		if(!checkLogDate(logs, date)) {
			printStr("해당 일자에 동록된 일지가 없습니다.");
			return;
		}
		//이름과 생년월일을 입력
		System.out.println("이름 입력 : ");
		String name = scan.nextLine();
		System.out.println("생일 입력 : ");
		String birth = scan.nextLine();
		
		//상태를 입력
		System.out.println("상태 입력 : ");
		String state = scan.nextLine();
		pb();
		
		for(Log log : logs) {
			if(log.getDate().equals(date)) {
				for(StudentLog slog : log.getSlogs()) {
					String tmpName = slog.getStd().getName();
					String tmpBirth = slog.getStd().getBirthday();
					if(tmpName.equals(state)&&tmpBirth.equals(birth)) {
						slog.setState(state);
					}
				}
				printStr("수정이 완료 됐습니다.");
				return;
			}
			
		}
		
		
		//입력한 정보와 일치하는 출석 정보 수정
		
	}
	
	private static void deleteLogs(ArrayList<Log> logs) {
		System.out.println("날짜 입력 : ");
		String date = scan.nextLine();
		pb();
		
		if(!checkLogDate(logs, date)) {
			printStr("해당 일자에 동록된 일지가 없습니다.");
			return;
		}
		for(int i = 0; i< logs.size(); i++) {
			if(logs.get(i).getDate().equals(date)) {
				logs.remove(i);
				printStr("삭제가 완료되었습니다.");
				return;
			}
		}
	}
	
	
}