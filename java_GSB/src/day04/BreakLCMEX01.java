package day04;

public class BreakLCMEX01 {

	public static void main(String[] args) {
		// 두 정수의 최소 공배수를 구하는 코드를 작성하세요

		int num1, num2;
		num1 = 8;
		num2 = 12;
		//반복 횟수 i는 num1부터 num1*num2까지 num1씩 증가 <= "중요"
		//-> 수학적 조건 잘 산출하기
		for (int i = num1; i<=num1*num2; i+=num1) {
			if (i % num1 == 0 && i % num2 == 0) {
				System.out.printf("%d는 %d와 %d의 최소 공배수 입니다.", i, num1, num2);
				break;
			}
		}

	}

}
