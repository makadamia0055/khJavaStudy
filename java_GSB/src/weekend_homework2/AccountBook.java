package weekend_homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountBook {
	ArrayList<Item> list = new ArrayList<Item>();
	AccountService accountService = new AccountServiceImp();
	// 인터페이스는 객체를 생성할 수 없지만 인터페이스의 구현 객체를 참조할 수 있다.
	Scanner scan;
	
	public void run() {
		System.out.println("가계부 프로그램 실행합니다.");
		int menu = -1;
		do {
			accountService.printMenu();
			menu = scan.nextInt();
			
			accountService.runMenu(list, menu, scan);
		
			
		}while(menu!=5);
		System.out.println("가계부 프로그램 종료합니다.");
		
	}
	public AccountBook(Scanner scan) {
		if(scan==null) {
			this.scan = new Scanner(System.in);
		}
		this.scan = scan;
	}
	
	
}
