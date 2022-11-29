package day27;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class ClientManager implements Serializable{
	private ArrayList<Client> clientList = new ArrayList<Client>();
	{
		clientList.add(new MasterClient("master", "master"));
	}
	
	class MasterClient extends Client implements Masterable{

		public MasterClient(String id, String pw) {
			super(id, pw);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public Client login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디를 입력해주십시오");
		String id = scan.next();
		Client idFound = null;
		for(Client tmp : clientList) {
			if(tmp.getId().equals(id)) {
				idFound = tmp;
				break;
			}
		}
		if(idFound==null) {
			System.out.println("아이디를 찾을 수 없습니다.");
			return null;
		}else {
			System.out.println("비밀번호를 입력해주세요.");
			String pw = scan.next();
			if(!idFound.getPw().equals(pw)) {
					System.out.println("비밀번호를 찾을 수 없습니다.");
					return null;
				}else {
					System.out.println("로그인 완료");
					return idFound;
				}
		}
		
	}
	
	public Client join() {
		System.out.println("회원가입합니다.");
		System.out.println("사용할 아이디를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		String id = scan.next();
		String regex = "[\\w]{6,15}";
		if(!java.util.regex.Pattern.matches(regex, id)) {
			System.out.println("아이디는 6~15자의 영어, 숫자만 가능합니다.");
			return null;
		};
		for(Client tmp : clientList) {
			if(tmp.getId().equals(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				return null;
			}
		}
		System.out.println("비밀번호를 입력해주십시오.");
		String pw = scan.next();
		if(!java.util.regex.Pattern.matches(regex, pw)) {
			System.out.println("비밀번호는 6~15자의 영어, 숫자만 가능합니다.");
			return null;
		};
		
		System.out.println("회원가입이 완료되었습니다.");
		Client tmp = new Client(id, pw);
		clientList.add(tmp);
		return tmp;
		
	}
	
	
	
}
