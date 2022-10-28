package day05;

import java.util.Scanner;

public class ArratEx06 {

	public static void main(String[] args) {
		/*
		 * 정수 4개짜리 배열을 생성한 후, 
		 * 4자리 숫자를 입력받아 배열에 저장하는 코드를 작성하세요
		 */
		
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		int[] arr = new int[4];
		int size = 4 ; // 선생님은 size로 자릿수를 처리
		System.out.println(size+" 자리 정수를 입력하세요");
		
		int ten =1;
		for(int i = size-1; i>=0 ; i--) {
		//for(int i = 0; i<4 ; i++){
		// arr [3-i] = temp%10; 이게 왜 안됐는지 연구하기;;	
			arr[i] = temp%10;
			temp /= 10;
			
		
			
			
			
			
			
			System.out.println(arr[i]);
			
		}
		
		//두번째 방법
		
		
		
		int id = size -1;
		while(temp !=0) {
			arr[id--] = temp%10;
			temp /= 10;
			
			
			System.out.println(arr[id]);
			
		}
		
		
		
		
		
		
		
		
	}

}
