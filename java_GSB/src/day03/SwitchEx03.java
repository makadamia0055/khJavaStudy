package day03;

public class SwitchEx03 {
	public static void main(String[] args) {
		char ch = '+';
		
		switch(ch) {
		case '+', '-', '*', '/', '%':
			System.out.println("산술연산자입니다.");
			break;
		
		default: 
			System.out.println("산술연산자아닙니다.");
		
		
		}
	}

}
