package day07;

public class MethodEx02 {

	public static void main(String[] args) {
			//구구단 7단을 출력하는 코드를 작성하세요. 단 메소드를 이용할 것
	/*
	 * 3가지 방법이 나왔음
	 * 1. 단이 주어지면 해당 단을 콘솔에 출력하는 메소드
	 * 매개변수 =단
	 * 리턴타입 없음 void
	 * 메소드명 printTimesTable01
	 * 2. 단과 시작정수, 끝정수가 주어지면 해당하는 단을 X 시작정수부터 끝 정수까지 출력
	 * 매개변수 = 단, 시작정수, 끝정수
	 * 리턴타입 없음 void
	 * 메소드명 printTimesTable02
	 * 3. 두 정수를 주었을때 두 수의 곱을 리턴하는 메소드
	 * 매개변수 = 두 정수
	 * 리턴타입 = int
	 * 메소드명 printTimesTable03 
	 * 
	}*/
	
	MethodEx02 me02 = new MethodEx02();	
	me02.guguDan(7);
	
	guguDan02(3, 1, 9);
	
	
	}
	
	public void guguDan(int dan) {
	
		for(int i = 1; i < 10 ; i++) {
			System.out.printf("%d X %d = %d\n", dan, i, dan*i);
		}
		return ; 
	}
	
	public static void guguDan02(int dan, int start, int end) {
	for(int i = start; i <= end ; i++) {
		System.out.printf("%d X %d = %d\n", dan, i, dan*i);
	}
	}
	
	
}
	
	

