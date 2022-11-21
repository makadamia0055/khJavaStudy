package day06;

import java.util.Scanner;

public class ArrayUpDownEx01 {

	public static void main(String[] args) {
		/*
		 *  UP DOWN 게임을 무조건 3번 반복해서 맞추기까지의 횟수를 배열에 저장
		 */
		
		
		int coin =3;
		int crrnt;
		int max = 10, min = 1;
		
		Scanner scan = new Scanner(System.in);
		int[] playpoint = new int[coin];
		
		for(crrnt = 0; crrnt<coin ; crrnt++) {
		//업다운 게임
			int r = (int)(Math.random()*(max-min+1)+min);
			//System.out.println(r); 테스트용 코드
			int input ;	
			int playcnt = 0;
			System.out.println((playcnt+1)+"번째 게임입니다.");
			System.out.printf("%d~%d 사이의 숫자를 입력해주세요.\n", min, max);
			do {
				input = scan.nextInt();
				if(input<min||input>max) {
					System.out.println("범위를 벗어난 입력값입니다. 다시 입력해주세요.");
					continue;
				}
				playcnt++;
				if(input<r) {
					System.out.println("Up");
				} else if(input>r) {
					System.out.println("Down");
				} else if(input==r) {
					System.out.print("정답입니다 ");
				}
								
			} while(input !=r);
			scan.close();

			System.out.println(playcnt+"번만에 맞췄습니다!");
			playpoint[crrnt] = playcnt;
			System.out.println();
		
		
		
		
		//업다운 게임 끝
		}
		System.out.println("----------------");
		System.out.println("당신의 총 점은 ↓");
		for(int i= 0; i<coin; i++) {
			System.out.printf("%d번째 게임 : %d회\n", i+1, playpoint[i]);
		}
		System.out.println("입니다↑");
	
	}

}
