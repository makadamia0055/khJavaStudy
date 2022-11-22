package day22;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceMain {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 출석부 관리 프로그램 
		 * 1. 학생 등록
		 * 	-이름과 생년월일
		 * 2. 학생 수정
		 * 	-이름과 생년월일로 검색해서 이름과 생년월일 수정
		 * 3. 학생 삭제
		 * -이름과 생년월일로 검색해서 이름과 생년월일 삭제
		 * 4. 학생 출결 확인
		 * 	이름과 생년월일로 검색해서 해당 학생의 모든 출결을 확인
		 * 
		 * 5. 출석 입력
		 * 	- 날짜 입력 : 2022-11-22 
		 * 	- 출석 : O, 지각 : / , 조퇴 : \, 결석 :X
		 * 	- 홍길동 출석 현황 : O
		 * 	- 임꺽정 출석 현황 : X
		 * 	
		 * 6. 출석 수정
		 * 	- 날짜 입력:
		 * 	- 수정할 학생의 이름과 생년//혹은 검색?
		 * 	
		 * 7. 출석 삭제
		 * 	- 날짜 입력하여 해당 날짜 출석 삭제
		 * 
		 * 8. 날짜별 출석 확인
		 * 	- 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
		 * 
		 * 9. 프로그램 종료.
		 * 
		 */
		ArrayList<Attendance> list = new ArrayList<Attendance>();
		ArrayList<Student> stdList = new ArrayList<Student>();
		int mainMenu = -1;
		do {
			printMainMenu();
			mainMenu = selectMenu(1, 3);
			runMainMenu(mainMenu, list, stdList);
		}while(mainMenu!=3);
	}

	private static void runMainMenu(int mainMenu, ArrayList<Attendance> list, ArrayList<Student> stdList) {
		int submenu = 0;
		switch(mainMenu) {
		case 1:
			submenu = 0;
			System.out.println("학생 관리 메뉴입니다.");
			printStdMenu();
			submenu = selectMenu(1, 5);
			runStdMenu(submenu, list, stdList);
			break;
		case 2:
			submenu = 0;
			System.out.println("출결 관리 메뉴입니다.");
			printAtdMenu();
			submenu = selectMenu(1, 5);
			runAtdMenu(submenu, list, stdList);
			break;
		case 3:
			break;
			default:
		}
		
	}

	private static void runStdMenu(int submenu, ArrayList<Attendance> list, ArrayList<Student> stdList) {
		switch(submenu) {
		case 1:
			System.out.println("1. 학생 등록");
			
			System.out.println("학생 등록 메뉴입니다.");
			int ssubmenu =0;
			do {
				Student tmpStudent = insertStudent(stdList);
				stdList.add(tmpStudent);
				System.out.println("더 등록 하시겠습니까? 1.계속/2.그만");
				ssubmenu=scan.nextInt();
				
			}while(ssubmenu !=2);
			
			
			
			break;
		case 2: 
			System.out.println("2. 학생 인적사항 수정");
			System.out.println("수정할 학생을 검색합니다.");
			System.out.println("수정할 학생 이름 : ");
			String name = scan.next();
			System.out.println("학생의 생년월일 : 예)910715");
			int birth = scan.nextInt();
			
			Student tmpStudent = new Student(name, birth);
			if(stdList.contains(tmpStudent)) {
				System.out.println(name+" 학생을 수정합니다");
				
				System.out.println(tmpStudent.getName()+"-> : ");
				name = scan.next();
				System.out.println(tmpStudent.getBirth()+"-> : ");
				birth = scan.nextInt();
				
				System.out.println(name+" : "+birth+ " 로 수정 완료 했습니다.");
				Student editStudent = new Student(name, birth);
				stdList.remove(tmpStudent);
				stdList.add(editStudent);
				
			}else {
				System.out.println("검색한 학생을 찾을 수 없습니다.");
			}
			
			break;
		case 3: 
			System.out.println("3. 학생 삭제");
			System.out.println("삭제할 학생을 검색합니다.");
			System.out.println("삭제할 학생 이름 : ");
			name = scan.next();
			System.out.println("학생의 생년월일 : 예)910715");
			birth = scan.nextInt();
			
			tmpStudent = new Student(name, birth);
			if(stdList.contains(tmpStudent)) {
				System.out.println(name+" 학생을 삭제합니다");
				
				
				stdList.remove(tmpStudent);
				System.out.println("삭제 완료");
				
			}else {
				System.out.println("검색한 학생을 찾을 수 없습니다.");
			}
			
			
			break;
		case 4:
			System.out.println("4. 학생 출결 확인");
			System.out.println("출결을 확인할 학생을 검색합니다.");
			System.out.println("학생 이름 : ");
			name = scan.next();
			System.out.println("학생의 생년월일 : 예)910715");
			birth = scan.nextInt();
			
			tmpStudent = new Student(name, birth);
			if(stdList.contains(tmpStudent)) {
				System.out.println(name+" 학생의 출결을 열람합니다.");
				for(Attendance tmp : list) {
					tmp.printByName(tmpStudent.getName());
				}
				
				
			}else {
				System.out.println("검색한 학생을 찾을 수 없습니다.");
			}
			
			
			break;
		case 5: 
			System.out.println("메인 메뉴로 돌아갑니다.");

			break;
			default:
			
		}
		
	}
	
	private static Student insertStudent(ArrayList<Student> stdList) {
		System.out.println("등록할 학생 이름을 입력해주십시오.");
		String name = scan.next();
		System.out.println("학생의 생년월일을 입력해주십시오.예)910715");
		int birth = scan.nextInt();
		
		System.out.println(name+" : "+birth+ "학생이 등록 완료 되었습니다.");
		Student tmpStudent = new Student(name, birth);
		return tmpStudent;
	}

	private static void runAtdMenu(int submenu, ArrayList<Attendance> list, ArrayList<Student> stdList) {
		switch(submenu) {
		case 1:
			System.out.println("1. 출석 사항 입력");
			System.out.println("날짜를 입력해주십시오.");
			String date = scan.next();
			for(Attendance tmp : list) {
				if(tmp.getDate().equals(date)) {
					System.out.println("이미 기입한 출석부 날짜입니다.");
					break;
				}
			}
					Attendance newAtd = new Attendance(date, stdList);
					boolean tf=newAtd.scanArray();
					if(tf) {
						System.out.println("성공적으로 "+date+"일의 출석부가 기입되었습니다.");
						list.add(newAtd);
					}else {
						System.out.println("입력된 학생 수가 없습니다.");
					}
					
			break;
		case 2: 
			System.out.println("2. 출석 사항 수정");
			System.out.println("날짜를 입력해주십시오.");
			date = scan.next();
			Attendance tmpAtd = searchlist(list, date);
				if(tmpAtd==null) {
					System.out.println("수정할 날짜의 출석부가 없습니다.");
				}else {
					
				
					System.out.println(tmpAtd.getDate()+"일자의 출석 사항 수정합니다.");
					tf=tmpAtd.scanArray();
					if(tf) {
						System.out.println("성공적으로 "+date+"일의 출석부를 수정하였습니다.");
					}else {
						System.out.println("수정에 실패하였습니다.");
					}
					
				}
			
			break;
		case 3: 
			System.out.println("3. 출석 일자 삭제");
			System.out.println("날짜를 입력해주십시오.");
			date = scan.next();
			for(Attendance tmp : list) {
				if(tmp.searchByDate(date)!=null) {
					System.out.println("정말로 "+tmp.getDate()+"일자 출석부를 삭제합니까? Y/N");
					char tmpch = scan.next().toUpperCase().charAt(0);
					if(tmpch=='Y') {
						list.remove(tmp);
						System.out.println("삭제롤 완료했습니다.");
						break;
					}else if(tmpch=='N'){
						System.out.println("삭제를 취소하고 돌아갑니다.");
						break;
					}else {
						System.out.println("잘못된 값을 입력하여 돌아갑니다.");
					}
					break;
				}
			}
		
			break;
		case 4:
			System.out.println("4. 날짜별 출석 확인");
			System.out.println("날짜를 입력해주십시오.");
			date = scan.next();
			boolean isFounded = false;
			for(Attendance tmp : list) {
				if(tmp.searchByDate(date)!=null) {
					System.out.println(tmp.getDate()+"일자의 출석 사항입니다.");
					tmp.print();
					isFounded = true;
					
				}
			}
			if(!isFounded) {
				System.out.println("해당 일자의 출석 기록을 찾지 못했습니다.");
			}
			break;
		case 5: 
			System.out.println("메인 메뉴로 돌아갑니다.");
			break;
			default:
			
		}
		
	}
	

	private static Attendance searchlist(ArrayList<Attendance> list, String date) {
		for(Attendance tmp : list) {
			if(tmp.searchByDate(date)!=null) {
				return tmp;
			}
			
	}
		return null;
	}
	private static int selectMenu(int min, int max) {
		int tmp = -1;
		do {
			tmp = scan.nextInt();
			if(tmp>=min&&tmp<=max) {
				return tmp;
			}else {
				scan.nextLine();
				System.out.println("잘못된 입력입니다.");
				//예외 처리 나중에
				continue;
			}			
		}while(true);
		
	}

	private static void printMainMenu() {
		System.out.println();
		System.out.println("=======================");
		System.out.println("출석부 관리 프로그램 메뉴");
		System.out.println("1. 학생 관리 메뉴");
		System.out.println("2. 출결 관리 메뉴");		
		System.out.println("3. 프로그램 종료");
		System.out.println("=======================");
		System.out.println();
		
		
	}
	private static void printStdMenu() {
		System.out.println("학생 관리 메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 인적사항 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 출결 확인");
		System.out.println("5. 뒤로 가기");
	}
	
	private static void printAtdMenu() {
		System.out.println("출결 관리 메뉴");
		System.out.println("1. 출석 사항 입력");
		System.out.println("2. 출석 사항 수정");
		System.out.println("3. 출석 일자 삭제");
		System.out.println("4. 날짜별 출석 확인");
		System.out.println("5. 뒤로 가기");

	}

}
