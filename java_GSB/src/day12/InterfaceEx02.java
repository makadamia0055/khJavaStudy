package day12;

public class InterfaceEx02 {
	public static void main(String[] args) {
		
	}

}

interface Test{
	void test();
	default void testB() {
		System.out.println("테스트입니다.");
	} // 유일하게 구현부가 있을 수 있는 default 메소드
				// 나중에 default 메소드를 추가해도 
				// 인터페이스를 implements한 클래스에 구현을 요구하지 않음.
	
}

class TestAA implements Test{
	@Override
	public void test() { // default 메소드는 자동완성을 해도 	
							// 자동완성 안됨.
	
		
	}
}

class TestAB implements Test{
	@Override
	public void test() {
		
	}
}
