package day03;

import java.util.Scanner;

public class SwitchEx02 {
	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 스위치문으로 작성하세요
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		char ch;
		System.out.print("두 정수와 산술연산자를 입력해주세요 예) 1 + 2 :");
		num1 = scan.nextInt();
		ch = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		switch(ch) {
		case '+': 
			System.out.printf("%d %c %d = %d", num1, ch, num2, num1 + num2);
		break;
		case '-': 
			System.out.printf("%d %c %d = %d", num1, ch, num2, num1 - num2);
		break;
		case '*': 
			System.out.printf("%d %c %d = %d", num1, ch, num2, num1 * num2);
		break;
		case '/': 
			System.out.printf("%d %c %d = %.1f", num1, ch, num2, num1 / (float) num2);
		break;
		case '%': 
			System.out.printf("%d %c %d = %d", num1, ch, num2, num1 % num2);
		break;
		default: 
			System.out.println("산술 연산자가 입력되지 않았습니다.");
		
		
		}
		
		scan.close();
		
		
		
		
	}

}
