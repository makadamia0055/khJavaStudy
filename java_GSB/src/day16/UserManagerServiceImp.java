package day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserManagerServiceImp implements UserManagerService {

	@Override
	public void printMenu(String str) {
		System.out.println("메뉴");
		System.out.println(str);
		System.out.print("메뉴선택 : ");

	}

	@Override
	public int selectMenu(Scanner scan, int min, int max) {
			int tmp = 0;
			
			do {
			 tmp = scan.nextInt();
			 scan.nextLine();
			 if(tmp>=min&&tmp<=max) {
				 return tmp;
			 }else {
				 throw new InputMismatchException();
			 }
			}while(true);
			
		}
		
	

	@Override
	/* 회원 정보를 관리하는 프로그램을 작성하세요.
	 * -회원 정보는 아이디, 비번, 이름, 나이, 주민번호로 구성
	 * -기능 1 : 회원 추가
	 * -기능 2 : 회원 검색
	 * -기능 3 : 회원정보 수정
	 * -기능 4 : 회원 삭제
	 * */

	public void runMenu(int menu, UserProfiler UP, Scanner scan) {
		String tmpId;
		switch(menu) {
		case 1: 
			System.out.println("회원을 추가합니다.");
			System.out.println("추가할 아이디를 입력해주십시오");
			runCase1(UP, scan);
			
			break;
		case 2:
			System.out.println("회원을 검색합니다.");
			System.out.println("검색할 회원의 ID를 입력하십시오.");
			
			
			tmpId = scan.next();
			scan.nextLine();
			if(UP.findUser(tmpId)!=null) {
				UP.printInfo(tmpId);
				
			}else {
				System.out.println("아이디"+ tmpId+"는 등록되어 있지 않습니다.");
				break;
			}	
			
			break;
		case 3: 
			System.out.println("회원 정보를 수정합니다.");
			System.out.println("수정할 회원의 ID를 입력하십시오.");
			
			
			tmpId = scan.next();
			scan.nextLine();
			if(UP.findUser(tmpId)!=null) {
				
			}else {
				System.out.println("아이디"+ tmpId+"는 등록되어 있지 않습니다.");
				break;
			}	
			System.out.println("수정할 계정의 비밀번호를 입력하십시오");
			if(UP.verifyPw(tmpId)) {
				System.out.println(tmpId+"계정을 수정합니다.");
				UP.getUserMap().remove(tmpId);
				runCase1(UP, scan, tmpId);
				System.out.println("회원 정보 수정이 완료되었습니다.");
				
			}else {
				System.out.println("비밀번호가 틀렸습니다.\n초기화면으로 넘어갑니다.");
				break;
			}
			
			break;
		case 4 : 
			System.out.println("회원 정보를 삭제합니다.");
			System.out.println("삭제할 회원의 ID를 입력하십시오.");
			
			
			tmpId = scan.next();
			scan.nextLine();
			if(UP.findUser(tmpId)==null) {
				System.out.println("아이디"+ tmpId+"는 등록되어 있지 않습니다.");
				break;
			}	
			
			System.out.println("삭제할 계정의 비밀번호를 입력하십시오");
			
			if(UP.verifyPw(tmpId)) {
				System.out.println(tmpId+"계정을 삭제합니다.");
				UP.getUserMap().remove(tmpId);
				System.out.println("회원 계정 삭제가 완료되었습니다.");
				
			}else {
				System.out.println("비밀번호가 틀렸습니다.\n초기화면으로 넘어갑니다.");
				break;
			}
			break;
		
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
			default:
		}
	}

	private void runCase1(UserProfiler UP, Scanner scan) {
		String tmpId;
		do {
			tmpId = scan.next();
			scan.nextLine();
			if(UP.findUser(tmpId)==null) {
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
		
		UP.addProfile(tmpId, tmpPw, tmpName, tmpAge, tmpSsn);
		System.out.println("성공적으로 "+tmpId+" 계정이 추가되었습니다.");
		
		
	}
	/**
	 * runCase1을 수정용으로 오버로딩한 것
	 * @param UP
	 * @param scan
	 * @param tmpId
	 */
	private void runCase1(UserProfiler UP, Scanner scan, String tmpId) {
		
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
		
		UP.addProfile(tmpId, tmpPw, tmpName, tmpAge, tmpSsn);
		System.out.println("성공적으로 "+tmpId+" 계정이 수정되었습니다.");
		
		
	}

	
	
	

}
