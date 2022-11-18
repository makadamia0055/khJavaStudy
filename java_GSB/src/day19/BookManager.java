package day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;

public class BookManager {
	public static Scanner scan =new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 * 도서관리 프로그램을 작성하세요.
		 * 도서 정보 : 도서명, 저자(여러명, 엮은이, 옮긴이 다 포함), 가격, 출판사, 분류 : 문학 실용서 등, ISBN 
		 * 기능
		 * - 도서 추가
		 * 		-ISBN으로 정렬
		 * - 도서 조회
		 * 		-도서 명으로 조회
		 * 		-저자로 조회
		 * 		-출판사 조회
		 * 		-분류로 조회 
		 */
		ArrayList<Book> list = new ArrayList<Book>();
		int menu =-1;
		
		
		
		do {
			
			printMenu();
			menu = selectMenu(1, 3);
			runMenu(list, menu);
			
		}while(menu!=3);
		
		
		
		
		
		
	}

	private static void runMenu(ArrayList<Book> list, int menu) {
		switch(menu) {
		case 1:
			System.out.println("1. 도서 추가\n추가할 도서의 정보를 입력해주세요.\n");
			System.out.println("도서명을 입력해주세요.");
			scan.nextLine();
			String tmpTitle = scan.nextLine();
			System.out.println("저자를 입력해주세요.(2명 이상일 시 쉼표로 구분해주세요.)");
			String tmpAuthor = scan.nextLine();
			ArrayList<String> tmpAuthorList;
			if(tmpAuthor.contains(",")){
				String[] tmpAuthors = tmpAuthor.split(",");
				 tmpAuthorList = new ArrayList<String>(Arrays.asList(tmpAuthors));
				 //asList가 리턴하는 ArrayList는 java.util.ArrayList와 다름
			}else {
				tmpAuthorList = new ArrayList<String>();
				tmpAuthorList.add(tmpAuthor);
			}
			
			System.out.println("가격을 입력해 주세요");
			int tmpPrice = scan.nextInt();
			scan.nextLine();
			
			System.out.println("출판사를 입력해주세요.");
			String tmpCompany = scan.next();
			
			
			System.out.println("책의 분류를 입력해주세요.");
			String tmpSort = scan.next();
			scan.nextLine();
			
			
			System.out.println("책의 ISBN을 입력해주세요. ");
			int tmpISBN = scan.nextInt();
			Book tmpBook = new Book(tmpTitle, tmpAuthorList, tmpISBN, tmpPrice, tmpCompany, tmpSort);
			list.add(tmpBook);
			System.out.println("도서"+ tmpBook.getTitle()+"이 성공적으로 추가되었습니다.");
			Collections.sort(list);
			
			break;
		case 2:
			printSubMenu();
			
			int subMenu = -1;
			subMenu = selectMenu(1, 4);
			switch(subMenu) {
			case 1:
				//search(list);
				String str = "도서";
				System.out.println(str+"명으로 조회합니다.");
				System.out.println("-----------------------------");
				System.out.println("검색할 "+str+"명을 입력해주세요.");
				scan.nextLine();
				String subTitle = scan.nextLine();
				
				search(list, c->{
					
					if(c.getTitle().equals(subTitle)||c.getTitle().contains(subTitle)) {
						System.out.println(c);
					}
					
				});
				
				
				
				break;
				
			case 2: //저자 조회
				System.out.println("저자명으로 조회합니다.");
				System.out.println("-----------------------------");
				System.out.println("검색할 저자명을 입력해주세요.");
				String subAuthor = scan.next();
				for(Book tmp: list) {
					if(tmp.getAuthor().contains(subAuthor)) {
						System.out.println(tmp);
					}
				}
				break;
			case 3: // 출판사 조회
				System.out.println("출판사명으로 조회합니다.");
				System.out.println("-----------------------------");
				System.out.println("검색할 출판사명을 입력해주세요.");
				scan.nextLine();
				String subCom = scan.nextLine();
				for(Book tmp: list) {
					if(tmp.getTitle().equals(subCom)||tmp.getTitle().contains(subCom)){
						System.out.println(tmp);
					}
				}
				
				break;
			case 4: // 분류 조회
				System.out.println("분류로 조회합니다.");
				System.out.println("-----------------------------");
				System.out.println("검색할 도서의 분류를 입력해주세요.");
				scan.nextLine();
				String subSort = scan.nextLine();
				for(Book tmp: list) {
					if(tmp.getTitle().equals(subSort)||tmp.getTitle().contains(subSort)){
						System.out.println(tmp);
					}
				}
				break;
			case 5:
				System.out.println("전체 도서 출력합니다.");
				System.out.println("-----------------------------");
				for(Book tmp: list) {
					System.out.println(tmp);
				}
				
				
				
				break;
				
				default:
			
			}
			
			//전체 조회
			//
			break;
		case 3:
			break;
			default:
		
		
		
		
		
		}
	}

	private static void search(ArrayList<Book> list, Consumer<Book> c) {
		
		for(Book tmp: list) {
			c.accept(tmp);
		}
	}
	
	
	
	private static void search(ArrayList<Book> list) {
		System.out.println("도서명으로 조회합니다.");
		System.out.println("-----------------------------");
		System.out.println("검색할 도서명을 입력해주세요.");
		scan.nextLine();
		String subTitle = scan.nextLine();
		for(Book tmp: list) {
			if(tmp.getTitle().equals(subTitle)||tmp.getTitle().contains(subTitle)){
				System.out.println(tmp);
			}
		}
	}

	private static void printSubMenu() {
		System.out.print("===메뉴===\n"
				+ "1. 도서명으로 조회\n"
				+ "2. 저자로 조회\n"
				+ "3. 출판사로 조회\n"
				+ "4. 분류로 조회\n"
				+ "5. 전체 조회\n"
				
				+ "메뉴 선택 : ");
	}

	private static int selectMenu(int min, int max) {
		int tmpScan = scan.nextInt();
		if(tmpScan<min-1||tmpScan>max+1) {
			//예외처리
		}
		return tmpScan;
	}

	private static void printMenu() {
		System.out.print("===메뉴===\n"
				+ "1. 도서 추가\n"
				+ "2. 도서 조회\n"
				+ "3. 종료\n"
				+ "--------------\n"
				
				+ "메뉴 선택 : ");
	}

}
