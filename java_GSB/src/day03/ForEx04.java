package day03;

public class ForEx04 {

	public static void main(String[] args) {
		/* 1부터 10 사이의 짝수를 출력하는 코드
		 * 
		 * 
		 * 
		 */
		
		for(int i =1 ; 2*i<=10; i++) {
			System.out.print(i*2 + " ");
		}
		
		for(int i =1 ; i <=10 ; i++) {
			if(i%2==0) {
				System.out.print(i+ " ");
			}
		}
		for(int i = 2; i<=10; i+=2){
			System.out.print(i+ " ");
		}
		
		
	}

}
