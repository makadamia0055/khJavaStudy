package day04;

public class ForDivisionEx01 {

	public static void main(String[] args) {
			/*
			 *  정수 num의 약수를 출력하는 코드를 작성
			 *  약수 : 나누었을때 나머지가 0이 되게 하는 수
			 *  6의 약수 : 1, 2, 3, 6
			 */
		
		int num = 6;
		for(int i = 1; i<=num ; i++ ) {
			 if (i==num) {
				System.out.print(i + "는 " +num+"의 약수 입니다.");
			
			}else if(num%i==0) {
				System.out.print(i + ", ");
				
			}
			
		}
		
		
		
		
		
		
	}

}
