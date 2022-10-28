package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/* 학생들 5명의 국어 성적을 입력받고 출력하는 코드를 작성하세요.
		 * 반복 횟수 : i는 0부터 배열의 크기보다 작을때까지 1씩 증가
		 * 규칙성 : 콘솔에서 입력받은 정수를 배열 i번지 저장 후 배열 i 번지에 있는 값을 출력 
		 */
		
		int[] arr = new int[5];
		Scanner scan = new Scanner(System.in);
		for(int i= 0; i<5; i++) {
			System.out.print((i+1)+"번 학생의 성적을 입력해 주십시오 :");
			int temp = scan.nextInt();
			arr[i]=temp;			
		}
		
		for(int i = 0; i< 5; i++) {
			System.out.printf("%d번 학생의 성적 : %d \n", (i+1), arr[i]);
		}
		/*
		 * 학생 성적의 평균을 구하는 코드를 작성하세요
		 
		
		for(int i = 0; i<5;i++) {
			sum+=arr[i];
		}
		*/
		int sum = 0;
		
		for(int i :arr) {
			sum += i; // 배열 인덱스형으로 적지 않게 주의
				
		}
		
		System.out.printf("학생들 성적 평균 : %.2f 점", (float)sum/arr.length);
		
		
		scan.close();
		
		
	}

}
