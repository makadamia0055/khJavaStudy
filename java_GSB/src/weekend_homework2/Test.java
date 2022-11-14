package weekend_homework2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import interfacePractice01.SampleInplementsClass;

public class Test {

	public static void main(String[] args) {
		/* 가계부 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 내역 추가
		 * 2. 내역 확인
		 * 3. 내역 수정
		 * 4. 내역 삭제
		 * 5. 종료
		 * 
		 * 
		 * 1. 내역 추가 
		 * 구분 : 수입/지출
		 * 분류 : 식비/통신비/교통비/생활비/용돈/ 기타 등등
		 * 내용 : 편의점/식당/전철비
		 * 금액 : 5000
		 * 일시 : 년, 월, 일
		 * 
		 * 2. 내역 확인
		 * | 구분 | 일시 | 분류 | 내용 | 금액 | 순으로
		 * 
		 * 2-1 전체 내역 확인
		 * 2-2 년 내역 확인
		 * 2-3 월 내역 확인
		 * 2-4 일 내역 확인
		 *   
		 * 
		 *   
		 * 3. 내역 수정
		 * 년, 월, 일로 검색 후 내역 출력  
		 * 번호를 입력받아 
		 * 입력받은 번호에 맞는 내열을 수정
		 * - 구분/일시/분류/내용/금액 순으로 입력받아 수정(혹은 수정할 부분 선택)
		 * 
		 * 4. 내역 삭제
		 * 년, 월, 일로 검색 후 내역 출력
		 * 번호를 입력
		 * 입력받은 번호에 맞는 내역을 삭제
		 * 
		 * 
		 * 추가 - 가계부를 년, 월, 일로 정렬
		 *   
		 *   
		 * */
		SampleInplementsClass SIC = new SampleInplementsClass();
		int menu = 0;
		int min = 1, max = 5;
		ArrayList<HK> hkBook = new ArrayList<HK>();

		
		//샘플코드
		
		hkBook.add(new HK(2, "간식비", "마트에서 간식", 5000, 2022, 11, 13));
		hkBook.add(new HK(2, "집세", "송금", 350000, 2022, 11, 1));
		hkBook.add(new HK(2, "게임비", "스팀에서 구매", 15000, 2021, 11, 13));
		hkBook.add(new HK(1, "월급", "월급날이라 받음", 5000000, 2023, 5, 13));
		
		
		
		
		
		
		
		
		/*Collection.sort(hkBook, new Comparator<HK>() {
			
			public int compare(HK o1, HK o2) {
				if(o1.getDataCal().getYear() != o2.getDataCal().getYear()) {
					return o1.getDataCal().getYear()-o2.getDataCal().getYear();
				}
				if(o1.getDataCal().getMonth() != o2.getDataCal().getMonth()) {
					return o1.getDataCal().getMonth()-o2.getDataCal().getMonth();
				}
					return o1.getDataCal().getDay()-o2.getDataCal().getDay();
					
			}
			
		});*/
		
		
		do {
			SIC.printMenu("1. 내역 추가\n"
					+ "2. 내역 확인\n"
					+ "3. 내역 수정\n"
					+ "4. 내역 삭제\n"
					+ "5. 종료");
			
			menu=SIC.selectMenu(min, max);
			runMenu(menu, hkBook);
		}while(menu!=5);
		
		
		
		

	}

