package day14;

public class GenerictEx01 {

	public static void main(String[] args) {
		/*
		 * 컬렉션은 제네릭 클래스 
		 * 제네릭 클래스는 필드의 데이터형(클래스)이 객체 생성시 정해지는 클래스
		 *
		 * 클래스명<데이터형(클래스)> 객체명 = new 생성자<데이터형(클래스)>();
		 */
		A<Integer> a = new A<Integer>();
		a.num = 10;
		System.out.println(a.num);
		
	}

}
class A<T>{
	T num;
}