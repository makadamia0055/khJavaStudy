package day03;

import java.util.Scanner;


public class IfEx08 {

	public static void main(String[] args) {
			/* 점수를 정수로 입력받아 입력받은 성적에 맞는 학점을 출력하는 코드를 작성
			 *  A : 90~100
			 *  B : 80~ 89
			 *  C: 70 ~79
			 *  D : 60~ 69
			 *  F : 0~ 59
			 *  그외 : 잘못 입력된 성적입니다.
			 */
		Scanner scan = new Scanner(System.in);
		int score;
		System.out.print("성적을 입력해주세요 : ");
		score = scan.nextInt();
		
		if(score <=100 && score>=90) {
			System.out.println("A");
		} else if(score < 90 && score>=80) {
			System.out.println("B");
		} else if(score < 80 && score>=70) {
			System.out.println("C");
		} else if(score < 70 && score>=60) {
			System.out.println("D");
		} else if(score < 60 && score>=0) {
			System.out.println("F");
		} else {
			System.out.println("잘못 입력된 성적입니다.");
		}
		
		if(score> 100|| score < 0 ) {
			System.out.println("잘못 입력된 성적입니다.");
		} else if(score>=90) {
			System.out.println("A");
		} else if( score>=80){
			System.out.println("B");
		} else if(score>=70) {
			System.out.println("C");
		} else if(score>=60) {
			System.out.println("D");
		} else 
		{
			System.out.println("F");
		} 
		
		
		
		
		
		scan.close();
		
		
		
		
		
		
	}

}
