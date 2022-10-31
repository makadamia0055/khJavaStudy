package day06;

import java.util.Scanner;
public class ArrayScroeEx01 {

	public static void main(String[] args) {
		/*
		 *  5명 학생의 국어, 영어, 수학 성적을 저장하기 위한 배열을 만들고, 
		 *  Scanner를 이용하여 입력받아, 국어평균, 영어평균, 수학평균을 구하는 코드를 작성하세요.
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int stdCount = 5; // 나중의 확장성을 위해서 학생수를 변수처리;
		
		int[] korarr = new int[stdCount];
		int[] engarr = new int[stdCount];
		int[] matharr = new int[stdCount];
		int[] sumarr = new int[stdCount];
		
		
		for(int i = 0; i<stdCount; i++) {
			int tmpkor, tmpeng, tmpmath, tmpsum;
			
			System.out.print((i+1)+"번 학생의 국어, 영어, 수학 성적을 차례로 입력하세요.");
			// 스캐너로 엔터 입력받을거기때문에 println이 아니라 print로 해도 됨
			
			tmpkor = scan.nextInt();
			tmpeng = scan.nextInt();
			tmpmath = scan.nextInt();
			tmpsum = tmpkor+tmpeng+tmpmath;
			
			korarr[i] = tmpkor;
			engarr[i] = tmpeng;
			matharr[i] = tmpmath;
			sumarr[i] = tmpsum;
						
		}
		
		for(int i = 0; i<stdCount; i++) {
			System.out.printf("%d번 학생의 성적 국어:%d, 영어:%d, 수학:%d, 평균:%.2f\n", i+1,  korarr[i], engarr[i], matharr[i], sumarr[i]/(float)3);
		}
			
		int clskor = 0, clseng =0, clsmath =0, clssum = 0 ;
		
		for(int i = 0; i <stdCount; i++) {
			clskor += korarr[i];
			clseng += engarr[i];
			clsmath += matharr[i];
			clssum += sumarr[i];
		}
		System.out.println("------------------------ ");
		System.out.printf("우리반의 학생 평균 점수 국어: %.2f점, 영어: %.2f점, 수학:%.2f점, 총점 평균:%.2f점", clskor/(float)5, clseng/(float)5, clsmath/(float)5, clssum/(float)15);
		
		
		
		
		
		
	}

}




