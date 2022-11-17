package day19;

public class ChainingEx01 {

	public static void main(String[] args) {
		/* 메소드 뒤에 메소드가 .으로 나타나는 형태 
		 * 앞에 있는 메소드 리턴 값에 이어서 메소드를 호출*/
		
		String str = "hello";
		System.out.println(str.substring(2).charAt(0));
		//String은 체이닝 형식으로 형성되어 있어서 계속해서 .연산자를 이용해
		//연속해서 메소드를 불러낼 수 있다.
		System.out.println(1);
		System.out.println(toString(1).charAt(0));
		// 그냥 1 뒤에는 .을 붙여도 메소드가 안나옴.
		// 근데 toString의 결과로 문자열 '객체'가 되어서 .으로 메소드 호출 가능
		print(10);
		
		
	}
	
	public static String toString(int num) {
		return num + "";
	}
	
	public static void print(int num) {
		System.out.println(num);
	}

}
