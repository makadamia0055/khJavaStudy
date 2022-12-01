package day30;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {
	/*	기능
	 * 	- 게시글 등록
	 * 	- 게시글 수정
	 * 	- 게시글 삭제
	 * 	- 게시글 목록
	 * 	- 게시글 확인
	 * 		- 댓글 등록
	 * 		- 댓글 확인
	 * 		- 이전 메뉴
	 * 	-프로그램 종료
	 */
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Board> boardList = new ArrayList<Board>();
	public static void main(String[] args) {
		
		int menu = -1;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		}while(menu !=6);
		
		
		
		
	}
	
	
	
	/**	메뉴를 출력하는 메소드
	 * 
	 */
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록");
		System.out.println("5. 게시글 확인");
		System.out.println("6. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}
	/** runMenu
	 * 메뉴가 주어지면 주어진 메뉴에 맞는 기능을 출력하는 메소드
	 *  @param menu 선택된 메뉴로 정수 
	 */
	public static void runMenu(int menu) {
		switch(menu) {
		case 1: 
			System.out.println("게시글 등록 기능입니다.");
			insertBoard();
			break;
		case 2: System.out.println("게시글 수정 기능입니다.");break;
		case 3: System.out.println("게시글 삭제 기능입니다.");break;
		case 4: System.out.println("게시글 목록 기능입니다.");break;
		case 5: System.out.println("게시글 확인 기능입니다.");break;
		case 6: System.out.println("프로그램을 종료합니다.");break;
		default: System.out.println("잘못 선택했습니다.");
		
		}
	}
	/**insertBoard
	 * 게시글 정보를 입력받아 게시글을 출력하는 메소드
	 * 메소드 구현에 필요한 필드를 추가해도 됨
	 */
	public static void insertBoard() {
		System.out.println("게시글의 번호 입력 : ");
		int num = -1;
		do{ 
			num= scan.nextInt();
			scan.nextLine();
			if(boardList.contains(new Board(num))) {
			System.out.println("이미 작성된 번호의 글입니다.\n다른 번호를 입력해주십시오.");
			}
			
		}while(boardList.contains(new Board(num)));
		System.out.println("게시글의 제목 입력 : ");
		String title = scan.nextLine();
		System.out.println("게시글의 내용 입력 : ");
		String contents = scan.nextLine();
		System.out.println("게시글의 작성자 입력 : ");
		String writer = scan.next();
		
		Board board = new Board(num, title, contents, writer);
		boardList.add(board);
		System.out.println("글이 정상적으로 등록되었습니다.");
		System.out.println(boardList);
	}
}
