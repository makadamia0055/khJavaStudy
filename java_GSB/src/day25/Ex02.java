package day25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex02 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 정수를 5번 입력하여 배열/리스트에 저장하는 코드를 작성하세요.
		 * 단, 정수가 홀수이면 그대로 저장, 정수가 짝수이면 -를 붙여서 저장;
		 * */
		int[] arr = new int[5];
		for(int i= 0; i<5; i++) {
			System.out.println((i+1)+"번째 정수를 입력해주세요.");
			int num = scan.nextInt();
			if(num%2==1) { // 이건 음수 판별을 못함. 음수 판별을 하려면 !=0으로 하고 나머지를 else 처리해야
				arr[i] = num;
			}else {
				arr[i] = -num;
			}
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i= 0; i<5; i++) {
			System.out.println((i+1)+"번째 정수를 입력해주세요.");
			int num = scan.nextInt();
			if(num%2==1) {
				list.add(i, num);
			}else {
				list.add(i, -num);
			}
		}
		Iterator<Integer> it = list.iterator();
		int count = 1;
		while(it.hasNext()) {
			System.out.println(count+"번째 "+it.next());
			count++;
		}
		
		
		scan.close();
		
	}

}
