package day27;

import java.util.Scanner;


public class BoardMain {
	private static Scanner scan = new Scanner(System.in);
	
	/* 게시글 관리 프로그램
	 * -회원 가입
	 * -로그인
	 * -게시글 등록/수정/삭제 -> 회원만 가능
	 * - 카테고리 관리
	 * */
	public static void main(String[] args) {
		ClientManager cM = new ClientManager();
		PostManager pM = new PostManager();
		Viewer user = new Viewer();
		//user = new Client("mak123", "mak123");
		int menu = -1;
		do {
			printMenu(user);
			menu = scan.nextInt();
			user = runMenu(menu, cM, pM, user);
		}while(menu!=3);

	}

	private static Viewer runMenu(int menu, ClientManager cM, PostManager pM, Viewer user) {
		switch(menu) {
		case 1:
			break;
		case 2:
			user = subMenu2(cM, user);
			
			break;
		case 3:
			break;
			default:
		}
		return user;
	}

	private static Viewer subMenu2(ClientManager cM, Viewer user) {
		if(!Viewer.verifiedClient(cM)) {
			System.out.println("로그인 및 회원 가입");
			System.out.println("1. 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("3. 뒤로 가기");
			int submenu = scan.nextInt();
			switch(submenu) {
			case 1: 
				user = cM.login();
				if(user == null) {
					user = new Viewer();
				}
				return user;
			case 2: 
				user = cM.join();
				if(user == null) {
					user = new Viewer();
				}
				return user;
			case 3: return user;
			default: System.out.println("잘못된 메뉴입니다.");
			return user;
			}
		}else {
			System.out.println("로그아웃 합니다.");
			user = new Viewer();
		}
		return user;
	}

	private static void printMenu(Viewer user) {
		System.out.println("1. 게시판 접속\t\t"+(Viewer.verifiedClient(user)?"회원":"비회원"));
		if(!Viewer.verifiedClient(user)) {
			System.out.println("2. 로그인 및 회원 가입");
		}else {
			System.out.println("2. 로그아웃");
		}
		System.out.println("3. 종료");
		
	}

}
