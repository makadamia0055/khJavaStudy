package day03;

import java.util.Scanner;
public class IfEx06 {
	public static void main(String[] args) {
		/* Scanner를 입력받아 +, -, *, /, %이면 산술 연산자라고 출력하고
		 * 아니면 산술 연산자가 아닙니다 라고 출력하는 코드를 작성
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		char ch;
		System.out.print("char 문자를 입력하시오");
		ch = scan.next().charAt(0);
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='%') {
			System.out.println("산술연산자입니다.");
		} else {
			System.out.println("산술연산자가 아닙니다.");
		}
		scan.close();
		
		
		
		
		
		
		
	}

}
