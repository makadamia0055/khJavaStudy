package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx01 {

	public static void main(String[] args) {
		/* 이메일 주소를 입력받아 이메일 형식이 맞는지 확인하는 코드를 작성하세요
		 * 단 정규 표현식을 이용
		 * makend91@naver.com
		 * makend91@xxx.or.kr
		 *  */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("이메일을 입력하십시오.");
		String tmpEmail = scan.nextLine();
		String regex01 = "^[a-z0-9\\-_]{5,20}@[\\w]*\\.[\\w]*[..]?[\\w]*$";
		String regex02 = "^[a-zA-Z0-9\\-_]+@[a-zA-Z0-9\\-]{2,}(\\.[a-zA-Z]+){1,2}$";
			
		
		if(Pattern.matches(regex01, tmpEmail)) {
			System.out.println(tmpEmail+"은 이메일 형식입니다.");
		} else {
			System.out.println(tmpEmail+"은 이메일 형식이 아닙니다.");
			
		}
	}

}
