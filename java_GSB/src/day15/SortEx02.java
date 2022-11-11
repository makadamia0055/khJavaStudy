package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx02 {

	public static void main(String[] args) {
		//
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("ppap");
		list.add("babo");
		list.add("sea");
		list.add("yes");
		list.add("a");
		list.add("A");

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		//Comparator 인터페이스를 구현한 구현 클래스가 필요
		
		// 지금 익명 클래스를 통해서 처리하는 중
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2); // compearTo의 리턴값은 -1, 0, 1
			}
		});
		System.out.println(list);
	}

}
