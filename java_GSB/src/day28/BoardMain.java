package day28;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class BoardMain {
	private static Scanner scan = new Scanner(System.in);
	private static Viewer cUser = new Viewer();
	private static ClientManager cM = new ClientManager();
	private static PostManager pM = new PostManager();
	/* 게시글 관리 프로그램
	 * -회원 가입
	 * -로그인
	 * -게시글 등록/수정/삭제 -> 회원만 가능
	 * - 게시글 목록
	 * 	-게시글 검색(검색 번호는 게시글 번호로)
	 * 	-게시글 확인
	 * 
	 * - 카테고리 관리(관리자만)
	 * 	-카테고리 추가
	 * 	-카테고리 수정
	 * 	-카테고리 삭제
	 * 
	 * */
	public static void main(String[] args) {
		
		loadPost("postM01.txt");
		loadMember("clientM01.txt");
		//cUser = new Client("mak123", "mak123");
		int menu = -1;
		do {
			try {
			printMenu();
			menu = scan.nextInt();
			printBar();
			runMenu(menu, cM, pM);
			}catch(Exception e) {
				printStr(e.getMessage());
			}
		}while(menu!=4);

	}

	private static void runMenu(int menu, ClientManager cM, PostManager pM) {
		switch(menu) {
		case 1:
			subMenu1(pM);
			break;
		case 2:
			subMenu2(cM);
			
			break;
			
		case 3: 
			if(Viewer.verifiedMaster(cUser)) {
				subMenu3(pM);
			}else {
				System.out.println("관리자만 접근할 수 있는 메뉴입니다.");
			}
			break;
			
		case 4:
			System.out.println("프로그램을 종료합니다.");
			
			savePost("postM01.txt");
			saveMember("clientM01.txt");
			
			break;
			default:
		}
		
	}

	private static void subMenu3(PostManager pM) {
		int subMenu3 = -1; 
		do {
		System.out.println("1. 카테고리 추가");
		System.out.println("2. 카테고리 수정");
		System.out.println("3. 카테고리 삭제");
		System.out.println("4. 카테고리 확인");
		System.out.println("5. 뒤로 가기");
		
		System.out.print("메뉴 선택 : ");
		subMenu3 = scan.nextInt();
		String category;
		switch(subMenu3) {
		case 1:
			System.out.println("새 카테고리 명을 입력하십시오.");
			category = scan.next();
			if(pM.getSort().contains(category)) {
				System.out.println("해당 카테고리가 이미 존재합니다");
				break;
			}
			pM.getSort().add(category);
			System.out.println("새 카테고리 "+ category+"가 추가되었습니다.");
			
			break;
		case 2:
			System.out.println("수정할 카테고리 명을 입력하십시오.");
			String editCategory = scan.next();
			if(!pM.getSort().contains(editCategory)) {
				System.out.println("해당 카테고리가 없습니다.");
				break;
			}
			System.out.println("새로운 카테고리 명을 입력하십시오.");
			category = scan.next();
			if(pM.getSort().contains(category)) {
				System.out.println("해당 카테고리가 이미 존재합니다");
				break;
			}
			pM.getSort().set(pM.getSort().indexOf(editCategory), category);
			System.out.println("수정이 성공적으로 진행되었습니다.");
			break;
		case 3:
			System.out.println("수정할 카테고리 명을 입력하십시오.");
			String deleteCategory = scan.next();
			if(!pM.getSort().contains(deleteCategory)) {
				System.out.println("해당 카테고리가 없습니다.");
				break;
			}
			
			//if에 .remove(category) 로 삭제를 조건으로 걸어도 됨.
			// 근데 나는 밑에 되물어보기를 위해서 그냥 안했음.
			System.out.println("정말로 삭제하시겠습니까?");
			char yn = 'a';
			do {
				yn= scan.next().toUpperCase().charAt(0);
				if(yn=='Y') {
					pM.getSort().remove(deleteCategory);
					System.out.println("해당 카테고리가 삭제가 되었습니다.");
					break;
				}else if(yn=='n') {
					System.out.println("삭제를 취소하고 돌아갑니다.");
					break;
				}
			
			}while(yn!='Y'&&yn!='N');
			
		case 4:
			System.out.println("현재 존재하는 카테고리 명은 ");
			for(String tmp : pM.getSort()) {
				System.out.print(tmp+ " ");
			}
			System.out.println("총 " + pM.getSort().size()+"개 있습니다.");
			break;
		case 5:
			break;
			default: System.out.println("잘못된 메뉴입니다.");
		}
		}while(subMenu3!=5);
	}

	private static void subMenu1(PostManager pM) {
		int subMenu1  = -1;
		do {
			pM.printPostTitle();
			printBar();
			printSubMenu1();
			subMenu1 = scan.nextInt();
		
			switch(subMenu1) {
			case 1:
				if(pM.getSize()==0) {
					System.out.println("아직 등록된 글이 없습니다.");
					break;
				}
				System.out.println("열람하고 싶은 글의 번호를 입력하십시오.");
				int wntRead = scan.nextInt();
				pM.print(wntRead);
				
				break;
			case 2: 
				if(!Viewer.verifiedClient(cUser)) {
					System.out.println("비회원은 글의 작성 및 수정, 삭제가 불가능합니다.");
					break;
				}
				pM.addPost((Client) cUser);
				break;
			case 3:
				if(!Viewer.verifiedClient(cUser)) {
					System.out.println("비회원은 글의 작성 및 수정, 삭제가 불가능합니다.");
					break;
				}
				pM.editPost((Client)cUser);
			break;
			case 4:
				if(!Viewer.verifiedClient(cUser)) {
					System.out.println("비회원은 글의 작성 및 수정, 삭제가 불가능합니다.");
					break;
				}
				pM.deletePost((Client)cUser);
				break;
			case 5:
				System.out.println("전 메뉴로 돌아갑니다.");
				break;
				default: System.out.println("잘못된 메뉴입니다.");
				}
			}while(subMenu1!=5);
	}

	private static void printSubMenu1() {
		System.out.println("1. 글 상세 열람");
		if(Viewer.verifiedClient(cUser)) {
			System.out.println("2. 글 쓰기");
			System.out.println("3. 글 수정");
			System.out.println("4. 글 삭제");
		}
		System.out.println("5. 돌아가기");
	}

	private static void subMenu2(ClientManager cM) {
		if(!Viewer.verifiedClient(cUser)) {
			System.out.println("로그인 및 회원 가입");
			System.out.println("1. 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("3. 뒤로 가기");
			int submenu = scan.nextInt();
			Viewer user;
			switch(submenu) {
			case 1: 
				user = cM.login();
				if(user == null) {
					user = new Viewer();
				}
				cUser = user;
				break;
			case 2: 
				user = cM.join();
				if(user == null) {
				user = new Viewer();
				}
				cUser = user;
				break;
			case 3: break;
			default: System.out.println("잘못된 메뉴입니다.");
			}
		}else {
			System.out.println("로그아웃 합니다.");
			cUser = new Viewer();
		}
	}

	private static void printMenu() {
		System.out.println("1. 게시판 접속\t\t"+(Viewer.verifiedMaster(cUser)?"관리자":Viewer.verifiedClient(cUser)?"회원":"비회원"));
		if(!Viewer.verifiedClient(cUser)) {
			System.out.println("2. 로그인 및 회원 가입");
		}else {
			System.out.println("2. 로그아웃");
		}
		if(Viewer.verifiedMaster(cUser)) {
			System.out.println("3. 카테고리 수정");
				
			}
		System.out.println("4. 종료");
		
	}
	private static void printStr(String str) {
		System.out.println(str);
		System.out.println("===================");
		
	}
	private static void printBar() {
		System.out.println("===================");
	}
	private static void saveMember(String filename) {
		try(ObjectOutputStream oos
				= new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(cM);
			printStr("저장 완료");
		}catch(IOException e) {
			printStr("저장 실패");
		}
	}
	private static void loadMember(String filename) {
		try(ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(filename))){
			ClientManager tmpCM=(ClientManager) ois.readObject(); 
			BoardMain.cM = tmpCM;
			printStr("읽기 완료");
		}catch(IOException | ClassNotFoundException e) {
			printStr("읽기 실패");
		}
	}
	private static void savePost(String filename) {
		try(ObjectOutputStream oos
				= new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(pM);
			printStr("저장 완료");
		}catch(IOException e) {
			printStr("저장 실패");
		}
	}
	private static void loadPost(String filename) {
		try(ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(filename))){
			PostManager tmpPM=(PostManager) ois.readObject(); 
			BoardMain.pM = tmpPM;
			printStr("읽기 완료");
		}catch(IOException | ClassNotFoundException e) {
			printStr("읽기 실패");
		}
	}
	
}
