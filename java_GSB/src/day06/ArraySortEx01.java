package day06;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortEx01 {

	public static void main(String[] args) {
			//버블 정렬을 이용한 배열 정렬
			//배열에 있는 숫자가 순서가 뒤죽박죽일때 그것을 차례대로 정리하기
		//두 항을 비교해서 정렬한다.(오름이나 내림차순으로)
		
		int arr[] = {1, 3, 5, 7, 2, 8, 6, 9};
		
		
		
		for(int i = 0; i <arr.length-1 ; i++ ) {
			for(int j= 0; j<arr.length-1-i; j++) { // -i는 확정된 버블 횟수 빼는 것.
					if(arr[j]>arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=tmp;
					}
			}
			
			
			for(int l = 0 ; l<arr.length; l++) {
				
				System.out.print(arr[l]+" ");
				}
			
			System.out.println();
		}
		System.out.println("-------------------");
		int arr2 [] = {9, 8, 7, 6, 5, 4, 3, 2};
		Arrays.sort(arr2);
		for(int tmp: arr2) {
			System.out.print(tmp + " ");
			
			
		}
		System.out.println();
		System.out.println("-------------------"); // int를 인티저로 변형
		Integer arr3 [] = {9, 8, 7, 6, 5, 4, 3, 2};
		Arrays.sort(arr3, Collections.reverseOrder());
		for(int tmp: arr3) {
			System.out.print(tmp + " ");
	}

}
}