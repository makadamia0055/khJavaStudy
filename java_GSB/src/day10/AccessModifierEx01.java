package day10;

import day10_1.TestB;

public class AccessModifierEx01 {

	public static void main(String[] args) {
		
		TestA a = new TestA();
		TestB b = new TestB();
		//a.num1 = 1; // 에러 발생. private 에 대한 접근 권한 없음
					// private 외부에 대한 접근 권한 없음
		a.num2 = 2; // default이고 같은 패키지라 접근 가능.  
		a.num3 = 3; // public
		//b.num1 = 1; // num1 과 동일
		// b.num2 = 2; // 에러발생. default이기 때문에 다른 패키지에서 접근할 수 없음.
		b.num3 = 3;
		
		
		
		
	}

}
