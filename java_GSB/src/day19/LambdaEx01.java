package day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(-1);
		list.add(100);
		list.add(22);
		list.add(-23);
		/*
		 * 람다식은 언제 쓰는가 
		 * 코드가 간결해짐
		 * 콜렉션에서 필터링이 쉬워짐
		 * 
		 * 람다식은 언제 사용? 
		 * 함수적 인터페이스의 객체가 필요한 경우
		 * 
		 * 함수적 인터페이스?
		 * 인터페이스의 추상 메소드가 1개인 인터페이스
		 * 
		 */
		
		
		
		System.out.println(list);
		// 여기 Comparator에 쉬프트 키 누르고 호버하면 @Funtionalinterface라고 뜸
		Collections.sort(list, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		//위의 식을 람다식으로 쓰면 아래와 같이 변함.
		Collections.sort(list, (a, b)-> a-b);
		
		
		System.out.println(list);
		
	}

}
