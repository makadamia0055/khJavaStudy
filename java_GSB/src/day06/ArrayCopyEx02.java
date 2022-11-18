package day06;


public class ArrayCopyEx02 {

	public static void main(String[] args) {
		// 깊은 복사 예제
		int arr1[] = new int[] {1, 2, 3};
		int arr2[] ;
	
		//깊은 복사 예제 1
		int tmpArr[] = new int [arr1.length]; // 별도의 객체 생성 
		for(int i = 0; i< arr1.length; i++) { // 및 복사
			tmpArr[i] = arr1[i];
		}
		arr2 = tmpArr; 
		// 깊은 복사 예제 3를 풀어쓰면 이렇게 됨. 
		
		
		// 깊은 복사 예제 2
		/*
		arr2 = new int[arr1. length];
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		*/
		
		// 깊은 복사 예제 3
		//arr2 = Arrays.copyOf(arr1,  arr1.length);
		
		// 깊은 복사 예제 4
		
		//arr2 = arr1.clone();
		
		// 
		
		
		
		
		
		//arr1과 arr2 값 확인
		for(int i = 0; i<arr1.length; i++) {
			System.out.println("arr1["+ i +"]: " + arr1[i] + " , arr2["+ i +"]: " + arr2[i]);
		}
			
		arr1[0]=10;
		System.out.println("-----------");
		
		for(int i = 0; i<arr1.length; i++) {
			System.out.println("arr1["+ i +"]: " + arr1[i] + " , arr2["+ i +"]: " + arr2[i]);
		}
		
	}

}
