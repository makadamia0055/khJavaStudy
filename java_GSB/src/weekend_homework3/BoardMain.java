package weekend_homework3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BoardMain {
	private static Scanner scan = new Scanner(System.in);
	private static Client user = new Client();
	public static void main(String[] args) {
		//게시글 종류는 자유, 공지는 기본
		// 게시글 종류는 추가 가능
		// 게시글을 회원만 작성 가능
		// 회원 가입, 로그인 기능 필요
		// 비회원은 작성, 수정 불가능, 조회 가능
		// 회원 정보와 게시글을 파일에 저장하여 관리
		
		// client 회원 가입 여부 인터페이스로 구현 인터페이스 있으면 작성, 수정 가능하게 하는 식으로
		// 로그인 아이디 제한 정규식
		// 게시글 종류 enum으로 제한
		
		
		//로드//각각 게시글, 회원 따로 저장&로드해야할듯
		MemberManager memberM = (MemberManager)load("memberM");
		if(memberM==null) {
			memberM = new MemberManager();
		}
		PostManager postM = (PostManager)load("postM");
		if(postM==null) {
			postM = new PostManager();
		}
		int menu = -1;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu, postM, memberM);
		}while(menu!=3);
		
	}
	private static void runMenu(int menu, PostManager postM, MemberManager memberM) {
		switch(menu) {
		
		case 1: System.out.println("1. 게시판 접속");
		postM.run(user);
		break;
		case 2: 
			if(!Client.checkVerified(user)) 
			{
			System.out.println("2. 로그인 및 회원가입");
			Client rstuser = memberM.run(user);
			setUser(rstuser);
			}else {
				System.out.println("2. 로그아웃");
				Client logout = new Client();
				setUser(logout);
			}
			
				break;
		case 3: 
			System.out.println("3. 프로그램 종료합니다.");
			System.out.println("저장중입니다.");
			save(memberM, "memberM");
			save(postM, "postM");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("저장이 완료되었습니다.");
			
			
			
			break;
		default:
		}
		
	}
	private static void save(Object obj, String str) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str+".txt"))) {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Object load(String str){
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str+".txt"))) {
			System.out.println( " "+str+ " 불러오기 완료");
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
		
		
	}
	
	public static void setUser(Client user2) {
		user = user2;
	}
	private static void printMenu() {
		System.out.println("=======천리안=======");
		System.out.println("1. 게시판 접속");
		if(!Client.checkVerified(user)) 
		{
		System.out.println("2. 로그인 및 회원가입");
		}else {
			System.out.println("2. 로그아웃");
		}
		System.out.println("3. 프로그램 종료");
		System.out.println("=================");

		
	}

}
