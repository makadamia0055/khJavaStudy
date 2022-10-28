package day05;

public class ArrayEx03 {
	public static void main(String[] args) {
		/* 5개짜리 배열을 생성하여 2부터 10까지 짝수를 차례대로 저장, 출력
		 * 
		 */
		
		int[] arr = new int[5];
		
		for(int i =1 ; 2*i<=10; i++) {
			arr[i-1] = i; // 배열 크기 실수 주의 
			
			System.out.print(i + " ");
		}
		
	
		
		
		
		
		
	}

}
