package day04;

public class ForSumEx01 {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수 합 구하는 코드 작성
		 * 
		 */
		int i;
		int sum;
		for(i = 2, sum = 0; i <=10 ; i+=2) {
			sum+=i;
		}
		System.out.println(sum);
		
		for(i= 1, sum = 0; 2*i<= 10; i++) {
			sum+=2*i;
		}
		System.out.println(sum);
		
		for(i = 1, sum = 0; i<= 10; i++) {
			if(i%2==0) {
				sum+=i;
			}
		}

		System.out.println(sum);

		
		
	}

}
