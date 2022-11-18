package day18;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;


public class AccountServiceImp implements AccountService{

	@Override
	public void insertItem(ArrayList<Item> list, Item item) {
		//리스트에 내역 추가
		list.add(item);
		//Collections.sort(list);
		//날짜를 기준으로 정렬
		
		Collections.sort(list, new Comparator<Item>() {
			
			@Override
			public int compare(Item o1, Item o2) {
				if(o1==null) {
					return 1;
				}
				if(o2==null) {
					return -1;
				}
				return o1.getDate().compareTo(o2.getDate());
				
			}
		});
		
	}

	@Override
	public void printItem(ArrayList<Item> list) {
		if(list.size()==0) {
			System.out.println("기록된 내역이 없습니다.");
			return;
		}
		for(Item tmp : list) {
			System.out.println(tmp);
		}
	}

	@Override
	public boolean updateItem(ArrayList<Item> list, int index, Item item) {
		if(index<0||index>=list.size()) {
			throw new RuntimeException("예외 발생 : 내역을 잘못 선택했습니다.");
		}
		list.set(index, item);
		return true;
	}

	@Override
	public boolean deleteItem(ArrayList<Item> list, int index) {
		if(index<0||index>=list.size()) {
			throw new RuntimeException("예외 발생 : 내역을 잘못 선택했습니다.");
		}
		list.remove(index);

		return true;
	}

