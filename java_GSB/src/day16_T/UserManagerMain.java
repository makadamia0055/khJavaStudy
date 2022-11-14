package day16_T;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagerMain {

	public static void main(String[] args) {
		/*회원 정보를 관리하는 프로그램을 작성하세요
		 *  - 회원 정보는 아이디, 비번, 이름, 주민번호, 나이 로 구성되어 있다.
		 *  기능 1 회원 추가
		 *  기능 2 회원 검색
		 *  기능 3 회원 정보 수정
		 *  기능 4 회원 삭제
		 * */ 
		int menu = -1;
		ArrayList<Member1> list = new ArrayList<Member1>(); 
		Scanner scan = new Scanner(System.in);
		do {
			printMenu();
			
			menu = scan.nextInt();
			switch(menu) {
			case 1: 
				// 회원 정보 입력
				// 아이디, 비번, 이름, 주민, 나이 순으로
				addList();
				// 입력한 정보를 이용한 객체를 생성(회원 리스트에 비교 및 추가)
				
				// 회원 리스트에 이미 가입된 아이디면 안내문구 출력 후 종료
				// 회원 아이디가 같은 회원이 있으면
				// 아니면 회원 리스트에 추가 
				
				break;
			case 2: 
				// 아이디 입력
				Member1 searchtmp = searchMember(list);
				if(searchtmp==null) {
					System.out.println("아이디 또는 비밀번호가 잘못됐습니다.");
				}
				break;
			case 3:
				System.out.println("수정 예정");
				break;
			case 4:
				//삭제할 회원 아이디와 비번을 입력하여 일치하는 회원 정보를 가져옴.
				Member1 deleteTmp = searchMember(list);
				if(list.remove(deleteTmp)) {// 객체 넣은 remove의 경우 boolean값 리턴
					System.out.println("삭제가 완료되었습니다.");
				}else {
					System.out.println("일치하는 회원 정보가 없습니다.");
				}
				
				
				break;
			case 5: 
				System.out.println("프로그램 종료");
				break;
				default:
			}
		}while(menu!=5);
		
		

	}
	private static void addList() {
		Scanner scan=new Scanner(System.in);
		System.out.println("회원 정보를 입력하세요.");
		System.out.println("아이디 : ");
		String id = scan.next();
		scan.nextLine();
		
		System.out.println("비번 : ");
		String pw = scan.next();
		scan.nextLine();
		
		System.out.println("이름 : ");
		String name = scan.next();
		scan.nextLine();
		
		System.out.println("주민번호 : ");
		String residentNumber = scan.next();
		scan.nextLine();
		
		System.out.println("나이 : ");
		int age = scan.nextInt();
		scan.nextLine();
		
		Member1 member = new Member1(id, pw, name, residentNumber, age);
	}
	public static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제 ");
		System.out.println("5. 프로그램 종료 ");
		System.out.println("-----------------");
		System.out.println("메뉴 선택 : ");
		
	}
	public static Member1 searchMember(ArrayList<Member1> list) {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.println("아이디 : ");
		String id = scan.next();
		scan.nextLine();
		// 비번 입력
		System.out.println("비번 : ");
		String pw = scan.next();
		scan.nextLine();
		
		// 아이디, 비번을 이용하여 객체를 만듦
		Member1 member = new Member1(id, pw);
		// 회원 리스트에서 아이디가 같은 회원 정보를 가져옴
		int index = list.indexOf(member);
		if(index ==-1) {
			return null;
		}
		Member1 tmp = list.get(index);
		if(!tmp.getPw().equals(member.getPw())) {
			return null;		
		}
		
		System.out.println(tmp);
		// 가져온 회원 정보의 비번과 입력한 비번을 비교하여 같으면 회원정보를 보여줌.
		
		
		
		return tmp;
	}
	
}
