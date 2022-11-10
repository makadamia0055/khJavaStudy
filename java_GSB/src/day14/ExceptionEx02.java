package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx02 {

	public static void main(String[] args) throws InputMismatchException {
		/* Scanner를 통해 정수를 입력받아 입력받은 정수를 출력하는 코드를 작성하세요.
		 * 정수 대신 문자열을 입력하면 예외가 발생하는데, 이 예외를 처리하는 코드를 작성하시오.
		 * */

		Scanner scan =new Scanner(System.in);
		do {
			System.out.print("정수 입력 : ");
			try {
			int tmp = scan.nextInt(); // 이 경우 int num 은 try문에서만 기능
			System.out.println("입력된 정수 : " + tmp);
			break;
			}catch(InputMismatchException e) { 
				//잘 모르겠으면 Exception 모든 예외클래스의 조상
			System.out.println("잘못된 입력 방식입니다. \n 정수를 입력해주세요.");
			}
		
		}while(true);
		
	}

}
 