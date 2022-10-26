package day03;
import java.util.Scanner;
public class IfEx01 {
	public static void main(String[] args) {
		/* If문 (조건식) {실행문}
		 *  조건식의 결과값이 true면 실행문이 실행됨, 아니면 실행하지 않음.
		 *  ~하면 ... 한다
		 *  ~하면=조건식/ ...한다 = 실행문;
		 */
		//정수 num 이 0보다 크면 양수라고 출력하는 코드를 작성
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 num을 입력하세요 :");
		num = scan.nextInt();
		if(num>0) {
			System.out.println(num+"은 양수");
		}
		if(num==0) {
			System.out.println(num+"은 0");
		}
		if(num<0) {
			System.out.println(num+"은 음수");
		}
		
		scan.close();
		
	}

}
