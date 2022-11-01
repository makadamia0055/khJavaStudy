package day07;

public class MethodEx01 {

	public static void main(String[] args) {
		/*
		 * 클래스
		 * 	-멤버변수
		 * 		=> 속성
		 * 	-생성자
		 * 		=> 객체 생성, 초기화
		 * 	-멤버 메소드
		 * 		=> 기능
		 * 
		 * 생성자 : 멤버 변수들의 값들을 초기화 
		 * 
		 * public(일반적으로public) 클래스명=생성자(자료형 변수명, 자료형 변수명.){
		 * 		멤버변수 초기화;
		 * }
		 * 
		 * 	public 생성자(){} // 기본 생성자 => 없어도 컴파일러가 생성해줌. 
		 * 
		 * 복사 생성자
		 * public 생성자(클래스명 객체명){
		 * 			초기화;
		 * }
		 * 
		 * 
		 * ------------------
		 * 메소드 : 기능
		 * 
		 * 접근제어자 예약어(static, final..) 리턴타입 메소드명(매개변수들){
		 * 		구현;
		 * }
		 * Ex) 음료수 자판기(콜라 사이다 환타)
		 * 	메소드 : 자판기
		 * 	리턴타입: 음료수라는 데이터 형
		 * 			기능이 끝나고 돌려주는 자료형.
		 * 	매개변수: 구현할 때 사용할 변수명, 기능이 실행되기 위해서 필요한 정보들
		 * 			돈, 메뉴(필수적인 정보들)
		 * 
		 * 
		 * 
		 * 
		 * 메소드 호출
		 * 메소드명(매개변수 값);ㅣ
		 * 
		 */
		int temp = sumEx1(10, 20);
		System.out.println(temp);
		sumEx2(12, 26);
		int num1 = 1, num2 =3;
		sumEx2(num1, num2);
		
		MethodEx02 me2 = new MethodEx02();
		me2.guguDan(7);
		
	}
	/* 메소드 만드는 순서
	 * 기능 정리
	 * 매개변수는 무엇이 필요한가
	 * 리턴타입
	 * 메소드 이름 짓기
	 * */
	//ex1: 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	//ex2: 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	
	
	public static int sumEx1(int num1, int num2) {
		return num1+num2;
		
	}
	
	public static void sumEx2(int num1, int num2) {
		System.out.println(num1+num2);
		return ;
	} //지금 이 코드에서는 return이 필요없지만, 
		//void에서 return을 사용할 수 있다는 것 보여주기 위해 추가함.
	// 원래 모든 메소드에 리턴 있는데 없는건 생략된걸로 아는데
	
	
}
