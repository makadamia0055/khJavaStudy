package day03;
import java.util.Scanner;
public class IfEx05 {
	public static void main(String[] args) {
		/* 정수 num이 2의 배수이면 2의 배수라고 출력
		 * 3의 배수이면 3의 배수라고 출력하고
		 * 6의 배수이면 6의 배수라고 출력하고
		 * 2, 3, 6의 배수가 아니라면 2, 3, 6의 배수가 아닙니다 라고 출력하는 코드 작성
		 * 단 6의 배수는 6의 배수라고만 출력
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.print("임의의 정수를 입력하십시오:");
		num = scan.nextInt();
		if (num%6==0) {
			System.out.println(num+"는 6의 배수 입니다.");
		} else if (num%2 ==0) {
			System.out.println(num+"는 2의 배수 입니다."); 
			//연산 크기가 큰 것 부터 했음. 
		} else if(num%3 ==0) {
			System.out.println(num+"는 3의 배수 입니다.");
		} else {
			System.out.println(num+"는 2, 3, 6의 배수가 아닙니다.");
		}
		
		//두가지 버전 나머지 하나는 조건식에 다른 논리연산자로 조건식 추가해서 하기(지저분)
		
		scan.close();
		
		
		
	}

}
