package day05;

public class WhileSumEx01 {

	public static void main(String[] args) {
			/* 1부터 10 사이의 홀수의 합을 구하는 코드를 while문으로 작성하세요.
			 * 
			 */
		int min = 0;
		int max = 10;
		int i = min;
		int sum = 0;
		
		while(++i<=max) { // 증감식을 조건식 속으로 포함 가능 
			if(i%2==1) {
				sum +=i;
			}
			
		}
		System.out.println("1부터 10까지 홀수의 합은 "+ sum+"입니다.");
	}

}
