package day07;

public class MethodArrayEx01 {

	public static void main(String[] args) {
		// 매개변수가 배열인 경우
		//배열에 있는 값을 출력하는 코드를 작성하세요.
		int[] arr = {1, 3, 5, 10, 20};
		arrayPrint(arr);
		
	}
	/*	기능 : 정수 배열이 주어지면 배열의 값을 한줄에 출력하는 메소드
	 * 매개변수: int[] arr
	 * 리턴타입: void
	 * 메소드명: arrayPrint
	 * 
	 */
	
	
	public static void arrayPrint(int[] arr1) {
		for(int i = 0; i <arr1.length; i++) {
			System.out.print(arr1[i] + " ");
			
		}
	}
}
