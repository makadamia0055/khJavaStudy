package day25;



import java.util.Scanner;

public class Ex01 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수가 0 이상이면 0부터 입력받은 수까지 합을 구하고, 
		 * 입력받은 정수가 0 미만이면 0부터 입력받은 수까지 누적차를 구하는 코드를 작성하세요.
		 * 3입력
		 * 0 +1 +2 +3 = 6
		 * -3입력
		 * 0 -(-1)-(-2)-(-3) = 6
		 * */
		System.out.println("정수를 입력하세요.");
		int num = scan.nextInt();
		int sum = 0;
		if(num>=0) {
			for(int i = 0; i<=num; i++) {
				sum+=i;
			}
		}else {
			for(int i = 0; i>=num; i--) {
				sum-=i;
				// 누적합/차의 부분은 if 바깥에서 String str = "누적합";을 선언하고 
				// else에서 str을 덮어씌워주는 방법도 있음. 
			}
		}
		System.out.println("0부터 정수 " +num+ "까지의 "+ (num>=0?"누적합":"누적차")+"의 값은 :" + sum);
		scan.close();
		
		
		
		
		
		
		
		
	}

}
