package day04;

public class ForPrimeNumberEx01 {

	public static void main(String[] args) {
			/* 정수 num가 소수인지 아닌지 판별하는 코드
			 *  소수는 약수가 1과 자신 밖에 없는 수 
			 */
		
		int num = 13;
		int sum = 0;
		for(int i = 1; i<= num;i++) {
			if(num%i==0) {
				sum+=i;
				//count++ // count 변수 갯수로 접근시 여기서 횟수 추가
				// ++count; // count = count +1 ; // count +=1;
				
				}
		}
		
		if(sum==num+1) {
			System.out.println(num+"는 소수입니다.");
		} else 	{
			System.out.println(num+"는 소수가 아닙니다.");
				}
		
		
	}

}
