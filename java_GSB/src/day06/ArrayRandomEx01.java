package day06;

import java.util.Scanner;
public class ArrayRandomEx01{
	public static void main(String[] args) {
		// 랜덤으로 1~9사이의 숫자를 3개 생성하여 배열에 저장하는 코드를 작성

		int cnt = 3;
		int max = 9, min = 1;

		int[] arr = new int[cnt];
		boolean[] tfarr = new boolean[max - min + 1];

		// 중복 불가능 규칙은 어떻게 만들까
		// 1.for문으로 서치
		// 2. min~max의 boolean 배열 만들고 on off로 나온 수 표현.
		
		
		for (int i = 0;;) { //랜덤값 중복 제거 코드
			if (i == 3) {
				break;
			} else {
				RandomClass01 ran01 = new RandomClass01(max, min);
				int temp = ran01.makeRan1();
				if (tfarr[temp - 1] == false) {
					arr[i] = temp;
					tfarr[temp - 1] = true;
					i++;
				} else {
					continue;
				}
			}
		}

		// 정수를 입력받아 랜덤한 수에 있는지 없는지 확인해서 알려주는 코드를 작성하세요

		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력해주세요.");
		
		// 강사님은 전부 다 찾지 않고 불리언 값으로 있다 없다 체크해서 break;로 구현;
		
		int scantemp = scan.nextInt();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == scantemp) {
				System.out.printf("정수 %d가 arr[%d]에 존재합니다.\n", scantemp, i);
			} else {
				System.out.println("정수 " + scantemp + "가 arr[" + i + "]에 존재하지 않습니다.");
			}

		}

		System.out.print("배열 arr의 값 : ");
		for (int i : arr) {
			System.out.print(i + " ");

		}
		scan.close();
		// 야구게임이 이것의 활용형인듯. // 다만 랜덤수에 중복 불가능 규칙 필요

	}

}
