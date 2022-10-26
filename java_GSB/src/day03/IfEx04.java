package day03;
import java.util.Scanner;
public class IfEx04 {
	public static void main(String[] args) {
		// 정수 num이 3의 배수라면 3의 배수라고 출력하고, 아니면 3의 배수가 아닙니다라고 출력하는 코드를 작성하시오.
	
		Scanner scan = new Scanner(System.in);
		int num;
		System.out.print("정수 num를 입력하세요 :");
		num = scan.nextInt();
		
		if(num%3==0) {
			System.out.println(num+ "는 3의 배수입니다.");
		} else 
		{
			System.out.println(num+ "는 3의 배수가 아닙니다.");
		}
		
		
		scan.close();
	
	
	
	
	}

}
