package day11;

public class InheritanceEx01 {
	public static void main(String[] args) {
		/*
		 *  A is a B로 표현이 가능하면 상속을 한다.
		 *  A가 자식(파생) 클래스, B가 부모클래스
		 *  스마트폰은 폰이다. 방탄소년단은 아이돌이다. => O
		 *  스마트폰은 카메라이다. => x
		 *  폰은 스마트폰 이다. => X
		 *  
		 *  
		 *  cf)
		 *  A has a B 로 표현이 가능하면 포함을 한다.
		 *  => B가 A클래스의 필드로 선언
		 *  스마트폰은 카메라를 가지고 있다. = O;
		 *  자동차는 바퀴를 가지고 있다 = O;
		 *  
		 *  
		 *  
		 *  
		 *  
		 */
		
		
		
		Child1 c = new Child1();
		c.print(); // Child1에서 print() 메소드 만들지 않았지만 상속받아 사용가능
		
		
		
	}

}

class Child1 extends Parent1{ // java 에서 다중상속은 불가;
	public Child1() {
		super(1, 2, 3); //컴파일러에서 부모생성자 자동 추가
						// super() 는 무조건 생성자의 첫줄에 
		
		// num1 = 10; // 에러. 접근제한자가 private 이기 때문에 .
		num2 = 20; // 접근 제한자가 default이어서 같은 패키지에 있으면 사용 가능
					// 상속 여부와 상관이 없다.
		num3 = 30;
		} // 접근제한자가 protected 여서 자식 클래스에서 사용할 수 있음.
					// 다른 패키지 이어도 사용 가능함.
		@Override
		public void print() {
			super.print();
			System.out.println("자식 클래스의 메소드입니다.");
			
		
		
		
	}
}

class Parent1{
	private int num = 1;
	int num2 = 2;
	protected int num3 = 3;
	
	public Parent1(int num, int num2, int num3) {
		this.num = num;
		this.num2 = num2;
		this.num3 = num3;
		
	}
	
	
	public void print() {
	System.out.println(num);
	System.out.println(num2);
	System.out.println(num3);
	}
}


