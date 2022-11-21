package day21;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class PhoneListMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 전화번호 관리하는 프로그램을 작성하세요.
		 * 1. 전화번호 추가(성, 이름, 직장, 전화번호들[집 : 000000 핸드폰번호 : 0000])
		 * 2. 전화번호 수정
		 * 		- 이름으로 검색(성+이름)
		 * 		- 검색된 사람들 중에서 선택을 함
		 * 		- 성, 이름을 수정할건지, 기존 등록된 전화번회를 수정할 것인지
		 * 		  새 전화번호를 등록할 건지 선택하여 동작
		 * 3. 전화번호 삭제
		 * 		- 이름으로 검색(성+이름)
		 * 		- 검색된 사람들 중에서 선택을 함
		 * 		- 선택된 사람의 연락처 삭제
		 * 
		 * 4. 전화번호 조회
		 * 		- 이름으로 검색
		 * 		- 검색된 사람들 중에서 선택을 함
		 * 		- 선택 된 사람의 연락처를 출력
		 * 5. 종료		
		 */
		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>(); 
		int menu =-1;
		
		do {
			printMenu();
			try {
			menu = selectMenu(1, 5);
			runMenu(list, menu);
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}while(menu!=5);
		
		scan.close();
		
		
	}
		public static void runMenu(ArrayList<PhoneBook> list, int menu) throws RuntimeException {
			switch(menu){
		case 1:
			if(insertPhoneBook(list)) {
				System.out.println("전화번호를 추가했습니다.");
				System.out.println("=====================");
			}else {
				System.out.println("전화번호를 추가하지 못했습니다.");
				System.out.println("=====================");
			}
			
			break;
		case 2:
			if(updatePhoneBook(list)) {
				System.out.println("전화번호 수정이 완료되었습니다.");
				System.out.println("=====================");
			}else {
				System.out.println("전화번호를 수정하지 못했습니다.");
				System.out.println("=====================");
			}
			
			
			break;
		case 3: //번호 삭제
			// 
			if(deletePhoneBook(list)) {
				System.out.println("전화번호를 삭제했습니다.");
				System.out.println("===================");
			}else {
				System.out.println("전화번호를 삭제하지 못했습니다.");
				System.out.println("===================");
			}
			
			
			
			break;
		case 4:
			// 이름을 입력
			printSearchNumber(list);
			
			// 이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
			// 조회할 전화번호부 선택
			// 전화번호 조회
			break;
		case 5:
		
			break; 
			
			
		default:
			System.out.println("잘못된 메뉴입니다.");
			System.out.println("===================");

		}
	}

	private static boolean updatePhoneBook(ArrayList<PhoneBook> list) {
		System.out.println("수정할 연락처를 검색합니다.");
		ArrayList<Integer> searchList = searchByName(list);
		Integer index= printIndexsNumber(list, searchList);
		PhoneBook tmpPB = list.get(index);
		
		printSubMenu();
	
		
		int subMenu = scan.nextInt();
		scan.nextLine();
		;
		
		return runSubMenu(subMenu, tmpPB);
		}
	
	private static boolean runSubMenu(int subMenu, PhoneBook tmpPB) {
		switch(subMenu) {
		case 1:
			System.out.println("기존 프로필을 수정합니다.");
			System.out.println("이름 : ");
			System.out.println(tmpPB.getName() +" -> " );
			String editName = scan.nextLine();
			System.out.println("직장 : ");
			System.out.println(tmpPB.getCompany() +" -> " );
			String editCompany = scan.nextLine();
			
			tmpPB.update(editName, editCompany);
			
			System.out.println("기존 프로필 수정이 완료되었습니다.");
			break;
		case 2:
			System.out.println(tmpPB.getName()+"님의 기존 연락처를 수정합니다.");
			//pb.printPhoneNumbers();
			ArrayList<Integer> indexs = new ArrayList<Integer>();
			for(int i = 0; i<tmpPB.getPnList().size(); i++) {
				if(tmpPB.getPnList().get(i)!=null) {
					indexs.add(i);
				}
			}
			for(int i = 0; i <indexs.size(); i++) {
				System.out.println(i+1 +". "+tmpPB.getPnList().get(indexs.get(i)));
			}
			System.out.println("선택할 연락처의 번호를 입력하세요.");
			int editIndex = scan.nextInt()-1;
			scan.nextLine();
			
			System.out.println(tmpPB.getPnList().get(editIndex)+"을 수정합니다.");
			System.out.print(tmpPB.getPnList().get(editIndex).getPName()+ " -> ");
			String pName = scan.nextLine();
			System.out.print(tmpPB.getPnList().get(editIndex).getNumber()+ " -> ");
			String number = scan.nextLine();
			tmpPB.getPnList().get(editIndex).update(pName, number);
			System.out.println("기존 번호 수정이 완료되었습니다.");
			
			break;
		case 3:
			System.out.println("새로운 연락처를 추가합니다.");
			ArrayList<PhoneNumber> pnList = inputPhoneNumbers();
			tmpPB.getPnList().addAll(pnList);//모두 넣어주는 것.
			
			break;
			
		default:
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("===================");
				return false;
		}
		return true;
	}
	private static void printSubMenu() {
		System.out.println("==============");
		System.out.println("1. 기존 프로필 수정");
		System.out.println("2. 기존 번호 수정");
		System.out.println("3. 새로운 번호 추가");
		System.out.println("==============");
	}
	private static void printSearchNumber(ArrayList<PhoneBook> list) {
		ArrayList<Integer> tmpIndexs=searchByName(list);
		if(tmpIndexs!=null) {
			Integer selectedIndex = printIndexsNumber(list, tmpIndexs);
			if(selectedIndex!=null) {
				list.get(selectedIndex).print();
				
			}else {
				System.out.println("선택한 값이 없습니다.");
			}
		}else {
			System.out.println("검색 결과가 없습니다.");
			}
		}
	private static ArrayList<Integer> searchByName(ArrayList<PhoneBook> list) {
		scan.nextLine();
		System.out.println("이름 : ");
		String name = scan.nextLine();
		// 이름이 포함된 전화번호부 검색하여 번지를 확인
		ArrayList<Integer> indexs = searchPhoneBook(list, p->p.getName().contains(name));
		// 확인된 번지의 번호들을 출력
		if(indexs ==null || indexs.size()==0||list == null|| list.size() == 0) {
			return null;
		}
		return indexs;
	}
		
	private static Integer printIndexsNumber(ArrayList<PhoneBook> list, ArrayList<Integer> indexs) {	
		for(int i = 0; i< indexs.size(); i++) {
			int index = indexs.get(i);
			System.out.println(i+1 +". " + list.get(index));
		}
		System.out.println("번호 선택 : ");
		int selectedIndex = scan.nextInt() -1;
		if(selectedIndex <0 || selectedIndex >=indexs.size()) {
			return null;
		}
		return selectedIndex;
	}
	
	private static boolean deletePhoneBook(ArrayList<PhoneBook> list) {
		// 이름을 입력
		scan.nextLine();
		System.out.println("이름 : ");
		String name = scan.nextLine();
		// 이름이 포함된 전화번호부 검색하여 번지를 확인
		ArrayList<Integer> indexs = searchPhoneBook(list, p->p.getName().contains(name));
		// 확인된 번지의 번호들을 출력
		if(indexs ==null || indexs.size()==0) {
			return false;
		}
		Integer selectedIndex = printIndexsNumber(list, indexs);
		int deleteIndex = indexs.get(selectedIndex);
		// 삭제할 전화번호부 선택
		
		// 전화번호부 삭제
		
		return list.remove(deleteIndex) !=null;
		}
	
	private static ArrayList<Integer> searchPhoneBook(ArrayList<PhoneBook> list, 
			Predicate<PhoneBook> p) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		for(int i = 0; i<list.size(); i++) {
			if(p.test(list.get(i))) {
				indexs.add(i);
				// list.get(i)에 하나씩 넣어서 test한 결과가 참이면 indexs에 add
			}
		}
		return indexs;
	}
	private static boolean insertPhoneBook(ArrayList<PhoneBook> list) {
		// 성명, 직장 입력
		scan.nextLine(); // 공백처리( 메뉴 입력 후 남은 엔터)
		System.out.print("성명 : ");
		String name = scan.nextLine();
		System.out.print("직장 : ");
		String company = scan.nextLine();
		
		ArrayList<PhoneNumber> pnList;
		try {
			pnList = inputPhoneNumbers();
		}catch(RuntimeException e) {
			return false;
		}
		// XXX을 이용하여 PhoneBook 객체를 생성
		//이름, 직장, ArrayList<PhoneNumber> 
		// 반복
					
				// 전화번호를 입력(이름 : 번호) => PhoneNumber
				// 전화번호를 더 입력할 건지 물어봄
					
			// 전화번호부에 추가 => PhoneBook 개체를 생성
		
		PhoneBook tmpPB = new PhoneBook(name, company, pnList);
		list.add(tmpPB);
			return true;
		
		
		}
	
	
	private static ArrayList<PhoneNumber> inputPhoneNumbers(){
		ArrayList<PhoneNumber> pnList = new ArrayList<PhoneNumber>();
		char yN;
		do {
			PhoneNumber pn = inputPhoneNumber();
			pnList.add(pn);
						
			System.out.println(pnList);
			
			// 입력받은 정보를 토대로 PhoneNumber객체 만들고, PhoneNumber리스트에 추가
			
			System.out.println("더 입력 하시겠습니까? Y/N");
			yN = scan.nextLine().charAt(0); 
		}while(yN!='n'&&yN!='N');
		
		return pnList;
	}
	
	private static PhoneNumber inputPhoneNumber() {
		System.out.print("연락처 명(집, 직장 등): ");
		String pName = scan.nextLine();
		System.out.print("번호(010-1234-4567) : ");
		String number = scan.nextLine();
		
		return new PhoneNumber(pName, number);
	}
	private static int selectMenu(int min, int max) throws RuntimeException {
		int tmp = scan.nextInt();
		if(tmp<min-1||tmp>max+1) {
			throw new RuntimeException("범위를 벗어난 값입니다.");
		}
				
		return tmp;
	}

	private static void printMenu() {
		System.out.println("--전화번호 관리 프로그램--");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
	}
	

	

}
