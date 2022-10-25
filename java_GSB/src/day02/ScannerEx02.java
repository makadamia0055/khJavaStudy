package day02;

import java.util.Scanner;

public class ScannerEx02 {
	public static void main(String[] args) {
		/* 문자열을 입력받는 방법
		 * next() : 공백(스페이스, 탭, enter)을 제외한 한 단어를 입력받음 (공백으로 구분)
		 * nextLine() : 공백(스페이스, 탭)을 포함하여 enter를 치기 전까지 한 줄을 입력받음. 
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("원하시는 문장을 입력하세요. :");
		String str1 = scan.nextLine();
		System.out.println(str1);
		
		System.out.println("한 단어를 입력하세요. : ");
		String str2 = scan.next();
		System.out.println(str2);
		
		
		
		scan.close();
		
	}

}
