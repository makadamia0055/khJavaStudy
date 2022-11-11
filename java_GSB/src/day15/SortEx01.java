package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx01 {

	public static void main(String[] args) {
		//
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)(Math.random()*100)+1);
		list.add((int)(Math.random()*100)+1);
		list.add((int)(Math.random()*100)+1);
		list.add((int)(Math.random()*100)+1);
		list.add((int)(Math.random()*100)+1);
		list.add((int)(Math.random()*100)+1);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		//Comparator 인터페이스를 구현한 구현 클래스가 필요
		
		// 지금 익명 클래스를 통해서 처리하는 중
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println(list);
	}

}
