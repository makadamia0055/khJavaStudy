package day18;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEx02 {

	public static void main(String[] args) {
		String idReg = "^[a-z0-9\\-_]{5,20}$";
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디 입력: ");
		String id = scan.next();
		if(Pattern.matches(idReg, id)){
				System.out.println("올바른 아이디입니다.");
		}else {
			System.out.println("아이디는 5~20자의 영문 소문자, 숫자와 특수기호 _, -만 사용 가능함");
		}
		scan.close();

		
	}

}
