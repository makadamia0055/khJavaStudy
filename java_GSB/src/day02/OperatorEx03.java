package day02;

public class OperatorEx03 {
	public static void main(String[] args) {
		/* 산술 연산자 : + - * / %
		 * 정수 산술연산자 정수 => 정수
		 * 실수 산술연산자 정수 => 실수
		 * 정수 산술연산자 실수 => 실수
		 * 실수 산술연산자 실수 => 실수
		 */
		
		int num1 = 1, num2 = 2;
		System.out.println(num1+ "+" +num2 + " = " + (num1+num2));
		//더하기 빼기는 문자열의 더하기 빼기랑 순서가 같아서 괄호가 없으면 문자열로 인식해버림.
		System.out.println(num1+ "-" +num2 + " = " + (num1-num2));
		System.out.println(num1+ "*" +num2 + " = " + (num1*num2));
		System.out.println(num1+ "/" +num2 + " = " + ((double)num1/num2));
		System.out.println(num1+ "%" +num2 + " = " + (num1%num2));


		
		
	}

}
