package day12;

public class AbstractEx00 {

	// 추상클래스 => 추상메소드를 가진 클래스
	// 추상메소드 {} 몸체가 없는 메소드
	// 추상클래스를 상속 받은 일반 클래스는 부모의 추상 메소드를 반드시 오버라이딩 해야 함.
	// 추상 클래스를 상속받은 추상 클래스는 부모의 추상메소드 반드시 오버라이딩할 필요는 없다. 자기도 추상이라서
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
	}

}
abstract class TestA{
	public abstract void test();
}
class TestB extends TestA{
	//test()메소드를 오버라이딩하지 않으면 에러가 뜸. 그럴때 호버하면 자동으로 맨들어줌. 
	@Override
	public void test() {
		
	}

	
}

abstract class TestC extends TestA{
	
}

interface Calculator{ // interface의 변수는 묵시적으로 public static final 적용
	int MAX = 30;
	int sum(int num1, int num2); // interface는 묵시적으로 abstract
	int sub(int num1, int num2);
	int mul(int num1, int num2);
	double div(int num1, int num2);
	int mod(int num1, int num2);
	void run();
	/*  다른 사람과 공동작업을 하거나 클래스간의 교류에서 중간지대를 설계하기 위해서
	 *  메소드의 구현부가 없기 때문에 다중 상속이 가능함. 
	 */
}
