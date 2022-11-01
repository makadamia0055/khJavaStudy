package day07;

public class MethodEx04 {

	public static void main(String[] args) {
		int num = 10;
		printNum(num); 
		Test t = new Test();
		printTest(t);
		printNum(num); 
		printTest(t);


			
	}
	
	// main에 있는 num과 printNum에 있는 num은 이름은 같지만 서로 다른 변수.
	// 값을 복사해서 가져옴.
	// 매개변수가 기본 자료형인 경우, printNum에서 숫자를 바꿔도 main에서 num은 안바뀜.
	public static void printNum(int num) {
		System.out.println(num);
		num = 20; // num 값을 바꿔도 main의 값과 다른 값이기에 바뀌지 않음.
	}
	
	// 매개변수가 참조변수인 경우, 참조값(주소)가 전달되므로 printTest에서 숫자를 바꾸면
	// main에 있는 값도 바뀔 수 있다. 
	// 클래스의 멤버는 참조변수

	public static void printTest(Test t) {
		System.out.println(t.a);
		t.a=20; 
	}


}

class Test{
	int a;
	
}
