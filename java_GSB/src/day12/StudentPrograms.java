package day12;

import java.util.Scanner;
import day12.*;
public class StudentPrograms {

	public HighStudent[] HSArray;

	
	public void printMenu() {
		System.out.println();
		System.out.println("-----------------");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 성적 출력");
		System.out.println("4. 종료");
		System.out.println("-----------------");
		System.out.println();
		
	}

	
	public int selectMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택해주세요 : ");
		int menu;
		do {
		menu = scan.nextInt();
		if(menu<1||menu>4) {
			System.out.println("잘못된 입력입니다.");
		} else {
			break;
		}
		}while(true);
				
		return menu;
	}

	
	public void run(int menu) {
		
		int grade, classnum, stdnum;
		switch(menu) {
		case 1: // 학생 정보 추가
			System.out.println("학생 정보를 추가합니다.");
			System.out.println("학년, 반, 번호, 이름 순으로 입력해주십시오.");
			String name;
			Scanner scan = new Scanner(System.in);
			grade = scan.nextInt();
			classnum = scan.nextInt();
			stdnum = scan.nextInt();
			name = scan.next();
			
			HighStudent tmp = new HighStudent(grade, classnum, stdnum, name);
			if(findStd(tmp)) {
				System.out.println("이미 해당 학생이 존재합니다.");
				break;
			} else {
			HighStudent[] tmpHSArray = new HighStudent[HSArray.length+1];
			tmpHSArray[tmpHSArray.length-1] = tmp;
			System.out.printf("%d학년 %d반 %d번 %s학생이 정상적으로 저장되었습니다.", grade, classnum, stdnum, name);
			break;
			}
		case 2: // 학생 성적 추가
				
			break;
			
			
		case 3://학생 정보 출력
			
			break;
		case 4: //종료
			break;
			default:
				System.out.println("잘못된 접근 입니다.");
		}
	}
	
	

	/**
	 * 
	 * @param hsArray 학생 Array를 입력받음
	 * @param grade
	 * @param classnum
	 * @param stdnum
	 * @return
	 */
	public HighStudent findStd(int grade, int classnum, int stdnum) {
		HighStudent temp = new HighStudent(grade, classnum, stdnum, "temp");
		HighStudent rst =null;
		for(HighStudent tmp1 : HSArray) {
			if(temp.equals(tmp1)) {
				rst = tmp1;
			}
		}
		return rst;
		}
	public HighStudent findStd(HighStudent temp) {
		HighStudent rst =null;
		for(HighStudent tmp1 : HSArray) {
			if(temp.equals(tmp1)) {
				rst = tmp1;
			}
		}
		return rst;
		}
	
	
	
}
