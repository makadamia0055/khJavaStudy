package day05;

public class DoWhileEx01 {

	public static void main(String[] args) {
		/* for문, while문은 상황에 따라서 한번도 동작하지 않을 수 있다.
		 * 
		 * 
		 * 하지만 do while문은 최소 한번은 실행함. 일단 한번 하고 조건 따짐.
		 
		 *
		 * 선생님 사용법
		 * 
		 * for : 순차적으로 증가/감소하는 경우
		 * 
		 * 
		 * while : 특정 값을 입력받아 활용하는 경우, 값이 순차적이지 않은 경우
		 * 단순 횟수만 사용되는 경우
		 *
		 *
		 *
		 */
		
		for(int i = 1; i>= 5; i++) { // 조건식 오류로 동작 안함 
			System.out.println("helloworld");
		}
		
		
		int j = 1;
		
		do { 
			System.out.println("Hello World!");
			
		} while(j>=5);  // 세미콜론 필수
		
		
		
		

	}

}
