package day05;

import java.util.Scanner;

public class WhileCharEx01 {

	public static void main(String[] args) {
		//문자를 입력받아 q이면 종료하고, 아니면 반복하는 코드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		char ch ;
		
		do {System.out.println("q를 입력하십시오.");
		ch = scan.next().charAt(0);
		} while(ch!='q');
		
		// do while을 쓰더라도 조건문의 변수 자체는 반복문 바깥에 선언해야하는듯
		
		while(true) {
			System.out.println("q를 입력하십시오.");
			ch = scan.next().charAt(0);
			if(ch=='q') {
				break;
			}
			
		}
		
		
		
		/*while(ch!='q') {
			System.out.println("q를 입력하십시오.");
			ch = scan.next().charAt(0);
						
		}*/
		
		
		
		
		
		
		
	}

}
