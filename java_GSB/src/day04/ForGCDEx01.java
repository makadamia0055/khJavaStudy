package day04;

public class ForGCDEx01 {

	public static void main(String[] args) {
		/*  두 정수의 최대 공약수를 구하는 코드를 작성하세요
		 * 	약수 : 나누었을 때 나머지가 0이 되게 하는 수 
		 * 	공약수 : 두 수의 공통된 약수
		 * 	최대 공약수 : 두 수의 공약수 중 최대의 수
		 *  12 : 1 2 3 4 6 12 
		 *  18 : 1 2 3 6 9 18
		 *  12와 18의 공약수 1 2 3 6
		 *  최대 공약수 6
		 */
		
		int num1, num2;
		num1 = 4812;
		num2 = 1516;
		int temp = 1;
		
		System.out.printf("%d와 %d의 공약수는 \" ", num1, num2);
		for(int i = 1; i <= num1; i++) { // 조건식의 최대값은 num1이든 num2든 별 상관 없음.
			if(num1%i==0 && num2%i ==0) {
				System.out.print(i +" ");
				temp=i;
			}
		}
		System.out.println("\" 그 중 최대공약수는 "+temp+ "입니다.");
				
		
		
		
	}

}
