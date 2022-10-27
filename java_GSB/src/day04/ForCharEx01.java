package day04;

import java.util.Scanner;
public class ForCharEx01 {

	public static void main(String[] args) {

		// for 문을 이용해서 종료문자인 q가 입력될 때까지 동작하는 코드 만들기 
	
	
	Scanner scan = new Scanner(System.in);
	char ch = 'a';
	
	for(; ch!='q' ; ) {
		
		ch = scan.next().charAt(0);
	} // next().charAt(0) -> 입력 버퍼의 0번째가 q; 그러니 새로 엔터를 치고 초기화 해서 q를 입력해야함.
	
	scan.close();
		
	}
	

}
