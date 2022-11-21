package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx01 {

	public static void main(String[] args) {
		/*
		 * 리스트를 이용하여 다음 기능을 갖는 오늘의 할일 프로그램을 작성하세요.
		 * 메뉴 
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴선택 :
		 * ------------
		 * 1.
		 * 할일 입력 : 오후 수업 참여(띄어쓰기 포함 한 라인 읽기)
		 * 
		 *  2. 선택시 리스트 입력사항 숫자 붙여서 순서대로 출력되기
		 */
		ArrayList<String> toDoList = new ArrayList<String>();
		int menu=0;
		int min = 1, max = 4;
		do {
			printMenu();
			try {
				menu = selectMenu(min, max);
				runMenu(menu, toDoList);
			}catch(Exception e) {
				System.out.println("--------------");
				System.out.println(e.getMessage());
				System.out.println("--------------");
			}
		}while(menu!=max);
		
	}

	private static void runMenu(int menu, ArrayList<String> toDoList) throws Exception {
		
		switch(menu){
		
		case 1:
			runCase1(toDoList);
		break;
		case 2:
			runCase2(toDoList);			
		break;	
		case 3:
			runCase3(toDoList);
		break;
		case 4:
			System.out.println("프로그램을 종료합니다.");		
		break;
		default:
			throw new Exception("예외 발생 : 잘못된 메뉴입니다.");
		}
		
	}

	private static void runCase3(ArrayList<String> toDoList) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("→3. 할일 삭제");
		runCase2(toDoList);
		System.out.print("삭제할 할일 번호 선택 : ");
		int deleteNum = scan.nextInt()-1;
		scan.close();
		if(toDoList.size()<deleteNum||deleteNum<0) {
			throw new Exception("예외발생 : 삭제할 번호가 없습니다.");
			// 이거 이전에 아웃오브 바운드 예외가 먼저 발생
			// 그래서 중간 조건을 하나 넣어줌
		} else {
			String tmpstr=toDoList.get(deleteNum);
			toDoList.remove(deleteNum);
			System.out.println("\'"+tmpstr + "\' 일정이 성공적으로 삭제 되었습니다.");
			
		}
			
	}

	private static void runCase2(ArrayList<String> toDoList) throws Exception {
		System.out.println("---------------");
		if(toDoList.size()>0) {
			for(int i = 0; i < toDoList.size(); i++) {
				String tmpScd = toDoList.get(i);
				String tmpIndex = String.format("%s. ", i+1);
				tmpScd = tmpIndex + tmpScd ;
				System.out.println(tmpScd);
			}
		}else {
			throw new Exception("입력된 일정이 없습니다.");
			
		}
	}

	private static void runCase1(ArrayList<String> toDoList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------");
	System.out.println("→1. 할일 추가");
	System.out.println("추가할 스케줄을 기입해 주십시오.");
	String tmpScd = scan.nextLine();
	toDoList.add(tmpScd);
	//try 처리
	System.out.println("일정이 성공적으로 입력되었습니다.");
	System.out.println("---------------");
	scan.close();

	}

	private static int selectMenu(int min, int max) {
		Scanner scan = new Scanner(System.in);
		int tmp = 0;
		
		do {
		 tmp = scan.nextInt();
		 if(tmp>=min&&tmp<=max) {
			 scan.close();
			 return tmp;
		 }
		}while(true);
		
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 할일 추가");
		System.out.println("2. 할일 확인");
		System.out.println("3. 할일 삭제");
		System.out.println("4. 종료");
		System.out.print("메뉴선택 : ");

	}

}
