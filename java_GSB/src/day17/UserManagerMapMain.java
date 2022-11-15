package day17;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import day16.UserManagerServiceImp;

public class UserManagerMapMain {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		//
		day16.UserManagerService UMS = new day16.UserManagerServiceImp();
		HashMap<String, Member> map = new HashMap<String, Member>();
		
		//
		int menu =-1;
		
		do {
			try {
			UMS.printMenu("1. 회원 추가\n"
					+ "2. 회원 검색\n"
					+ "3. 회원 정보 수정\n"
					+ "4. 회원 삭제\n"
					+ "5. 프로그램 종료\n");
			menu = UMS.selectMenu(scan, 1, 5);
			}catch(InputMismatchException e) {
				System.out.println("입력 오류 발생");
				scan.nextLine();
			}
			switch(menu) {
			case 1:
				System.out.println("등록할 아이디를 입력해주세요.");
				runCase1(map);
				System.out.println("성공적으로 계정이 추가되었습니다.");

				break;
			case 2:
				boolean tmpBoolean  = runCase2(map);
				
				break;
				
			case 3:
				tmpBoolean = runCase3(map);
				if(tmpBoolean) {
					System.out.println("성공적으로 계정이 수정되었습니다.");
				}

				break;
				
			case 4:
				tmpBoolean = runCase4(map);
				if(tmpBoolean) {
					System.out.println("해당 회원 정보 삭제를 정상적으로 수행하였습니다.");
				}

				break;
				
			case 5: 
				
				break;
				default : 
			}
			
		}while(menu!=5);
		
		
	}

	private static boolean runCase4(HashMap<String, Member> map) {
		String tmpdeleteID = findUser(map);
		if(tmpdeleteID !=null) {
			System.out.println("정말 "+tmpdeleteID+"유저를 삭제하시겠습니까? Y/N");
			char tmpdc = scan.next().charAt(0);
			if(tmpdc=='y'||tmpdc=='Y') {
				map.remove(tmpdeleteID);
				return true;
			}else if(tmpdc=='n'||tmpdc=='N') {
				System.out.println("삭제작업을 취소하고 초기화면으로 돌아갑니다.");
				return false;
			}else {
				System.out.println("잘못된 입력입니다. 초기화면으로 돌아갑니다.");
				return false;
			}
		}else {
			System.out.println("해당 회원이 존재하지 않으므로 초기화면으로 돌아갑니다.");
			return false;
		}		
	}

	private static boolean runCase3(HashMap<String, Member> map) {
		System.out.println("수정할 유저의 ID를 입력하십시오.");
		String tmpId = findUser(map);
		if(tmpId!=null) {
			System.out.println("해당 ID의 비밀번호를 입력하십시오.");
			boolean booleanverifyPw = verifyPw(map, tmpId);
			if(booleanverifyPw) {
				System.out.println(tmpId+"회원의 정보를 수정합니다.");
				runCase1(map, tmpId);
				return true;
			}else {
				System.out.println("비밀번호 인증에 실패하였습니다.");
				return false;

			}
		}else {
			System.out.println("해당 회원이 존재하지 않으므로 초기화면으로 돌아갑니다.");
			return false;

		}
	}

	private static boolean runCase2(HashMap<String, Member> map) {
		String tmpId = findUser(map);
		if(tmpId!=null) {
			boolean booleanverfyPw = verifyPw(map, tmpId);
							
			if(booleanverfyPw) {
				System.out.println(tmpId+"의 정보 출력합니다.");
				System.out.println(tmpId+ map.get(tmpId));
				return true;
			}else {
				System.out.println(tmpId+ "의 비밀번호가 일치하지 않습니다.");
				return false;
			}
		}else {
			System.out.println("입력한 Id의 회원 정보가 없습니다.");
			return false;
		}
	}

	private static boolean verifyPw(HashMap<String, Member> map, String tmpId) {
		System.out.println(tmpId+"의 비밀번호를 입력해주십시오.");
		String tmpPw = scan.next();
		
		if(tmpPw.equals(map.get(tmpId).getPw())) {
			return true;
			
		}else {
			return false;
		}
	}

	private static String findUser(HashMap<String, Member> map) {
		String tmpId;
		System.out.println("검색할 아이디를 입력해주세요.");
		do {
			tmpId = scan.next();
			scan.nextLine();
			if(!map.containsKey(tmpId)) {
				System.out.println("아이디"+ tmpId+"는 등록되어 있지 않습니다.");
				return null;
			}else {
				System.out.println("아이디"+ tmpId+"가 존재합니다.");
				return tmpId;
				
			}
		}while(true);
		
	}

	private static void runCase1(HashMap<String, Member> map) {
		String tmpId;
		do {
			tmpId = scan.next();
			scan.nextLine();
			if(!map.containsKey(tmpId)) {
				System.out.println("아이디"+ tmpId+"는 등록되어 있지 않습니다.");
				break;
			}else {
				System.out.println("아이디"+ tmpId+"는 이미 등록되어 있습니다.\n다른 아이디를 입력해주세요.");
				
			}				
		}while(true);
		System.out.println(tmpId+"의 비밀번호를 입력해주십시오.");
		String tmpPw = scan.next();
		scan.nextLine();
		
		System.out.println(tmpId+"의 이용자 성명을 입력해주십시오.");
		String tmpName = scan.next();
		scan.nextLine();
		
		System.out.println(tmpId+"의 나이를 입력해주십시오.");
		int tmpAge = scan.nextInt();
		scan.nextLine();

		System.out.println(tmpId+"의 주민번호를 입력해주십시오.");
		String tmpSsn = scan.nextLine();
		
		
		map.put(tmpId, new Member(tmpPw, tmpName, tmpSsn, tmpAge));
		
	}
	
	private static void runCase1(HashMap<String, Member> map, String tmpId) {
		
		System.out.println(tmpId+"의 수정된 비밀번호를 입력해주십시오.");
		String tmpPw = scan.next();
		scan.nextLine();
		
		System.out.println(tmpId+"의 수정된 이용자 성명을 입력해주십시오.");
		String tmpName = scan.next();
		scan.nextLine();
		
		System.out.println(tmpId+"의 수정된 나이를 입력해주십시오.");
		int tmpAge = scan.nextInt();
		scan.nextLine();

		System.out.println(tmpId+"의 수정된 주민번호를 입력해주십시오.");
		String tmpSsn = scan.nextLine();
		
		
		map.put(tmpId, new Member(tmpPw, tmpName, tmpSsn, tmpAge));
		System.out.println("성공적으로 "+tmpId+" 계정이 수정되었습니다.");
		
	}


}
