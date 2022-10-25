package day02;

import java.util.Scanner;


public class ScaannerEx01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//정수  sc.nextInt();
		//실수 sc.nextFloat();, sc.nextDouble();
		//
		/*System.out.println("정수를 입력하세요. :");
		int num = scan.nextInt();
		System.out.println(num);
		System.out.println("실수를 입력하세요. : ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		//하나의 작업을 할때는 하나의 스캐너만 만들어 작업해야함.
		// 여러개 만들면 예외가 발생
		*/
		int num1, num2;
		System.out.println("정수 a와 정수 b를 입력하세요 :");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		System.out.println(num1);
		System.out.println(num2);
		
		//문자와 문자열
		
		
		
		
		
		scan.close();
	}

}
