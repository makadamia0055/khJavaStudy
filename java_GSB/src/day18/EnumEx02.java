package day18;

import java.util.Scanner;

public class EnumEx02 {

	public static void main(String[] args) {
		/* 
		 * 오늘의 요일을 영어로 입력받아 한글로 출력하는 코드를 작성하세요.
		 * 
		 */
		System.out.println("요일을 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
		
		try {
		Week week = Week.valueOf(tmp);
		switch(week) { // 열거형 상수로 사용 가능
		case MONDAY : System.out.println("월요일"); break;
		case TUESDAY : System.out.println("화요일"); break;
		case WENEDSDAY : System.out.println("수요일"); break;
		case THURSDAY : System.out.println("목요일"); break;
		case FRIDAY : System.out.println("금요일"); break;
		case SATURDAY : System.out.println("토요일"); break;
		case SUNDAY : System.out.println("일요일"); break;
		}
	
		
			
		
		}catch(Exception e) {
			System.out.println("잘못 입력했습니다.");
		}
		
		scan.close();

		
		
		
	}

}
enum Week{
	MONDAY, TUESDAY, WENEDSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

