package day25;

public class RecurcionFunctionEx01 {
		/* 재귀함수 : 함수의 실행문으로 자기 자신을 다시 호출하는 함수
		 *  - 잘못 작성하면 스택 오버 플로우가 발생할 수 있음.
		 * */

	public static void main(String[] args) {
		//print(10); // 스택오버플로우 발생
		
		/* 
		 * 팩토리얼 n! 구현하기
		 * n! = 1*2*....*n 
		 */
		System.out.println(factorial(5));
	}
	
	
	public static void print(int num) {
		System.out.println(num);
		print(num); // 재귀
			// 이거 메인에서 호출하면 스택 오버플로우남
	}
	public static int factorial(int num) {
		if(num<0) {
			throw new RuntimeException("음수는 팩토리얼을 구할 수 없습니다.");
		}
		if(num==1||num==0) { // 재귀함수는 탈출조건을 줌.
			return 1;
		}
		return num* factorial(num -1);
	}
}
