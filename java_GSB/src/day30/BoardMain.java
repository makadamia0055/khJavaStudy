package day30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	private static ArrayList<Comment> commentList = new ArrayList<Comment>();
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
			insertBoard();
			break;
		case 2: 
			updateBoardList();
		break;
		case 3: deleteBoardList();break;
		case 4: printBoardList();break;
		case 5: printBoard(); break;
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

	/**inputBoardNum : Scanner 를 통해 번호를 입력받아 알려주는 메소드
	 *  @return 입력받은 게시글 번호
	 */
	public static int inputBoardNum() {
		int tmp = scan.nextInt();
		scan.nextLine();
		
		
		return tmp;
		
	}

	/**inputBoard : 게시글 번호가 주어지면 제목, 내용, 작성자 입력하여
	 * 				게시글 객체를 리턴하는 메소드
	 * @param num 게시글 번호
	 */
	public static Board inputBoard(int num) {
		if(num==-1) {
			
			return null;
		}
		System.out.println("게시글의 제목 입력 : ");
		String title = scan.nextLine();
		System.out.println("게시글의 내용 입력 : ");
		String contents = scan.nextLine();
		System.out.println("게시글의 작성자 입력 : ");
		String writer = scan.next();
		
		Board board = new Board(num, title, contents, writer);
		return board;
		
	}
	
	/**updateBoard 게시글 리스트에 주어진 게시글을 수정하는 메소드로 수정하면 true를, 실패하면 false를 반환
	 * @param boardList 게시글 리스트
	 * @param board 수정할 게시글
	 * @return 수정 성공 true, 실패 false
	 */
	public static boolean updateBoard(ArrayList<Board> boardList, Board board) {
		if(boardList==null||boardList.size()==0) {
			return false;
		}
		if(board==null) {
			return false;
		}
		int index = boardList.indexOf(board);
		if(index == -1)
			return false;
		boardList.set(index, board);
		return true; // indexOf는 객체를 equals로 따져서 같음을 판별하는듯.
	}
	/**updateBoardList : 게시글 정보를 입력받아 수정하는 메소드
	 * 
	 */
	public static void updateBoardList() {
		System.out.println("수정할 게시글 번호를 입력해주십시오.");
		int tmp = inputBoardNum();
		Board tmpBoard = inputBoard(tmp);
		if(updateBoard(boardList, tmpBoard)){
		System.out.println("게시글 수정이 완료되었습니다.");
		}else {
		 System.out.println("게시글 수정하지 못했습니다.");
		}
		
	}

	/**deleteBoard : 게시글 리스트에 주어진 게시글을 수정하는 메소드
	 * @param boardList 게시글 리스트
	 * @Param num 삭제할 게시글 번호
	 * @return 삭제 성공 true, 실패 false
	 * 
	 */
	public static boolean deleteBoard(ArrayList<Board> boardList, int num) {
		if(boardList==null||boardList.size()==0) {
			return false;
		}
		int index = boardList.indexOf(new Board(num));
		if(index==-1){
			return false;
		}else {
			boardList.remove(index);
			return true;
		}
		
		
	}
	/**deleteBoardList : 게시글 번호를 입력받아 삭제하는 메소드
	 * 
	 */
	public static void deleteBoardList() {
		int tmp =inputBoardNum();
		if(deleteBoard(boardList, tmp)) {
			System.out.println("게시글 삭제가 완료되었습니다.");
		}else {
			System.out.println("게시글 삭제에 실패하였습니다.");
		}
	}
	public static void printBoardList() {
		if(boardList.size()==0) {
			System.out.println("아직 작성된 글이 없습니다.");
		}else {
			boardList.forEach(b->System.out.println(b));
		}
	}
	
	/**printSubMenu : 게시글 확인에서 필요한 서브 메뉴를 출력
	 * 
	 */
	public static void printSubMenu(){
		System.out.println("게시글 확인 세부 메뉴");
		System.out.println("1. 댓글 등록");
		System.out.println("2. 댓글 확인");
		System.out.println("3. 이전");
	}
	
	/**runPrintSubMenu : 선택한 서브 메뉴를 실행하는 메소드
	 * 					우선 서브메뉴를 선택하면 선택한 서브메뉴를 
	 * 					콘솔에 출력하는 기능으로 일단 구현
	 * @param subMenu 선택한 서브메뉴
	 * 
	 */
	
	public static void runPrintSubMenu(int subMenu, int boardNum) {
		
		switch(subMenu) {
		case 1:
			insertCommentList(boardNum);
			break;
		case 2:
			printCommentList(boardNum);
			break;
		case 3:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default: System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	
	
	
	
	/**printBoard : 게시글 번호를 입력받아 입력받은 게시글 출력하고 
	 * 				서브 메뉴를 출력하고, 서브메뉴를 선택하면, 선택한 서브메뉴를 실행하는 메소드
	 * 
	 */
	public static void printBoard() {
		System.out.println("열람할 게시글 번호를 입력해주십시오.");
		int num = inputBoardNum();
		Board board = new Board(num);
		int index = boardList.indexOf(board);
		if(index==-1) {
			System.out.println("등록되지 않았거나 삭제된 게시글입니다.");
			return;
		}
		board = boardList.get(index);
		board.print();
		int subMenu = -1;
		do {
			printSubMenu(); 
			subMenu = inputBoardNum();
			runPrintSubMenu(subMenu, num);
		}while(subMenu !=3);
		
	}
	
	/** insertComment : 댓글을 댓글 리스트에 추가하는 메소드
	 * @param commentList 댓글 리스트
	 * @param comment 댓글
	 * @return 댓글 추가 여부
	 */
	public static boolean insertComment(ArrayList<Comment> commentList, Comment comment) {
		
		if(comment==null) {
			return false;
		}else {
			int index = commentList.indexOf(comment);
			if(index ==-1) {
				commentList.add(comment);
				return true;
			}
			return false;
		}
	}
	/**insertCommentList : 댓글 정보를 입력받아 댓글을 추가하는 메소드
	 * @param 선택한 게시글 번호
	 * @return 
	 */
	public static void insertCommentList(int boardNum) {
		System.out.println("게시글 번호 입력 : ");
		int num  = scan.nextInt();
		scan.nextLine();
		
		System.out.println("댓글 작성자 입력: ");
		String writer = scan.next();
		scan.nextLine();
		System.out.println("댓글 내용 입력: ");
		String contents = scan.nextLine();
		
		Comment tmp = new Comment(num, writer, contents, boardNum);
		if(insertComment(commentList, tmp)) {
			System.out.println("댓글 등록이 완료됐습니다.");
		}else {
			System.out.println("이미 등록된 댓글 번호입니다.");
		}
		
	}
	/**printCommentList : 선택한 게시글에 있는 댓글들을 확인하는 메소드
	 * @param boardNum 게시글 번호
	 * 
	 */
	public static void printCommentList(int boardNum) {
		List printList=commentList.stream().filter(p->p.getBoardNum()==boardNum).collect(Collectors.toList());
		printList.forEach(b->System.out.println(b));
	}	

}