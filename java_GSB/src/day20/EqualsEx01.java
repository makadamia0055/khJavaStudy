package day20;

import java.util.ArrayList;

import lombok.Data;

public class EqualsEx01 {

	public static void main(String[] args) {
		
		Test t1 = new Test();
		t1.setNum(10);
		System.out.println("Test 객체와 Integer 객체 비교(equals) : "+t1.equals((Integer)10));
		ArrayList<Test> list = new ArrayList<Test>();
		list.add(t1);
		
		/* 리스트의 contains와 indexOf는 Test 객체의 equals를 바로 호출하는 것이 아니라 
		 * Objects.equals(o1, o2)를 호출한 뒤, 내부에서 o1과 o2가 같은 클래스의 객체이면
		 * Test의 equals를 호출
		 * 
		 * - 두 객체가 같은 클래스인 경우
		 * contains() -> Object.equals() -> Test.eqals()를 이용하여 true/false를 리턴
		 * 두 객체가 다른 클래스 인 경우
		 * contains() -> Object.equals() -> Object.equals() 단계에서 false 리턴
		 * 
		 */
		 
		System.out.println("Test 객체와 Integer 객체 비교(contains) :" + list.contains((Integer)10));
		System.out.println("Test 객체와 Integer 객체 비교(indexOf) :" + list.indexOf((Integer)10));
		
		
	}

}
@Data
class Test{
	private int num;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			// 클래스가 다른 경우 obj가 Integer로 변환이 가능하면 비교
			if(obj instanceof Integer) {
				return num==(Integer)obj;
			}
		Test other = (Test) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	
}