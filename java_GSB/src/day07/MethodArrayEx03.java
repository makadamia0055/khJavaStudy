package day07;
import java.util.Scanner;
public class MethodArrayEx03 {

	public static void main(String[] args) {
		// 배열에 정수 num가 있는지 없는지 확인하는 메소드
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		Scanner scan = new Scanner(System.in);
		System.out.println("arr 안에 있는지 확인하고자 하는 정수 입력");
		int n= scan.nextInt();
		if(contains(n, arr)) {
			System.out.println(n+"는 배열에 있습니다.");
		} else {
			System.out.println(n+ "는 배열에 없습니다.");
		}
		
		scan.close();
		
	}
	
	/*
	 * 기능 : 상동
	 * 매개변수: num, array => int, int[]
	 * 리턴타입: boolean 
	 * 배열명 : containsNum()
	 */

	public static boolean contains(int num, int[] arr) {
		
		//for(int i = 0; i <arr.length ; i++) {
		
		for(int i: arr) {
		if(i==num) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
