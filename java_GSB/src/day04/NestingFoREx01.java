package day04;

public class NestingFoREx01 {

	public static void main(String[] args) {
		/* 구구단 3단을 출력하는 코드를 작성하세요.
		 * 
		 */
		
		int num ;
		for(num = 2; num < 10 ; num ++) {
		for(int i  =1; i<10; i++) {
			System.out.printf("%d X %d = %d\n", num, i, i*3);
		}
		
		/*String[] tenkor = {"일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
		
		for(int i = 1; i<10; i++) {
			System.out.printf("%s %s 은/는 %d\n", tenkor[2], tenkor[i-1], i*3);
		}*/
		
		}
	}

}
