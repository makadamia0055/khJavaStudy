package day02;

public class PrintEx01 {
	public static void main(String[] args) {
		/*
		 * println() : 원하는 값을 출력 후 엔터
		 * 				매개변수 생략 가능(그냥 \n)
		 * print() : 원하는 값을 출력, 매개변수 생략 불가
		
		 * 문자열 + 정수 => 문자열
		 * 정수 + 문자열 => 문자열
		 * 문자 + 문자열 => 문자열
		 */
		String name = "홍길동";
		int age = 20;
		System.out.println(name+"의 나이는 "+age + " 살 입니다.");
		int num1 = 10;
		int num2 = 20;
		char operator = '+';
		//10+20
		System.out.println(""+num1+operator+num2);
		// 그냥 num1+operator+num2를 하면 (char)operator이 정수값으로 변환되어 
		// 73이 나옴. // 자료형 크기
		// 그럴때는 그냥 앞에 빈 문자열 하나 넣어주면 됨.
	}

}
