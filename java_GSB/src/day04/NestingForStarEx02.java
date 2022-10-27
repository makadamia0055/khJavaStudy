package day04;

public class NestingForStarEx02 {

	public static void main(String[] args) {
		/*
		 * 왼쪽 삼각형
		 * *	row =1 *=1
		 * ** 	row =2 *=2
		 * ***	row =3 *=3
		 * **** row =4 *=4
		 * ***** row = 5 * = 5
		 * 
		 *  
		 */
		/*for (int j = 0; j < 5; j++) {

			for (int i = 0; i <= j; i++) {
				System.out.print("*");
			}
			System.out.println();
		}*/ 
/*
		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= (5 - i); j++) {
				System.out.print(" ");

			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	*/	
		
		/*이등변 삼각형
		 * 
		 * 
		 */
		
		
		// 4 1 4 1
		// 3 3 3 2
		// 2 5 2 3
		// 1 7 1 4 
 		// 0 9 0 5
		
		for(int i = 1; i <=5 ; i++) {
			for(int j =1 ; j<= 5-i ; j++ ) {
				System.out.print(" ");
			}
			for(int j =1 ; j<=2*i-1 ;j++ ) {
				System.out.print("*");
			}
			
			
			/*for(int j =1 ; j<= 5-i ; j++ ) {
				System.out.print(" ");
			}*/  // 이건 넣을 필요 없었음..
			
			System.out.println();
			
		}
		
		
		// 선생님은 앞의 코드를 재활용해서 큰 직각삼각형과 작은 직각삼각형 두개로 풀이.
		// row -1로 작동하는 작은 삼각형 하나
		// 그거 합치면 2row -1 나와서 같아짐.
		
		// 주말에 다양한 삼각형. 다이아몬드 등등 해보기.(자습)
		
		
		
		
		
		
		
		
		
	}
	
	

}
