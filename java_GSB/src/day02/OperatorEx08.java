package day02;


import java.util.Scanner;

public class OperatorEx08 {
	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 홀수인지 짝수인지 출력하는 코드를 작성
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 :");
		int temp ;
		temp = scan.nextInt();
		//int even = (temp%2);
		boolean isEven = ((temp%2)==0);
		System.out.println("입력된 정수 "+ temp+"은/는 "+ (isEven?"짝수":"홀수")+"입니다.");
				scan.close();
		
		
	}

}
