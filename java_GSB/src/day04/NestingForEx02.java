package day04;

public class NestingForEx02 {
	public static void main(String[] args) {
		/*
		 * 2부터 100까지의 소수를 출력하는 코드 작성
		 * 
		 */

		// ctrl+ shift + F 이클립스 자동 줄맞춤 단축키
		int primeCount = 0;

		for (int num = 2; num <= 100; num++) { // 소수 판정 sum 초기화
			int sum = 0; // 소수 판정 sum

			for (int i = 1; i <= num; i++) { // 일단 소수 for문 작성
				if (num % i == 0) {
					sum += i;

				}
			}

			if (sum == num + 1) {
				System.out.println(num);
				primeCount++;
			}
		}

		System.out.printf("2에서 100까지 소수의 총 갯수는 %d 개 입니다.", primeCount);
	}

}
