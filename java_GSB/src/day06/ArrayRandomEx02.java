package day06;

public class ArrayRandomEx02 {

	public static int makeRan(int max, int min) {
		int temp = (int) (Math.random() * (max - min + 1) + min);
		return temp;
	}
	
	public static void main(String[] args) {
		/* 랜덤으로 1~9사이의 숫자를 중복되지 않게 생성하여 배열 저장하는 코드를 작성하세요.
		 * 
		 */

		int cnt = 3;
		int max = 9, min = 1;

		int[] arr = new int[cnt];
		boolean[] tfarr = new boolean[max - min + 1];
		
		int i = 0; // 저장된 랜덤수의 갯수
		while(i<cnt) {
			int temp = makeRan(max, min);

			
			// 인덱스 찾아서 하기
			/* 
			 boolean isDuplicated = false; 
			 							//저장한 배열에서 중복 수있는지 찾기
			 for(int k = 0 ; k<i; k++){ //저장된 갯수만큼 반복, cnt일 필요 없음.
			 
			 	if(arr[k]==temp){
			 isDuplicated = true;
			 	} else {
			 	isDuplicated = false;
			 	}
			 }
			 if(isDuplicated != true){
			 arr[i++] = temp; //후위형 연산자로 한줄로 줄이기. 
			 } else {
				 continue; //이거 역으로 바꿔도 됨.
			 }
			 */
			
			// max-min+1개의 불리언 배열 만들어서 중복표시
			if(tfarr[temp-1]==false) {
				arr[i++] = temp; //후위형 연산자로 한줄로 줄이기.
				tfarr[temp-1]=true;
			} else continue;
			
			
		}
		
		tfarr=null; //필요없는 객체 반환
		for(int j = 0; j<cnt; j++) {
			System.out.print(arr[j]+" ");
			
			
		}
		
		
		
		
	}

}
