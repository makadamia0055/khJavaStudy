package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPhoneNumber01 {
public static void main(String[] args) {
			/* 전화번호 정규 표현식을 작성하여 입력받은 번호가 전화번호가 맞는지 출력하는 코드를 작성
			 * 규칙 1.
			 * 010-1234-5678 [O]
			 * 01012345678[X]
			 * 
			 *  */
			
			Scanner scan = new Scanner(System.in);
			System.out.println("휴대전화 번호를 입력하십시오.");
			String tmpEmail = scan.nextLine();
			String regex01 = "^010-[\\d]{4}-[\\d]{4}$"; 
			String regex02 = "010(-\\d{4}){2}";
				
			
			if(Pattern.matches(regex01, tmpEmail)) {
				System.out.println(tmpEmail+"은 휴대전화 번호 형식입니다.");
			} else {
				System.out.println(tmpEmail+"은 휴대전화 번호 형식이 아닙니다.");
				
			}
			scan.close();

		}

	}
