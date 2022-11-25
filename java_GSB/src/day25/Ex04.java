package day25;

import java.util.Random;
import java.util.Scanner;

import lombok.Data;

public class Ex04 {
	private static Scanner scan = new Scanner(System.in);
	/*
	 * 컴퓨터와 가위 바위 보를 하는 프로그램을 작성하세요.
	 */
	public static void main(String[] args) {
		char cnt = 'Y';
		Rsp myRsp;
		do {
			System.out.println("가위 바위 보 게임 시작");
			
			System.out.println("안내면 진거 가위 바위 보");
			String myRSPstr = scan.next();
			myRsp = new Rsp(myRSPstr);
			
			myRsp.beat();
			System.out.println("컴퓨터 : "+ myRsp.getString(myRsp.getComRsp()));
			
			System.out.println("계속 플레이 하시겠습니까? Y/N");
			cnt = scan.next().toUpperCase().charAt(0);
		}while(cnt!='N');
		System.out.println("게임을 종료합니다.");
		
	}
	
	
	
	
	
}
@Data
class Rsp {
	private String state;
	private int num;
	private int comRsp;
	
	Rsp(String str){
		this.num = getMyRSP(str);
		this.state = str;
		this.comRsp = setComRsp();
	}
	
	public int setComRsp() {
		Random r = new Random();
		return r.nextInt(2);
		
	}
	
	public int getMyRSP(String str) {
		switch(str) {
		case "가위":	return 0;
		case "바위": return 1;
		case "보": return 2;
			default: return 4;
		}
		
	}
	
	 
	public String getString(int num) {
		switch(num) {
		case 0:	return "가위";
		case 1: return "바위";
		case 2: return "보";
			default: return "";
		}
	}
	
	
	
	
	public void beat() {
		if(this.num-this.comRsp==0) {
			System.out.println("무승부");
			//return 0;
		}else if(this.num-this.comRsp==1) {
			System.out.println("이겼다");
			//return 1;
		}else if(this.num-this.comRsp==-1) {
			System.out.println("졌다");
			//return -1;
		}else if(this.num-this.comRsp==2) {
			System.out.println("졌다");
			//return -1;
		}else if(this.num-this.comRsp==-2) {
			System.out.println("이겼다");
			//return 1;
		}	
	}
	
	
	
	
}





enum enumRsp{ 가위(0), 바위(1), 보(2);
	
	private final int RSP;
	
enumRsp(int rsp) {
	this.RSP= rsp;
}

}