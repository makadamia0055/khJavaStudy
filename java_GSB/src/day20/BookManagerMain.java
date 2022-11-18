package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;


public class BookManagerMain {
	static Scanner scan = new Scanner(System.in);
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

			menu = scan.nextInt();
			
			runMenu(list, menu);
			
			
		}while(menu !=3);
		scan.close();

	}
	
	private static void runMenu(ArrayList<Book> list, int menu) {
		switch(menu){
		case 1:
			
			Book book = createBook();
			//생성된 도서 객체를 리스트에 추가
			// isbn 중복 체크해서 중복 되면 건너뜀
			boolean isDuplicated = insertBook(list, book);
			if(isDuplicated){
				System.out.println("이미 추가된 서적입니다.");
			} else {
				System.out.println("도서 추가가 완료되었습니다.");
			}
			printbar();	
			break;
		case 2:
			// 도서 조회
				//-도서명
				//-도서 저자
				//-출판사
				//-분류
			//서브 메뉴 출력
			printSearchMenu();
			
			//서브메뉴 선택
			int subMenu = -1;
			subMenu = scan.nextInt();
			//선택한 서브 메뉴 실행
			runSearchMenu(list, subMenu);
			break;
		case 3:
			break;
			default:
		}
		
	}
	private static void runSearchMenu(ArrayList<Book> list, int subMenu) {
		String title, author, publisher, genre;
		int count = 0;
		switch(subMenu) {
		case 1: //도서명 조회
			System.out.println("도서명 : ");
			scan.nextLine();// 엔터처리
			title =scan.nextLine();
			printBookList(list, b->b.getTitle().contains(title.trim()));
			break;				
			
			
			
		case 2: // 저자 조회
			System.out.println("저자명 : ");
			scan.nextLine();// 엔터처리
			author =scan.nextLine();
			printBookList(list, b->b.getAuthor().contains(author.trim()));
			break;				
			
		case 3: // 출판사 조회
			System.out.println("출판사명 : ");
			scan.nextLine();// 엔터처리
			publisher =scan.nextLine();
			printBookList(list, b->b.getPublisher().contains(publisher.trim()));
			break;				
			
		case 4: // 장르 조회
			System.out.println("장르 : ");
			scan.nextLine();// 엔터처리
			genre =scan.nextLine();
			printBookList(list, b->b.getGenre().contains(genre.trim()));
			break;				
			
		case 5: //취소
			System.out.println("조회를 취소했습니다.");
			printbar();					
			break;
			default:
				System.out.println("잘못된 메뉴입니다.");
				printbar();
		}
		
				
	}
	private static void printSearchMenu() {
		printbar();
		System.out.println("1. 도서명 조회");
		System.out.println("2. 도서 저자 조회");
		System.out.println("3. 출판사 조회");
		System.out.println("4. 장르 조회");
		System.out.println("5. 취소");
		printbar();
		System.out.print("조회 방법 선택 : ");		
	}
	private static boolean insertBook(ArrayList<Book> list, Book book) {
		if(list.contains(book)) {
			return true;
		}
		list.add(book);// 이걸 리턴해도 되는데 나는 값을 반대로 해서 !해야해서 그냥 안함.
		Collections.sort(list, (o1, o2)-> o1.getIsbn().compareTo(o2.getIsbn()));
		return false;
	}
	private static Book createBook() {
		scan.nextLine();
		System.out.print("도서명 : ");
		String title = scan.nextLine();
		System.out.print("저자명 : ");
		String author = scan.nextLine();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		System.out.print("출판사명 : ");
		String publisher = scan.next();
		scan.nextLine();
		System.out.print("장르명 : ");
		String genre  = scan.next();
		scan.nextLine();
		System.out.print("ISBN : ");
		String isbn = scan.next();
		
		Book book = new Book(title, author, publisher, genre, isbn, price); 
		
		return book;
	}
	private static void printMenu() {
		System.out.println("=====메뉴=====");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 종료");
		printbar();
		System.out.print("메뉴 : ");		
	}
	public static void printbar() {
		System.out.println("============");

	}
	public static void printBookList(ArrayList<Book> list, Predicate<Book> p) {
		int count = 0;
		for(Book tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
				printbar();
				count++;
			}
		}
		if(count==0) {
			System.out.println("검색 결과가 없습니다.");
			printbar();
	}

	

	}


	
}
