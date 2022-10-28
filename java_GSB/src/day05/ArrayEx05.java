package day05;

public class ArrayEx05 {

	public static void main(String[] args) {
		/* 5개짜리 배열을 생성하여 2부터 5개의 소수를 배열에 저장하고 출력하세요.
		 *  */

		int[] pArr = new int[5];
		int pCnt = 0;
		int i = 2;
		int sum;		

		while(pCnt<pArr.length) {
			sum = 0;
			for(int j =1; j<=i; j++) {
				if(i%j==0) {
					sum+=j;
				}
				if(sum==i+1) {
				
					pArr[pCnt]=i;
					pCnt++;
				}
			}
			i++;
		}
		
		for(int n = 0; n<5 ; n++) {
			System.out.print(pArr[n]+ " ");
		}
		
		
		
	}
		
		
}


