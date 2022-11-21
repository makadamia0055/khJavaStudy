package interfacePractice01;

import java.util.InputMismatchException;
import java.util.Scanner;


public class SampleInplementsClass implements SampleInterface {

	

	@Override
	public int selectMenu(int min, int max) {
		Scanner scan = new Scanner(System.in);
		int tmp = 0;
		try {
		do {
		 tmp = scan.nextInt();
		 if(tmp>=min&&tmp<=max) {
			 return tmp;
		 }
		}while(true);
		}catch(InputMismatchException e) {
			scan.close();
			System.out.println("입력 오류가 발생했습니다.\n숫자를 입력해주세요.");
		}catch(Exception e){
			scan.close();
			System.out.println("오류가 발생했습니다.");
			e.printStackTrace();
		}
		scan.close();

		return tmp;
	}

	@Override
	public void printMenu(String str) {
			System.out.println("메뉴");
			System.out.println(str);
			System.out.print("메뉴선택 : ");

		}
}


