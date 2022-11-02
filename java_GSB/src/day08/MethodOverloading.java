package day08;

public class MethodOverloading {

	public static void main(String[] args) {
		/*
		 * 메소드 오버로딩: 동일한 이름을 가진 메소드가 여러개 있는 것
		 *	-매개변수의 개수 혹은 매개변수의 타입이 다르면 가능
		 * 
		 그동한 사용한 메소드 오버로딩의 예시
		System.out.println(1);
		System.out.println("1");
		System.out.println(1.0f);
		System.out.println(1.0);
		System.out.println('1');
		System.out.println();
		*/
	
	
	System.out.println(sum(1, 2));
	System.out.println(sum(1, 2, 3));
	System.out.println(sum(1.2, 2.1));
	
	
	
	
	
	}
	public static int sum(int num1, int num2) {
		return num1+num2;
	}
	// 매개변수의 개수가 달라서 메소드 오버로딩이 가능
	public static int sum(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	// 매개변수의 자료형이 달라서 메소드 오버로딩이 가능
	public static double sum(double num1, double num2) {
		return num1+num2;
	}
	// 리턴타입은 메소드 오버로딩과 상관이 없음. => 에러 발생
	/*public static double sum(int num1, int num2) {
		return num1+num2;
	}*/
	
	
	
	

}
