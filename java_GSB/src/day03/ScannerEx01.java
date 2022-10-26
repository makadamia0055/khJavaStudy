package day03;


import java.util.Scanner;
public class ScannerEx01 {

	public static void main(String[] args) {
		// 문자를 입력받아 char에 저장하는 예제
		
		Scanner scan = new Scanner(System.in);
		char ch;
		System.out.print("문자를 입력하세요");
		ch = scan.next().charAt(0);
		// 자바의 Scanner 는 char 타입을 입력받지 못한다. 
		//String 타입을 받는 메서드는 2개나 있지만...
		// 그래서 String 에서 char를 파싱하는 메서드 charAt를 사용하여 읽어옴
		// .charAt(index);
		System.out.println("입력받은 문자는 " + ch + "입니다.");
		
		
		scan.close();

		
		
		
		
	}

}
