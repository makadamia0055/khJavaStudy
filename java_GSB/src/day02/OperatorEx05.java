package day02;

import java.util.Scanner;

public class OperatorEx05 {
	public static void main(String[] args) {
		/*홍길동 학생의 국어, 영어, 수학 점수를 콘솔에서 입력받고 
		 * 홍길동 학생 평균성적을 콘솔에서 출력하는 코드를 작성하세요.
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("홍길동 학생의 국어, 영어, 수학 점수를 입력하세요.");
		System.out.print("국어:  영어:  수학  :");
		
		int hkor, heng, hmath;
		
		hkor = scan.nextInt();
		heng = scan.nextInt();
		hmath = scan.nextInt();
		
		scan.close();
		
		float avg=(hkor+heng+hmath)/(float)3; // 제일 간단한건 3.0으로 
		
		System.out.println("홍길동 학생의 평균 성적 : "+ avg);
		// System.out.printf("홍길동 학생의 평균 성적 포맷팅 : %.5f", avg);
		// 자바에서는 double 표현식 lf안씀 / 쓸 필요가 없다고 함. 
		
		
		// 통과입니까? true/false
		//평균이 60점 이상이면 true, 아니면 false
		boolean isPass = avg>=60;
		boolean isFail = avg< 60;
		
		System.out.println("통과입니까?"+isPass);
		System.out.println("통과입니까?"+!isFail);
		
		
		
		
		
		
	}

}
