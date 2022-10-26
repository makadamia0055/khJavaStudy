package day03;

import java.util.Scanner;

public class IfEx07 {

	public static void main(String[] args) {
		/* 두 정수와 문자를 입력받아 산술연산자라면 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 예시 
		 * 두 정수와 문자를 입력하세요 
		 */
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		char ch1;
		
		System.out.print("두 정수와 문자를 입력하세요. (예: 1 + 2):");
		num1 = scan.nextInt();
		ch1 = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		if(ch1=='+') { // 문제 해석 조건 막무가내로 조건문 만들지 말고, 조건 분기에서 
			// 같이 이루어질 수 없는 상황인지 체크하고, 조건문 만들기.
			// 예를 들어 ch1이 '+'이면서 '-'일 수 없으므로 else if로 연결가능
			System.out.println(num1+ "+" + num2 + "=" + (num1+num2));
		} else if(ch1=='-') {
			System.out.println(num1+"-"+ num2 + "=" + (num1-num2));
		} else if(ch1=='*') {
			System.out.println(num1+"*"+ num2 + "=" + (num1*num2));
		}else if(ch1=='/') {
			System.out.println(num1+"/"+ num2 + "=" + (num1/(double)num2));
		}else if(ch1=='%') {
			//System.out.println(num1+"%"+ num2 + "=" + (num1%num2));
			System.out.printf("%d %c %d = %d", num1, ch1, num2, num1%num2);
		} else {
			System.out.println(ch1 + "는 산술연산자가 아닙니다.");
		}
		
		
		scan.close();
		
		
		
	}

}
