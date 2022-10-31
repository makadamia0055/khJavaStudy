package day06;

public class ArrayCopyEx01 {

	public static void main(String[] args) {
		// 배열의 얕은 복사 예제
		int arr1[] = new int[3];
		int arr2[] ;
		
		
		arr2= arr1; // arr1을 복사해서 arr2를 만듦. 얕은 복사.
		
		//arr1과 arr2 값 확인
		for(int i = 0; i<arr1.length; i++) {
			System.out.println("arr1["+ i +"]: " + arr1[i] + " , arr2["+ i +"]: " + arr2[i]);
		}
			
		arr1[0]=10;
		System.out.println("-----------");
		
		for(int i = 0; i<arr1.length; i++) {
			System.out.println("arr1["+ i +"]: " + arr1[i] + " , arr2["+ i +"]: " + arr2[i]);
		}
		// arr1[0]의 값을 바꿨는데 둘다 바뀜. 참조변수의 번짓수만 복사한 상태
		
		
	}

}
