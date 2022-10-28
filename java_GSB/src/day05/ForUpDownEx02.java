package day05;

import java.util.Scanner;

public class ForUpDownEx02 {
	public static void main(String[] args) {
		/*
		 * up down 게임
		 * 
		 */

		int min = 1, max = 10;
		int rnum = max +1;

		System.out.println(min + "과" + max + "사이의 랜덤한 수를 맞춰보세요.");

		Scanner scan = new Scanner(System.in);
		boolean game = true;
		
		for (; game == true;) {
			int innum = 0;
			rnum= (int) (Math.random() * (max - min + 1) + min);
			// 다회차 게임일때는 랜덤 요소도 for문 안에 넣기


			for (int count =1; innum != rnum;count++) {
				System.out.print("정수를 입력하세요. : ");
				innum = scan.nextInt();
				// 저녁먹고 가위바위보 만들어보기
				
				if (innum < rnum) {
					System.out.println("UP");
				} else if (innum > rnum) {
					System.out.println("Down");
				} else if (innum == rnum) {
					System.out.println("정답입니다.");
					System.out.printf("%d회만에 정답을 맞췄습니다.\n", count);
					System.out.print("그만하시겠습니까? : Y/N");
					char yn = scan.next().charAt(0);
					if (yn == 'y' || yn == 'Y') {
						game = false;
						System.out.println("플레이해주셔서 감사합니다.");
					} else if (yn == 'n' || yn == 'N') {
						break;
					}
				}
			}

		}
		
		scan.close();

	}

}
