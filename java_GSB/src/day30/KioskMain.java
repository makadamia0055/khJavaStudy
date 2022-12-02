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
		switch(menu) {
		case 1:
			printSubMenu(1);
			break;
		case 2:
			printSubMenu(2);
			break;
		case 3:
			printSubMenu(3);
			break;
		case 4:
			break;
			default:
		}
	}

	private static void printSubMenu(int subMenu) {
		switch(subMenu) {
		case 1:
			System.out.println("1. 제품 등록");
			System.out.println("2. 제품 수정");
			System.out.println("3. 제품 삭제");
			System.out.println("4. 뒤로 가기");
			break;
			
		case 2:
			System.out.println("1. 입출고 기입");
			System.out.println("2. 입출고 수정");
			System.out.println("3. 뒤로 가기");
			break;
			
		case 3:
			
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
	}

}
