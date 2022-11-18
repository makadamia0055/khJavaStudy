package day09;
import java.util.Scanner;
public class StudentManager {

	public static void main(String[] args) {
		/* class를 활용한 학생 정보 관리 프로그램
		 * 추상화
		 * 
		 * 메뉴 => do while로 구현?
		 * 1. 학생 추가
		 * 2. 학생 성적 추가
		 * 3. 학생 정보 출력
		 * 4. 프로그램 종료
		 */
		int menu;
		HighStudent[] stdList = new HighStudent[30];
		
		int count = 0;
		
		do {//메뉴 출력
			printmenu();
			
			//메뉴 선택(입력)
			menu = selectMenu();
			
			count=runMenu(menu, stdList, count);
		
			
		}while(menu!=4);
		
	}

	// 메뉴 출력하는 메소드
	
	public static void printmenu() {
		/**
		 * 메뉴를 출력하는 메소드
		 */
		System.out.println("---------------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 정보 출력");
		System.out.println("4. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요. :  ");
	}
	
	public static int selectMenu() {
	/** 콘솔에서 입력받은 정수(메뉴)를 알려주는 메소드
	 * @return 입력받은 정수(메뉴)
	 */
	Scanner scan = new Scanner(System.in);
	int menu = scan.nextInt();
	if(menu<1||menu>4) {
		System.out.println("유효하지 않은 입력입니다.");
		return 0;
	} else {
		scan.close();

		return menu;
	}
		
	}
	/**
	 * 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 * @param list 학생들 정보를 저장할 리스트
	 * @return 현재 저장된 학생 수
	 */
	public static int runMenu(int menu, HighStudent[] list, int count) {
		// 선택한 메뉴에 맞는 기능 실행
		int grade, classNum, num;
		String name;
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1:
			//학생 추가
			//학생 정보 입력
			System.out.print("학생정보 입력(학년, 반, 번호, 이름)");
			grade = scan.nextInt();
			classNum = scan.nextInt();
			num = scan.nextInt();
			name = scan.next();
			
			//리스트에 학생 정보 추가
			list[count]= new HighStudent(grade, classNum, num, name);
			
			count++;
			//리스트에 들어가있는 학생 수 1증가
			break;
		case 2: // switch문은 case하나에서 변수를 선언하면 다른 case에서 변수 중복으로 선언 안됨. 
			// 학생 성적 추가
			
			// 학생 선택
			for(int i = 0; i<=count; i++) {
				System.out.println((i+1)+"번"+list[i].getName());
			}
			
			// 변수 tmp에 몇번 학생 성적 입력받을 것인지 입력받기 
			//(단 이 수tmp는 count 이하)
			
			System.out.print("몇번째 학생 성적을 입력하시겠습니까?");
			int tmp = scan.nextInt()-1;
			System.out.println();
			System.out.println(tmp+1+" 번째 학생 성적을 입력(국어, 영어, 수학 순)");
			// 학생 성적 입력받기 스캐너 변수 상단 선언
			int kor = scan.nextInt();
			int eng = scan.nextInt();
			int math = scan.nextInt();
			
			list[tmp].updateScore(kor, eng, math);
			System.out.println(tmp+1+" 번째 학생" + list[tmp].getName() + "학생 성적 처리가 완료되었습니다.");
			// list[tmp-1]로 해당 객체 접근
			
			
			//updateScore(int kor1, int eng1, int math1) 메서드 사용
			
			
			break;
		case 3:
			//학생 정보 출력
			for(int i = 0; i<=count; i++) {
				list[i].print();
			}
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
			
			default:
				System.out.println("잘못된 메뉴입니다.");
	
		}
		return count;
					//1.학생 추가
					
					//2.학생 성적 추가
					
					//3.학생 성적 추가
					
					//4. menu 밖으로 빼서 생략
	}
}
