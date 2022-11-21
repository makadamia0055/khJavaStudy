package day05;

import java.util.Scanner;

public class ForUpDownEx01 {

	public static void main(String[] args) {
		/*
		 * 랜덤한 수를 생성하여 해당 수를 맞추는 코드를 작성하세요
		 * 
		 */

		// 1부터 n까지 랜덤한 수
		// 난수 생성
		// 난수 감추기...는

		int min = 1, max = 10;

		int r = (int) (Math.random() * (max - min + 1) + min);
		Scanner scan = new Scanner(System.in);

		int innum;

		
		int count ;
		
		for (count = 3 ; count > 0 ; count-- ) { 
			// break 문 대신 조건문에서 r != innum으로 처리해도 됨.
			System.out.print("숫자를 입력하세요.");
			System.out.println(count+"회 남았습니다.");
			innum = scan.nextInt();
			
		 if (innum ==0) {
				System.out.print("그만하시겠습니까? : Y/N");
				char yn = scan.next().charAt(0);
				if(yn=='y'|| yn =='Y') {
					break;
				} else if (yn =='n'|| yn == 'N') {
					count++;
					continue;
				} else { continue; 	}
		 	}	else if (innum < r) {
				System.out.println("Up");
			} else if (innum > r) {
				System.out.println("Down");			
			}  else {
				System.out.println("정답입니다.");
				scan.close();
				break;
			}

		}

	}

}
