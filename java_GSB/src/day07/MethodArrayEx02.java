package day07;

public class MethodArrayEx02 {

	public static void main(String[] args) {
		// 1에서 9사이의 랜덤한 수를 배열에 3개 저장하는 코드를 작성하세요.
		// 단 메소드를 이용하여. 
		
		MethodArrayEx01.arrayPrint(randomArray(1, 9, 3));
		int[] arr = new int[3];
		randomArray(1, 9, arr);
		System.out.println();
		MethodArrayEx01.arrayPrint(arr);


	}
	// 최소값과 최대값 사이의 랜덤한 수를 주어진 배열에 저장하는 메소드 
	// 매개변수: 최소값, 최대값, 배열 int min, int max, int[size] arr
	// 리턴타입: 인수값으로 들어간 배열에 저장-> 값은 인수array에 저장. 리턴타입 굳이 필요 없음.
	// 메소드명: randomArray() //오버로딩
	
	
	
	public static void randomArray(int start, int end, int[] arr) {
		for(int i = 0 ; i <arr.length ; i++) {
			arr[i] = random(start, end);
			
		}		
		return ; 
	}
	
	
	
	
	
	
	// 최소값과 최대값 사이의 랜덤한 수를 size개 만들어 배열에 저장한 후 ,
	//저장된 배열을 리턴하는 메소드
	/* 기능 : 랜덤한 수 생성, 배열에 3개 저장
	 * 매개변수 : 시작값, 끝값, 저장 개수 
	 * 리턴값 : int[] array
	 * 메소드명: randomArray()
	 */
	
	
	
	public static int[] randomArray(int start, int end, int size) {
		int[] arr = new int[size];
		for(int i = 0 ; i < size ; i++) {
			arr[i] = random(start, end);
			
		}		
		return arr; //리턴되는 것은 arr이라는 변수명까지 리턴이 아니라 객체의 번지값만
		// 때문에 리턴 변수명은 관계 없는듯;
	}
	
	/*기능 : 최소값과 최대값 사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 매개변수: 최소값 최대값
	 * 리턴타입: 랜덤한 수 int
	 * 메소드 명 : random
	 */

	public static int random(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}

}
