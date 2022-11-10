package day14;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx01 {

	public static void main(String[] args) {
		/*
		 * List는 인터페이스이고 
		 * ArrayList, Vector, LinkedList 가 구현 클래스
		 */
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(0, 10); // index 값 0에 10 추가
		list.remove(1); // index 값으로 삭제
		list.remove((Integer)10); // 일치하는 데이터 삭제
		System.out.println(list);
		System.out.println("1이 있나요? "+ list.contains(1));
		System.out.println("1이 어디 있나요? "+ list.indexOf(1) +"번지");
		System.out.println("1번지에 있는 값 : " + list.get(1));
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		for(Integer i: list) { 
			System.out.print(i + " ");
		}
		System.out.println();
		Iterator<Integer> it = list.iterator();
				while(it.hasNext()) {
					Integer tmp = it.next();
					System.out.print(tmp + " ");
				}
		System.out.println();
	
	}

}
