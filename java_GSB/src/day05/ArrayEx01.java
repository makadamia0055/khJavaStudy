package day05;

public class ArrayEx01 {

	public static void main(String[] args) {
			/* Array 배열 선언 방법
			 * 
			 * 선언 :
			 * 	자료형 배열명[]
			 * 혹은
			 * 	자료형[] 배열명
			 * 
			 * 상기 두 방법의 차이는?
			 * 
			 */
		int arr1[], arr2; // arr1: 배열, arr2: 정수값
		int [] arr3, arr4; // arr3: 배열, arr4: 배열
		/*
		 * -배열 선언과 동시에 할당하는 경우
		 * 자료형 배열명 [] = new 자료형[크기(변수의 크기(리터럴, 변수 등)];
		 * 자료형 [] 배열명 = new 자료형[크기];
		 * 
		 * 
		 * 할당된 배열의 각 번지는 기본 값으로 초기화가 된다. (배열도 객체이므로?)
		 * 
		 * 
		 * 
		 */
		int arr5 [] = new int [3]; // 총 int X 4칸짜리 배열
		int [] arr6  = new int [5];
		
		/* 배열의 번지를 이용한 사용방법
		 *  - 배열명[번지]를 이용하여 변수처럼 활용
		 * 
		 */
		
		
		arr6[0] = 1; // 배열에 인덱스값을 넣고 하나의 변수처럼 사용.
					// 변수==값을 저장하는 공간==배열의 공간이기 때문에
		System.out.println(arr6[0]);
		// arr6[5] = 1; ArrayIndexOutOfBoundsException 발생, 5개짜리 배열은 4번지까지 기능.
		

	}

}
