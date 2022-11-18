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
			printMenu();
			menu = selectMenu(1, 5);
			switch(menu) {
			
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
				System.out.println("검색할 이름을 입력하세요.");
				scan.nextLine();
				String tmpFullName = scan.nextLine();
				
				int count=0;
				ArrayList<Profile> searchList = new ArrayList<Profile>();
				for(Profile tmp :list) {
					if(tmp.getFullName().contains(tmpFullName)) {
						searchList.add(tmp);
						count++;
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
					break;
				}
				
				
				
				// 이름이 포함된 전화번호부를 검색하여 출력 번호와 함께
				
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
					modProfile=addProfile(list, modProfile);
					list.add(modProfile);
					System.out.println("기본 신상 수정이 끝났습니다.");
					break;
					
				case 2:// 기존 전화번호 수정
					//기존 전화번호 찾기
					
					count = 0;
					for(PhoneNumber tmp : modProfile.getNumberList()) {
						System.out.printf("%d번: %s %s", count+1, tmp.getNumbername(), tmp.getNumber());
						count++;
					}
					
					
					if(modProfile.getNumberList().size()!=0) {
						for(int i =0; i<modProfile.getNumberList().size();i++) {
							System.out.printf("%d번 %s : %s\n", i+1, modProfile.getNumberList().get(i).getNumbername(), modProfile.getNumberList().get(i).getNumber()  );
							
						}
					}else {
						System.out.println("해당 검색 결과가 없습니다.");
						break;
					}
					
					System.out.println("수정할 번호를 선택해주십시오.");
					modNum = selectMenu(1, searchList.size()+1) -1;
					PhoneNumber modPhoneNum = modProfile.getNumberList().get(modNum);
					
					//메소드에서 긁어옴.
					System.out.println("--------------");
					System.out.println("저장명 :");
					String tmpNumberName = scan.nextLine();
					System.out.println("번호: ");
					System.out.println("--------------");

					String tmpNumber = scan.nextLine();
					PhoneNumber tmpPhoneNumber = new PhoneNumber(tmpNumberName, tmpNumber);
					
					//여기까지.
					 modProfile.getNumberList().remove(modPhoneNum);
					 modProfile.getNumberList().add(tmpPhoneNumber);
					 Collections.sort(modProfile.getNumberList());
					System.out.println("기존 번호 수정이 완료되었습니다.");
					
					break;
					
				case 3:
					break;
				
				
				}
				
				
				
				
				// 검색 메소드-리턴 검색된 어레이
				// 검색 메소드 출력해서 선택 가능하게 하는 메소드 -번호 스캔해서 선택 개체 리턴
				// 선택 메소드 -검색된 어레이 받고, 선택값 받아서 
				
				
				
				
				
				// 수정할 번호부를 선택
				
				break;
			case 3: 
				break;
			case 4:
				//일단 풀조회 구현
				for(Profile tmp : list) {
					System.out.println(tmp);
				}
				
				
				//이름을 입력
				// 이름이 포함된 전화번호부를 검색해서 출력(번호와 함께)
				// 조회할 전화번호부를 선택
				// 전화번호 조회
				break;
			case 5:
				break;
				default:
			}
		}while(menu!=5);
		
		scan.close();
		
		
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
				System.out.println("--------------");
				System.out.println("저장명 :");
				String tmpNumberName = scan.nextLine();
				System.out.println("번호: ");
				System.out.println("--------------");

				String tmpNumber = scan.nextLine();
				PhoneNumber tmpPhoneNumber = new PhoneNumber(tmpNumberName, tmpNumber);
				if(!tmpProfile.getNumberList().contains(tmpPhoneNumber)) {
					tmpProfile.getNumberList().add(tmpPhoneNumber);
					count++;
					tmpProfile.sortNumberList();
				}else {
					System.out.println("이미 저장된 번호입니다.");
					
				}
			}
			
		}while(subMenu!=2);
		
	}

	private static Profile addProfile(ArrayList<Profile> list, Profile modProfile) {
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
		Profile tmpProfile = new Profile(sung, name, job);
		
		list.remove(modProfile);
		return tmpProfile;
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
	
	
	

	private static int selectMenu(int min, int max) {
		int tmp = scan.nextInt();
		if(tmp<min-1||tmp>max+1) {
			//예외처리
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
