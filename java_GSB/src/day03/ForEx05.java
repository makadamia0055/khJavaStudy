package day03;

public class ForEx05 {

	public static void main(String[] args) {
		/*1부터 10까지의 합을 구하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 10가지 1씩 증가
		 */
		
		int sum = 0;// for 문 초기식 안에서 sum도 같이 초기화가 가능함
		// for(int i = 1, sum =0;... 이런 식으로)
		for(int i = 1 ; i <=10 ; i++ ) {
			sum = sum +i; // sum +=i;
			
		}
		
		System.out.println("1부터 10까지의 총합 : " + sum);
		
		
	}

}