	@Override
	public void printMenu() {
		System.out.println("메뉴--------------");
		System.out.println("1. 내역 추가");
		System.out.println("2. 내역 확인");
		System.out.println("3. 내역 수정");
		System.out.println("4. 내역 삭제");
		System.out.println("5. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(ArrayList<Item> list, int menu, Scanner scan) throws ParseException {
		switch(menu) {
		case 1:
			//내역 정보를 입력
			// 구분, 분류, 내용, 금액, 일시를 입력
			System.out.println("내역 정보를 입력해주십시오.");
			
			//입력받은 정보를 이용하여 내역 객체 생성
			
			insertItem(list, inputItem(scan));
			
			break;
		case 2:
			//내역 확인
			//전체 검색
			printSubMenu();
			// 서브 메뉴 선택
			scan.nextLine();
			int subMenu = scan.nextInt();
			runPrint(list, subMenu, scan);
			// 메뉴에 따른 출력 기능 실행
			
			//년검색, 월검색, 일검색
			break;
			
		case 3: 
			//내역 수정
			
			String date = inputDate(scan);

			int index=selectItem(list, scan, date);
			
			Item item = inputItem(scan);
			
			//연월일로 검색 후 내역 수정 case2의 일검색 활용.
			//해당 일자에 기록된 일자들 출력
			
			//수정할 내역을 번호로 선택
			//수정할 내역 전체를 입력함.
			//입력된 내역으로 수정함.
			updateItem(list, index, item);
			break;
		case 4:
			//내역 삭제
			//연월일로 검색 후 내역 삭제 case2의 일검색 활용.
			//해당 일자에 기록된 일자들 출력
			
			//삭제할 내역을 번호로 선택
			//입력된 내역으로 삭제함.
			String date1 =  inputDate(scan);

			int index1=selectItem(list, scan, date1);
			
			deleteItem(list, index1);
			break;
		case 5:
			break;
			
			default:
				System.out.println("잘못된 접근입니다.");
		}
}	
		


	@Override
	public Item inputItem(Scanner scan) throws ParseException {
		System.out.println("구분(1. 수입/2. 지출)을 입력해주십시오.");
		int type= scan.nextInt();
		scan.nextLine();
		System.out.println("분류(식비/교통비 등) : ");
		String purpose = scan.next();
		scan.nextLine();
		System.out.println("내용 : ");
		String context = scan.nextLine();
		
		System.out.println("금액(정수로 입력): ");
		int money = scan.nextInt();
		System.out.println("일시(2022-11-16) : ");
		String date = scan.next();
		
		return new Item(type, purpose, context, money, date);
	}
	
	public void addEx(ArrayList<Item> list) throws ParseException {
		list.add(new Item(2, "간식비", "마트에서 간식", 5000, "2022-11-13"));
		list.add(new Item(2, "집세", "송금", 350000, "2022-11-1"));
		list.add(new Item(2, "게임비", "스팀에서 구매", 15000, "2021-11-13"));
		list.add(new Item(1, "월급", "월급날이라 받음", 5000000, "2023-5-13"));
		
	}

	public int selectItem(ArrayList<Item> list, Scanner scan, String date) {
		
		
		ArrayList<Integer> indexList = 
				new ArrayList<Integer>();
		//날짜가 같은 내역들을 모음
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getDateStr().equals(date)) {
				indexList.add(i);
			}
		}
		if(indexList.size()==0) {
			throw new RuntimeException("예외 발생 : 해당 일시에는 내역이 없습니다.");
		}
		//날짜가 같은 내역들을 출력
		for(int i = 0 ; i<indexList.size();i++) {
			System.out.println(i+1+"번 내역");
			list.get(indexList.get(i)).print();
			//indexList는 날짜 값을 스캔해서 얻은 정수 배열이니까 
		}
		// 수정할 내역을 선택
		System.out.println("내역 선택 : ");
		int index = scan.nextInt() -1;
		if(index < 0 || index>= indexList.size()) {
			throw new RuntimeException("예외 발생 : 내역을 잘못 선택했습니다."); 
		}
		return indexList.get(index);
	}

	
	public String inputDate(Scanner scan) throws ParseException {
		System.out.print("일시 입력 : ");
		String date = scan.next();
		scan.nextLine();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		f.parse(date);
		// 잘못된 형태가 입력되면 예외가 발생되게 변환을 한번 시켜줌.
		
		
		return date;
	}

	@Override
	public void printItem(ArrayList<Item> list, int... dates) {
		
		String date = "" ;
		for(int tmp : dates) {
			date += "-" + (tmp < 10 ? "0" +tmp : tmp);
		}
		
		date = date.substring(1); // 상기 코드로 년도 앞에 -2022-01-11 
		//이렇게 "-"가 붙음. 그걸 제거해주기 위한 코드
		
		int size= date.length();
		for (Item item : list) {
			if (item.getDateStr().substring(0, size).equals(date)) {
				System.out.println(item);
			}

		}
		
	}

	@Override
	public int inputYear(Scanner scan) {
		System.out.println("연도 입력 : ");
		int year = scan.nextInt();
		if(year <0)
			throw new RuntimeException("예외 발생 : 연도를 잘못 입력했습니다.");
		return year; 
	}

	@Override
	public int inputMonth(Scanner scan) {
		System.out.println("월 입력 : ");
		int month = scan.nextInt();
		if(month<0||month>12)
			throw new RuntimeException("예외 발생 : 달을 잘못 입력했습니다.");
		return month;
	}

	@Override
	public int inputDay(Scanner scan) {
		System.out.println("월 입력 : ");
		int day = scan.nextInt();
		if(day<0||day>31)
			throw new RuntimeException("예외 발생 : 날짜를 잘못 입력했습니다.");
		return day;
	}

	@Override
	public void printSubMenu() {
		System.out.println("=====메뉴=====");
		System.out.println("1. 전체 출력");
		System.out.println("2. 특정 년 검색");
		System.out.println("3. 특정 월 검색");
		System.out.println("4. 특정 일 검색");
		System.out.println("============");
	}

	@Override
	public void runPrint(ArrayList<Item> list, int subMenu, Scanner scan) {
		int year, month, day;
		switch(subMenu) {
			case 1:
				printItem(list);
				
				break;
			case 2:
				year = inputYear(scan);
				//printItem(list, year);
				printItem(list, (s)->s.getDateStr().substring(0, 4).equals(""+year));
				
				
				break;
			case 3:
				year = inputYear(scan);
				month = inputMonth(scan);
				//printItem(list, year, month);
				printItem(list, (s)->s.getDateStr().substring(0, 7).equals(""+year+"-"+month));
				
				break;
			case 4:

				year = inputYear(scan);
				month = inputMonth(scan);
				day = inputDay(scan);
				//printItem(list, year, month, day);
				printItem(list, (s)->s.getDateStr().substring(0, 10).equals(""+year+"-"+month+"-"+day));
				break;
				
			case 5:
				/*System.out.println("수입/지출 선택 : ");
				String type = scan.next();
				int intType = type.equals("수입")?1:2;
				printItem(list, (s)->s.getType());
				*/
				default:
					
			}
	}

	@Override
	public void printItem(ArrayList<Item> list, Predicate<Item> p) {
			
			for(Item tmp : list) {
				if(p.test(tmp)) {
					System.out.println(tmp);
				}
			}
			
	}

	

}