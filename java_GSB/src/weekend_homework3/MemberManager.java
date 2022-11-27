package weekend_homework3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3617233085084464456L;
	private ArrayList<Member> memberList = new ArrayList<Member>();

	
	
	public void printMenu() {
		printbar();
		System.out.println("	1. 로그인");
		System.out.println("	2. 회원 가입");
		System.out.println("	3. 취소 및 뒤로가기");
	}
	
	private void printbar() {
		System.out.println("--------------------------");
	}

	public Client run(Client client) {
		if(Client.checkVerified(client)) {
			System.out.println("이미 가입한 회원을 위한 메뉴는 아직 준비되어있지 않습니다.");
			return client;
		}
		Scanner scan = new Scanner(System.in);
		int menu = -1;
		do {
			printMenu();
			menu = scan.nextInt();
			client = runMenu(menu, client);
			System.out.println("client 의 상태"+ client);
			if(Client.checkVerified(client)) {
				return client;
			}
		}while(menu!=3);
		return client;
	}

	private Client runMenu(int menu, Client client) {
		switch(menu) {
		case 1:
			System.out.println("로그인");
			System.out.println("아이디를 입력해주십시오.");
			Scanner scan = new Scanner(System.in);
			String id = scan.next();
			int index = -1;
			for(Member tmp : memberList) {
				if(tmp.getId().equals(id)) {
					index =memberList.indexOf(tmp);
					break;
				}
			}
			if(index==-1) {
				System.out.println("해당 아이디가 존재하지 않습니다.");
				return client;
			}else {
				System.out.println("비밀번호를 입력해주십시오.");
				String pw = scan.next();
				if(memberList.get(index).getPw().equals(pw)) {
					System.out.println("로그인 완료");
					return memberList.get(index);
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
			return client;
		
		case 2: 
		System.out.println("회원가입 메뉴입니다.");
		Member tmp = new Member(memberList);
		if(tmp!=null) {
			System.out.println("회원가입이 완료되었습니다.");
			memberList.add(tmp);
			return tmp;
		}
		
		case 3: 
			return client;
		default:  return client;

		}
		
	}
	
	
	
	
}
