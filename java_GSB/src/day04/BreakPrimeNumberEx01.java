package day04;

public class BreakPrimeNumberEx01 {
	public static void main(String[] args) {
		// break문을 이용한 소수판별문
		// 임의의 수 num부터 시작하여 1까지 내려가는 와중에 
		// 만나는 첫 약수가 1이면 소수

		int num = 7;
		int i;
		for(i= num-1; i>=1; i-- ) {
			if(num%i==0) {
				break;
			}
			
			
		}
		
		if(i==1) {
			System.out.println(num+"은 소수");	
		}
		else {System.out.println(num+"은 소수 아님");}
		
		
		
		
		
	}

}
