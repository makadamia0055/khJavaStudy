package day30;

import java.util.Scanner;

public class KioskMain {
	private static Scanner scan = new Scanner(System.in);
	private static ProductManager pM = new ProductManager();

	/*
	 * 제품 관리하는 프로그램을 작성하세요
	 * 	-구매가격, 판매가격 변동 X
	 * 기능
	 * - 제품 등록(분류, 제품명, 수량, 구매가격, 판매가격)
	 * - 제품 수정
	 * - 제품 삭제
	 * - 제품 구매(입고)
	 * - 제품 판매(출고)
	 * - 매출액 확인 (계산기 class)
	 * 
	 * 	-년별 매출 (입출력 대장 class)
	 * 		-제품별
	 * 		-전체
	 * 	-월별 매출
	 * 		-제품별
	 * 		-전체
	 * 	-일별 매출
	 * 		-제품별
	 * 		-전체
	 * 	
	 * 
	 */
	public static void main(String[] args) {
		
		int menu =-1;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		}while(menu !=4);
		

	}

	private static void runMenu(int menu) {
		int subMenu = -1;
		switch(menu) {
		case 1:
			do {
			printSubMenu(1);
			subMenu = scan.nextInt();
			scan.nextLine();
			runSubMenu(1, subMenu);
			}while(subMenu!=5);
			break;
		case 2:
			do {
			printSubMenu(2);
			subMenu = scan.nextInt();
			scan.nextLine();
			runSubMenu(2, subMenu);
			}while(subMenu!=3);
			
			break;
		case 3:
			do {
			printSubMenu(3);
			subMenu = scan.nextInt();
			scan.nextLine();
			runSubMenu(3, subMenu);
			}while(subMenu!=4);
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
			default: System.out.println("잘못된 접근입니다.");
		}
	}
	private static void runSubMenu(int menu, int subMenu) {
		switch(menu) {
		case 1:
			switch(subMenu) {
			case 1:
				System.out.println("제품을 추가합니다.");
				if(pM.addProduct()) {
					System.out.println("제품 추가가 완료되었습니다.");
				}else {
					System.out.println("제품 추가가 취소되었습니다.");
				}
				break;
			case 2:
				System.out.println("제품을 수정합니다.");
				if(pM.editProduct()) {
					System.out.println("제품 수정이 완료되었습니다.");
				}else {
					System.out.println("제품 수정이 취소되었습니다.");
				}
				break;
			case 3:
				System.out.println("제품을 삭제합니다.");
				if(pM.deleteProduct()) {
					System.out.println("제품 삭제가 완료되었습니다.");
				}else {
					System.out.println("제품 삭제가 취소되었습니다.");
				}
				break;
			case 4:
				System.out.println("제품 등록 현황을 열람합니다.");
				pM.getProductList().forEach(p->System.out.println(p.print()));
				
				break;
				
			case 5:
				System.out.println("뒤로 돌아갑니다.");
				break;
			default:
			}
			
			
			break;
		case 2: 
			switch(subMenu) {
			case 1:
				System.out.println("입출고 대장을 기입합니다.");
				if(!pM.addInOutProduct()) {
					System.out.println("입출고 대장 기입을 취소했습니다.");
				}
				break;
			case 2:
				System.out.println("입출고 대장을 수정합니다.");
				if(!pM.editInOutProduct()) {
					System.out.println("입출고 대장 기입을 취소했습니다.");
				}
				break;
			case 3:
				System.out.println("뒤로 돌아갑니다.");
				break;
			default:
			}
			break;
			
		case 3: 
			switch(subMenu) {
			case 1:
				System.out.println("검색할 일자를 입력해주십시오.");
				pM.printCalculator(1);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:System.out.println("뒤로 돌아갑니다."); 
				break;
			default:
			}
			break;
			default: System.out.println("잘못된 접근입니다.");
		}
	}
	
	private static void printSubMenu(int subMenu) {
		switch(subMenu) {
		case 1:
			System.out.println("1. 제품 등록");
			System.out.println("2. 제품 수정");
			System.out.println("3. 제품 삭제");
			System.out.println("4. 제품 등록 현황");
			System.out.println("5. 뒤로 가기");
			System.out.print("메뉴 입력 : ");
			break;
			
		case 2:
			System.out.println("1. 입출고 기입");
			System.out.println("2. 입출고 수정");
			System.out.println("3. 뒤로 가기");
			System.out.print("메뉴 입력 : ");
			break;
			
		case 3:
			System.out.println("1. 일자별 매출액 열람");
			System.out.println("2. 월별 매출액 열람");
			System.out.println("3. 연도별 매출액 열람");
			System.out.println("4. 뒤로 가기");
			System.out.print("메뉴 입력 : ");
			
			break;
			
			default:
		}
		
	}

	private static void printMenu() {
		System.out.println("메인메뉴");
		System.out.println("1. 제품 등록 메뉴");
		System.out.println("2. 제품 입출고 메뉴");
		System.out.println("3. 매출액 확인 메뉴");
		System.out.println("4. 종료");
		System.out.print("메뉴 입력 : ");
		
	}

}
