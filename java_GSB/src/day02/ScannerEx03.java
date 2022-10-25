package day02;

import java.util.Scanner;

public class ScannerEx03 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

	
	System.out.println("한 단어를 입력하세요. : ");
	String str2 = scan.next();
	System.out.println(str2);
	

	System.out.println("원하시는 문장을 입력하세요. :");
	String str1 = scan.nextLine();
	System.out.println(str1);
	
	// 이 예제는 실행할 경우 두번째 문장 입력 객체가 제대로 실행되지 않음.
	// 제멋대로 출력됨.
	// -> 입력 버퍼에 찌꺼기가 남아서 
	// 버퍼: "안녕하세요 제 이름은 홍길동 입니다."
	// scan.next();이 안녕하세요 가져감
	// 버퍼: "( 공백) 제 이름은 홍길동 입니다."
	// scan.nextLine();이 나머지 버퍼(" 제 이름은 ...) 출력
	// 제대로 작동하게 하기 위해서는 빈 scan.nextLine(); 으로 버퍼 초기화 필요
	
	System.out.println("한 단어를 입력하세요. : ");
	str2 = scan.next();
	System.out.println(str2);

	scan.nextLine(); // 버퍼 초기화
	

	System.out.println("원하시는 문장을 입력하세요. :");
	str1 = scan.nextLine();
	System.out.println(str1);
	
	
	
	
	
	scan.close();
}
}