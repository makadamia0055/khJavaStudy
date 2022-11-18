package weekend_homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class AccountBook {
	ArrayList<Item> list = new ArrayList<Item>();
	AccountService accountService = new AccountServiceImp();
	// 인터페이스는 객체를 생성할 수 없지만 인터페이스의 구현 객체를 참조할 수 있다.
	Scanner scan;
	
	public void run() {
		System.out.println("가계부 프로그램 실행합니다.");
		ArrayList<Item> hkBook = new ArrayList<Item>();
		int min = 1, max = 5;
		int menu = -1;

		//샘플코드
		
		
		
		
		
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
	private static void runMenu(int menu, ArrayList<Item> hkBook) {
		Iterator<Item> iterator = hkBook.iterator();
		int tmpYear=0, tmpMonth=0, tmpDay=0;
		switch(menu) {
		case 1:
			System.out.println("→1. 내역추가\n");
			runCase1(hkBook);
			System.out.println("성공적으로 가계부가 작성되었습니다.");

			break;
			
		case 2:
			System.out.println("→2. 내역 확인");
			int submenu = 0;
			printSubMenu("1. 전체내역 확인 2. 년도별 내역 검색 3. 월별 내역 검색 4. 일별 내역 검색\n1~4 숫자를 입력해 메뉴를 선택해 주십시오");
			submenu = inputScan(submenu, 1, 4, "1~4 사이의 숫자를 입력해 주십시오.");
			switch(submenu) {
			case 1: //전체 출력
				//컬랙션 정렬을 생성 쪽으로 올림.
				System.out.println("전체 내역 출력합니다.");
				System.out.println("구분|일시|분류|내용|금액 순으로 출력됩니다.");
				iterator = hkBook.iterator();
				while(iterator.hasNext()) {
					Item tmpHKP =iterator.next();
					System.out.println(tmpHKP);
				}
				System.out.println("---------내역 종료----------");
				
				break;
			case 2: //년 출력
				System.out.println("검색할 년도를 입력해주세요");
			
				tmpYear = inputScan(tmpYear, 1970, 2050, "1970과 2050 사이의 년도를 입력해주십시오.");
				
				System.out.println(tmpYear+"년도의 내역 출력합니다.");
				
				iterator = hkBook.iterator();
				while(iterator.hasNext()) {
					Item tmpHKP = iterator.next();
					if(tmpHKP.seachBy(tmpYear)!=null) {
						System.out.println(tmpHKP.seachBy(tmpYear));
					}
					
				}
				break;
			case 3: //월 출력
				
				System.out.println("검색할 년도를 입력해주세요.");
				tmpYear = inputScan(tmpYear, 1970, 2050, "1970과 2050 사이의 년도를 입력해주십시오.");
				
				System.out.println("검색할 월을 입력해주세요.");
				tmpMonth= inputScan(tmpMonth, 1, 12, "1과 12 사이의 월을 입력해주십시오.");
				
				System.out.println(tmpYear+"년도 " +tmpMonth+"월의 내역 출력합니다.");
				
				iterator = hkBook.iterator();
				while(iterator.hasNext()) {
					Item tmpHKP = iterator.next();
					if(tmpHKP.seachBy(tmpYear, tmpMonth)!=null) {
						System.out.println(tmpHKP.seachBy(tmpYear, tmpMonth));
					}

				}
				
				
				break;
			case 4: //일 출력
			
				DataCal tmpdataCal = DataCal.getDate();
				tmpYear = tmpdataCal.getYear();
				tmpMonth = tmpdataCal.getMonth();
				tmpDay = tmpdataCal.getDay();
				
				System.out.println(tmpYear+"년도 " +tmpMonth+"월" + tmpDay+"일의 내역 출력합니다.");
				
				iterator = hkBook.iterator();
				while(iterator.hasNext()) {
					Item tmpHKP = iterator.next();
					if(tmpHKP.seachBy(tmpYear, tmpMonth, tmpDay)!=null) {
						System.out.println(tmpHKP.seachBy(tmpYear, tmpMonth, tmpDay));
					}
					
				}//해보니까 프린트는 따로 하고 , 서치로 새로운 arraylist나 번지 리턴해주는 함수가 더 좋은듯.
				
				break;
				default:
			}
			
			break;
		case 3:
			
			DataCal tmpdataCal = DataCal.getDate();
			tmpYear = tmpdataCal.getYear();
			tmpMonth = tmpdataCal.getMonth();
			tmpDay = tmpdataCal.getDay();
			
			System.out.println(tmpYear+"년도 " +tmpMonth+"월" + tmpDay+"일의 내역 출력합니다.");
			
			iterator = hkBook.iterator();
			ArrayList<Item> tmpAL = new ArrayList<Item>();
			// 검색 먼저 수행 이후 결과 출력
			while(iterator.hasNext()) {
				Item tmpHKP = iterator.next();
				if(tmpHKP.seachBy(tmpYear, tmpMonth, tmpDay)!=null) {
					tmpAL.add(tmpHKP);
				}
			}
			
			for(int i = 0; i< tmpAL.size(); i++) {
				System.out.print((i+1)+"번 :");
				System.out.println(tmpAL.get(i).seachBy(tmpYear, tmpMonth, tmpDay));
			}
			System.out.println("몇 번을 수정하시겠습니까?");
			int tmpNum=0;
			tmpNum = inputScan(tmpNum, 1, tmpAL.size(), "해당하는 값이 없습니다.");
			// 왜 이걸 tmp숫자 받아서 하는걸로 설계했지?
			Item deleteHK = tmpAL.get(tmpNum-1);
			
			//귀찮아서 확인 작업 뺌
			
			hkBook.remove(deleteHK);
			
			ArrayList<Item> tmpcreateHKBook = new ArrayList<Item>();
			runCase1(tmpcreateHKBook);
			Item tmpCreateHK = tmpcreateHKBook.get(0);
			hkBook.add(tmpCreateHK);
			Collections.sort(hkBook);
			System.out.println(deleteHK+"내역을"+tmpCreateHK+"로 변경하였습니다.");
			tmpAL.clear();
			tmpcreateHKBook.clear();
			
			break;
		case 4:
			runCase4(hkBook);
			
			break;
		case 5:
			break;
			default:
		}
		
	}

	private static void printSubMenu(String string) {
		System.out.println(string);
	}
	
	private static void runCase4(ArrayList<Item> hkBook) {
		int tmpYear, tmpMonth, tmpDay;
		Iterator<Item> iterator = hkBook.iterator();

		DataCal tmpdataCal = DataCal.getDate();
		tmpYear = tmpdataCal.getYear();
		tmpMonth = tmpdataCal.getMonth();
		tmpDay = tmpdataCal.getDay();
		
		System.out.println(tmpYear+"년도 " +tmpMonth+"월" + tmpDay+"일의 내역 출력합니다.");
		
		iterator = hkBook.iterator();
		ArrayList<Item> tmpAL = new ArrayList<Item>();
		// 검색 먼저 수행 이후 결과 출력
		while(iterator.hasNext()) {
			Item tmpHKP = iterator.next();
			if(tmpHKP.seachBy(tmpYear, tmpMonth, tmpDay)!=null) {
				tmpAL.add(tmpHKP);
			}
		}
		
		for(int i = 0; i< tmpAL.size(); i++) {
			System.out.print((i+1)+"번 :");
			System.out.println(tmpAL.get(i).seachBy(tmpYear, tmpMonth, tmpDay));
		}
		System.out.println("몇 번을 삭제하시겠습니까?");
		int tmpNum=0;
		tmpNum = inputScan(tmpNum, 1, tmpAL.size(), "해당하는 값이 없습니다.");
		// 왜 이걸 tmp숫자 받아서 하는걸로 설계했지?
		Item deleteHK = tmpAL.get(tmpNum-1);
		
		//귀찮아서 확인 작업 뺌
		
		hkBook.remove(deleteHK);
		System.out.println(deleteHK+"내역을 삭제 완료하였습니다.");
		tmpAL.clear();
	}

	private static void runCase1(ArrayList<Item> hkBook) {
		Scanner scan = new Scanner(System.in);
		System.out.print("1. 수입/2. 지출 여부 입력 :  ");
		int tmpIO=0;
		tmpIO=inputScan(tmpIO, 1, 2, "1과 2 중 하나를 입력해주십시오.");
		
		System.out.println("2. 기록할 "+ ((tmpIO==1)?"수입":"지출") +"을 어떻게 분류하시겠습니까?");
		String tmpSort = scan.next();
		scan.nextLine();
		
		System.out.println("3. 세부 내역을 기입해주십시오.");
		String tmpContents = scan.nextLine();
		
		System.out.println("4. "+ ((tmpIO==1)?"수입":"지출")+ "을 기입해주십시오");
		int tmpAmount = scan.nextInt();
		
		System.out.println("5.날짜를 기입해주십시오.");
		DataCal tmpDataCal = DataCal.getDate();
		
		Item tmpHK =new Item(tmpIO, tmpSort, tmpContents, tmpAmount, tmpDataCal);
		hkBook.add(tmpHK);
		Collections.sort(hkBook);
		scan.close();
	}

	
	private static int inputScan(int tmp, int i, int j, String string) {
		Scanner scan =new Scanner(System.in);
		do {
			tmp=scan.nextInt();
			if(tmp>=i&&tmp<=j) {
				scan.close();
				return tmp;
			}else {
				System.out.println(string);
				scan.close();
			}
			
		}while(true);
		
		
		
	}

	
}
