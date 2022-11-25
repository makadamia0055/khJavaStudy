package day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

public class Ex03 {

	public static void main(String[] args) {
		/* 1에서 9 사이의 숫자를 랜덤하게 9번 뽑아서 일렬로 출력하는 코드를 작성하세요.
		 * */ 
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> rst = new ArrayList<Integer>();
		int min =1, max = 9;
	
//		int count =9;
//		
//		for(int i = 0; i<count ; i++) {
//			 list.add((int)(Math.random()*9+1));
//		}
//		for(Integer tmp : list) {
//			System.out.print(tmp + " ");
//		}
		for(int i = min ; i<=max; i++) {
			list.add(i);
		}
		
		while(list.size() !=0) {
			int r = random(0, list.size()-1);
			Integer num = list.remove(r); // remove를 통해 지운 객체를 리턴하여 num에 넣어줌
			rst.add(num);
		}
		System.out.println(rst);
		
		
	}

	public static int random(int min, int max) {
		if(max<min) {
			int tmp = max;
			max = min;
			min = tmp;
			
		}
		Random r = new Random();
		return r.nextInt(max - min +1) +min;
		// nextInt(정수) : 0 이상 정수 미만의 랜덤한 정수를 리턴
	}
}
