package day01;

public class VariableEx01 {
	public static void main(String[] args) {
		/* 변수 선언
		 * 자료형 변수명;
		 * 자료형 변수명 = 초기값;
		 *  
		 */
		
		boolean isEven =false; 
		char operator = '+'; // 무조건 따옴표 ' '
		int age = 30;
		long longint = 39939393939L ; // int 범위를 넘어가는 숫자를 쓸때는 L을 써줘야됨. (안넘어가면 안써도 됨)
		float pi = 3.1415f;// float 은 접미사 f/F를 붙여야 한다.
		double pi2 = 3.1415; // double은 안써도 됨.
		// 기본 자료형 = 변수에 자료 값이 그대로 저장
		
		String str = "Hi"; // 무적권 쌍따옴표 ""
		// 참조형 = 변수에 자료 값의 번지 값이 저장, heap 에 객체로 자료 저장.
		
		//사과의 갯수를 저장하기 위한 변수 선언(변수 명 의미 있게 짓기)
		int appleNum ;
		// int appleNum ; 중복된 변수명 선언 불가능(타입이 달라도 불가능) 
		//학생 평균 성적
		double stdAvg;
		
		int num;
		int Num; //대소문자를 구분함. 
		
		// int int // 예약어는 변수명으로 사용 불가능
		// 특수문자는 _ $만 가능
		
		/* 관례 안지켜도 되지만 많은 개발자들이 지키는 것
		 * 1. 카멜표기법
		 * 2. 클래스와 인터페이스는 대문자로 시작
		 * 3. 상수는 전부 대문자로 , _언더바는 상수에서 관례적으로 허용
		 */
	}

}
