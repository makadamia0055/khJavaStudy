package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
		ArrayList<Profile> list = new ArrayList<Profile>(); 
		int menu =-1;
		
		do {
			try {
			printMenu();
			menu = selectMenu(1, 5);
			runMenu(list, menu);
			}catch(Exception e) {
				
			}
		}while(menu!=5);
		
		scan.close();
		
		
	}
	public static void runMenu(ArrayList<Profile> list, int menu) throws Exception {
		switch(menu){
	case 1:
		System.out.println("→ 전화번호 추가");
		Profile tmpProfile = addProfile(list);
		list.add(tmpProfile);

		System.out.println(tmpProfile.getFullName()+"씨의 전화번호를 입력합니다.");
		
		addPhoneNumber(tmpProfile);
		
		System.out.println("전화번호 추가가 완료되었습니다.");
		
		break;
	case 2:
		// 이름 입력
		System.out.println("전화번호부를 수정합니다.");
		
		//이름으로 검색 시작
		// 이름이 포함된 전화번호부를 검색하여 출력 번호와 함께
		
		ArrayList<Profile> searchList = searchByName(list);
		
		// 검색 끝			
		
		//수정번호 출력 및 선택
		
		System.out.println("수정할 번호를 선택해주십시오.");
		int modNum = selectMenu(1, searchList.size()+1) -1;
		
		Profile modProfile = list.get(modNum);
		
		
		System.out.println(modProfile.getFullName()+"님에 대한 수정사항을 선택하십시오.");
		System.out.println("1. 기본 신상 수정\n"
				+ "2. 기존 전화번호 수정\n"
				+ "3. 새로운 전화번호 추가\n");
		//1. 이름, 직장 수정(기본 신상 수정)
		//2. 기존 전화번호 (수정)
		//3. 새로운 전화번호 추가
		
		int subMenu = selectMenu(1, 3);
		switch(subMenu) {
		case 1:
			editProfile(list, modProfile);
			System.out.println("기본 신상 수정이 끝났습니다.");
			break;
			
		case 2:// 기존 전화번호 수정
			//기존 전화번호 찾기
			
		
			
			
			if(modProfile.getNumberList().size()!=0) {
				for(int i =0; i<modProfile.getNumberList().size();i++) {
					System.out.printf("%d번 %s : %s\n", i+1, modProfile.getNumberList().get(i).getNumbername(), modProfile.getNumberList().get(i).getNumber());
					
				}
			}else {
				System.out.println("해당 검색 결과가 없습니다.");
				break;
			}
			
			System.out.println("수정할 번호를 선택해주십시오.");
			modNum = selectMenu(1, searchList.size()+1) -1;
			PhoneNumber modPhoneNum = modProfile.getNumberList().get(modNum);
			scan.nextLine();
			//메소드에서 긁어옴.
			modProfile.getNumberList().remove(modPhoneNum);
			boolean tmpTF = checkPhoneNum(modProfile, modPhoneNum);
			if(tmpTF) {
				//여기까지.
				Collections.sort(modProfile.getNumberList());
				System.out.println("기존 번호 수정이 완료되었습니다.");
			}else {
				System.out.println("오류 발생. 기존 번호를 복구합니다.");
				modProfile.getNumberList().add(modPhoneNum);
			}
			
			break;
			
		case 3:
			addPhoneNumber(modProfile);
			System.out.println("새 전화번호가 성공적으로 저장되었습니다.");
			break;
		
		
		}
						
		// 검색 메소드-리턴 검색된 어레이
		// 검색 메소드 출력해서 선택 가능하게 하는 메소드 -번호 스캔해서 선택 개체 리턴
		// 선택 메소드 -검색된 어레이 받고, 선택값 받아서 
		
		
		
		// 수정할 번호부를 선택
		
		break;
	case 3: //번호 삭제
		
		searchList = searchByName(list);
		
		System.out.println("수정할 번호를 선택해주십시오.");
		modNum = selectMenu(1, searchList.size()+1) -1;
		
		modProfile = list.get(modNum);
		
		System.out.print("정말 "+modProfile.getFullName()+"님의 연락처를 삭제하시겠습니까? Y/N :");
		char tmpYN = scan.next().charAt(0);
		if(tmpYN=='y'||tmpYN=='Y') {
			list.remove(modProfile);
			System.out.println("해당 연락처가 성공적으로 제거되었습니다.");
		}else if(tmpYN=='N'||tmpYN=='n') {
			System.out.println("취소하고 초기메뉴로 돌아갑니다.");
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		
		
		break;
	case 4:
		//일단 풀조회 구현
		System.out.println("전화번호 조회\n"
				+ "1. 전체 조회\n"
				+ "2. 이름 검색 조회\n");
		
		subMenu = selectMenu(1, 2); 
		
		switch(subMenu) {
		case 1:
			System.out.println("전체 연락처 출력");
			System.out.println("------------");
			for(Profile tmp : list) {
				System.out.println(tmp);
			}
			
			break;
		case 2:
			searchList = searchByName(list);
			
			System.out.println("열람할 연락처의 번호를 선택해주십시오.");
			modNum = selectMenu(1, searchList.size()+1) -1;
			
			modProfile = list.get(modNum);
			
			System.out.println("연락처 상세 열람");
			System.out.println("-------------------------------");

			System.out.printf("성 : %s \n이름: %s\n", modProfile.getSung(), modProfile.getName());
			System.out.printf("직업/업무처 : %s\n", modProfile.getJob());
			
			int count = 1;
			for(PhoneNumber tmp : modProfile.getNumberList()) {
				System.out.printf("%d번 연락처\t저장명 : %s\t번호 : %s\n", count, tmp.getNumbername(), tmp.getNumber());
			}
			System.out.println("-------------------------------");
			
			break;
		}
		
		//이름을 입력
		// 이름이 포함된 전화번호부를 검색해서 출력(번호와 함께)
		// 조회할 전화번호부를 선택
		// 전화번호 조회
		break;
	case 5:
		System.out.println("프로그램을 종료합니다.");
		break;
		
	default:
	
	
	}
	}

	private static ArrayList<Profile> searchByName(ArrayList<Profile> list) {
		System.out.println("검색할 이름을 입력하세요.");
		scan.nextLine();
		String tmpFullName = scan.nextLine();
		
		ArrayList<Profile> searchList = new ArrayList<Profile>();
		searchList.clear();
		for(Profile tmp :list) {
			if(tmp.getFullName().contains(tmpFullName)) {
				searchList.add(tmp);
			}
		}
		Collections.sort(searchList);
		// 이름으로 검색 끝
		
		//검색 결과 출력
		if(searchList.size()!=0) {
			for(int i =0; i<searchList.size();i++) {
				System.out.printf("%d번 %s님 전화번호 : %s\n", i+1, searchList.get(i).getFullName(), searchList.get(i).getNumberList().get(0)  );
				
			}
		}else {
			System.out.println("해당 검색 결과가 없습니다.");
			return null;
		}
		return searchList;
	}

	private static void addPhoneNumber(Profile tmpProfile) {
		int count = 0; // count로 입력 번호수 관리
		int subMenu = 0;
		do {
			if(count>0) {
				System.out.println("1. 새로운 번호 저장");
				System.out.println("2. 프로필 저장 종료하고 나가기");
				System.out.print("메뉴 선택 : ");
				subMenu = scan.nextInt();
				scan.nextLine();
			}
			if(subMenu!=2) {
				boolean tmpTF = checkPhoneNum(tmpProfile);
				if(tmpTF) {
					System.out.println("전화번호 추가가 완료되었습니다.");
					count++;
				}else {
					System.out.println("이미 저장된 번호입니다.");
				}
			}
			
		}while(subMenu!=2);
		
	}

	private static boolean checkPhoneNum(Profile tmpProfile) {
		System.out.println("--------------");
		System.out.println("저장명 :");
		String tmpNumberName = scan.nextLine();
		System.out.println("--------------");
		System.out.println("번호: ");
		String tmpNumber = scan.nextLine();

		PhoneNumber tmpPhoneNumber = new PhoneNumber(tmpNumberName, tmpNumber);
		if(!tmpProfile.getNumberList().contains(tmpPhoneNumber)) {
			tmpProfile.getNumberList().add(tmpPhoneNumber);
			tmpProfile.sortNumberList();
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean checkPhoneNum(Profile tmpProfile, PhoneNumber modPhoneNum) {
		System.out.println("--------------");
		System.out.print("저장명 변경\n기존 저장명 :  "+modPhoneNum.getNumbername()+" → : ");
		String tmpNumberName = scan.nextLine();
		System.out.println("\n--------------");
		System.out.print("번호 변경\n기존 번호 : "+modPhoneNum.getNumber()+" → : ");
		String tmpNumber = scan.nextLine();
		System.out.println();
		
		PhoneNumber tmpPhoneNumber = new PhoneNumber(tmpNumberName, tmpNumber);
		if(!tmpProfile.getNumberList().contains(tmpPhoneNumber)) {
			tmpProfile.getNumberList().add(tmpPhoneNumber);
			tmpProfile.sortNumberList();
			return true;
		}else {
			return false;
		}
	}

	private static void editProfile(ArrayList<Profile> list, Profile modProfile) {
		System.out.println("수정할 성을 입력하세요.");
		System.out.print(modProfile.getSung()+"→ : ");
		String sung = scan.next();
		
		System.out.println("수정할 이름을 입력하세요");
		System.out.print(modProfile.getName()+"→ : ");
		String name = scan.next();
		scan.nextLine();
		String fullName = sung.concat(name);
		System.out.println(fullName+"씨의 직장을 입력해주십시오.");
		System.out.print(modProfile.getJob()+"→ : ");

		String job = scan.nextLine();
		modProfile.setSung(sung);
		modProfile.setName(name);
		modProfile.setJob(job);

	}
	
	private static Profile addProfile(ArrayList<Profile> list) {
		System.out.println("연락처의 성을 입력하십시오.");
		String sung = scan.next();
		
		System.out.println("연락처의 이름을 입력하십시오");
		String name = scan.next();
		scan.nextLine();
		String fullName = sung.concat(name);
		System.out.println(fullName+"씨의 직장을 입력해주십시오.");
		String job = scan.nextLine();
		Profile tmpProfile = new Profile(sung, name, job);
		return tmpProfile;
	}
	
	
	

	private static int selectMenu(int min, int max) throws Exception {
		int tmp = scan.nextInt();
		if(tmp<min-1||tmp>max+1) {
			throw new Exception("범위를 벗어난 값입니다.");
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