	private static void runMenu(int menu, ArrayList<HK> hkBook) {
		Iterator<HK> iterator = hkBook.iterator();
		int tmpYear=0, tmpMonth=0, tmpDay=0;
		switch(menu) {
		case 1:
			System.out.println("→1. 내역추가\n");
			runCase1(hkBook);
			
			break;
			
		case 2:
			System.out.println("→2. 내역 확인");
			int submenu = 0;
			System.out.println("1. 전체내역 확인 2. 년도별 내역 검색 3. 월별 내역 검색 4. 일별 내역 검색");
			System.out.println("1~4 숫자를 입력해 메뉴를 선택해 주십시오");
			submenu = inputScan(submenu, 1, 4, "1~4 사이의 숫자를 입력해 주십시오.");
			switch(submenu) {
			case 1: //전체 출력
				//컬랙션 정렬을 생성 쪽으로 올림.
				System.out.println("전체 내역 출력합니다.");
				System.out.println("구분|일시|분류|내용|금액 순으로 출력됩니다.");
				iterator = hkBook.iterator();
				while(iterator.hasNext()) {
					HK tmpHKP =iterator.next();
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
					HK tmpHKP = iterator.next();
					tmpHKP.printBy(tmpYear);
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
					HK tmpHKP = iterator.next();
					tmpHKP.printBy(tmpYear, tmpMonth);
				}
				
				
				break;
			case 4: //일 출력
			
				DataCal tmpdataCal = getDate();
				tmpYear = tmpdataCal.getYear();
				tmpMonth = tmpdataCal.getMonth();
				tmpDay = tmpdataCal.getDay();
				
				System.out.println(tmpYear+"년도 " +tmpMonth+"월" + tmpDay+"일의 내역 출력합니다.");
				
				iterator = hkBook.iterator();
				while(iterator.hasNext()) {
					HK tmpHKP = iterator.next();
					tmpHKP.printBy(tmpYear, tmpMonth, tmpDay);
				}//해보니까 프린트는 따로 하고 , 서치로 새로운 arraylist나 번지 리턴해주는 함수가 더 좋은듯.
				
				break;
				default:
			}
			
			break;
		case 3:
			
			DataCal tmpdataCal = getDate();
			tmpYear = tmpdataCal.getYear();
			tmpMonth = tmpdataCal.getMonth();
			tmpDay = tmpdataCal.getDay();
			
			System.out.println(tmpYear+"년도 " +tmpMonth+"월" + tmpDay+"일의 내역 출력합니다.");
			
			iterator = hkBook.iterator();
			ArrayList<HK> tmpAL = new ArrayList<HK>();
			// 검색 먼저 수행 이후 결과 출력
			while(iterator.hasNext()) {
				HK tmpHKP = iterator.next();
				if(tmpHKP.seachBy(tmpYear, tmpMonth, tmpDay)!=null) {
					tmpAL.add(tmpHKP);
				}
			}
			
			for(int i = 0; i< tmpAL.size(); i++) {
				System.out.print((i+1)+"번 :");
				tmpAL.get(i).printBy(tmpYear, tmpMonth, tmpDay);
			}
			System.out.println("몇 번을 수정하시겠습니까?");
			int tmpNum=0;
			tmpNum = inputScan(tmpNum, 1, tmpAL.size(), "해당하는 값이 없습니다.");
			// 왜 이걸 tmp숫자 받아서 하는걸로 설계했지?
			HK deleteHK = tmpAL.get(tmpNum-1);
			
			//귀찮아서 확인 작업 뺌
			
			hkBook.remove(deleteHK);
			
			ArrayList<HK> tmpcreateHKBook = new ArrayList<HK>();
			runCase1(tmpcreateHKBook);
			HK tmpCreateHK = tmpcreateHKBook.get(0);
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

	private static void runCase4(ArrayList<HK> hkBook) {
		int tmpYear, tmpMonth, tmpDay;
		Iterator<HK> iterator = hkBook.iterator();

		DataCal tmpdataCal = getDate();
		tmpYear = tmpdataCal.getYear();
		tmpMonth = tmpdataCal.getMonth();
		tmpDay = tmpdataCal.getDay();
		
		System.out.println(tmpYear+"년도 " +tmpMonth+"월" + tmpDay+"일의 내역 출력합니다.");
		
		iterator = hkBook.iterator();
		ArrayList<HK> tmpAL = new ArrayList<HK>();
		// 검색 먼저 수행 이후 결과 출력
		while(iterator.hasNext()) {
			HK tmpHKP = iterator.next();
			if(tmpHKP.seachBy(tmpYear, tmpMonth, tmpDay)!=null) {
				tmpAL.add(tmpHKP);
			}
		}
		
		for(int i = 0; i< tmpAL.size(); i++) {
			System.out.print((i+1)+"번 :");
			tmpAL.get(i).printBy(tmpYear, tmpMonth, tmpDay);
		}
		System.out.println("몇 번을 삭제하시겠습니까?");
		int tmpNum=0;
		tmpNum = inputScan(tmpNum, 1, tmpAL.size(), "해당하는 값이 없습니다.");
		// 왜 이걸 tmp숫자 받아서 하는걸로 설계했지?
		HK deleteHK = tmpAL.get(tmpNum-1);
		
		//귀찮아서 확인 작업 뺌
		
		hkBook.remove(deleteHK);
		System.out.println(deleteHK+"내역을 삭제 완료하였습니다.");
		tmpAL.clear();
	}

	private static void runCase1(ArrayList<HK> hkBook) {
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
		DataCal tmpDataCal = getDate();
		
		HK tmpHK =new HK(tmpIO, tmpSort, tmpContents, tmpAmount, tmpDataCal);
		hkBook.add(tmpHK);
		Collections.sort(hkBook);
		System.out.println("성공적으로 가계부가 작성되었습니다.");
		
	}

	private static DataCal getDate() {
		
		System.out.println("년 : ");
		int tmpYear=0;
		tmpYear = inputScan(tmpYear, 1970, 2050, "1970과 2050 사이의 년도를 입력해주십시오.");
		
		System.out.println("월 : ");

		int tmpMonth = 0;
		tmpMonth= inputScan(tmpMonth, 1, 12, "1과 12 사이의 월을 입력해주십시오.");
		
		System.out.println("일 : ");
		int tmpDay = 0;
		Calendar cal = Calendar.getInstance();
		
		do {
		tmpDay = inputScan(tmpDay, 1, 31, "1과 31사이의 숫자를 입력해주십시오.");
		cal.set(tmpYear, tmpMonth-1, 1);
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		if(tmpDay>(cal.getActualMaximum(Calendar.DAY_OF_MONTH))) {
			System.out.println((tmpMonth)+ "월에는 "+tmpDay+"일이 없습니다.");
			System.out.println("일 : ");
		}else {
			
			System.out.printf("%d년 %d월 %d일이 정상 입력 되었습니다.", tmpYear, tmpMonth, tmpDay);
			break;
		}
		
		}while(true);
		
		 
		
		return new DataCal(tmpYear, tmpMonth, tmpDay);
	}

	private static int inputScan(int tmp, int i, int j, String string) {
		Scanner scan =new Scanner(System.in);
		do {
			tmp=scan.nextInt();
			if(tmp>=i&&tmp<=j) {
				return tmp;
			}else {
				System.out.println(string);
			}
			
		}while(true);
		
		
		
		
	}

	
	
	
}
