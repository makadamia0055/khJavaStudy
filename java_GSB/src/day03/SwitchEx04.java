package day03;

import java.util.Scanner;

public class SwitchEx04 {

	public static void main(String[] args) {
		/* 월을 입력받아 해당하는 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int month;
		System.out.print("마지막 일을 알고 싶은 달을 입력해주세요 : ");
		month = scan.nextInt();
		
			
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println("해당 달의 마지막 일은 "+ month + "월 31일입니다.");
			break;
		
		
		case 4, 6, 9, 11:
			System.out.println("해당 달의 마지막 일은 "+ month + "월 30일입니다.");
			break;
		// case 4: case 6: case 9: case 11: 도 가능;
			
			
		case 2:
			System.out.println("해당 달의 마지막 일은 "+ month + "월 28일입니다.");
			break;
			
			default: System.out.println("정확한 월을 입력해주세요.");
		
		
		
		}
		
		scan.close();
		
		
	}

}
