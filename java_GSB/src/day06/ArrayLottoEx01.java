package day06;
import java.util.Scanner;
public class ArrayLottoEx01 {
	
public static int[] Lotto(int[] lottoarray) {
	int cnt = lottoarray.length;
	int max = 45, min = 1;

	boolean[] tfarr = new boolean[max - min + 1];

			
	int i = 0; // 저장된 랜덤수의 갯수
	while (i < cnt) {
		int temp = (int) (Math.random() * (max - min + 1) + min);

		if (tfarr[temp - 1] == false) {
			lottoarray[i++] = temp; // 후위형 연산자로 한줄로 줄이기.
			tfarr[temp - 1] = true;
		} else
			continue;

	}

	tfarr = null;
	
	return lottoarray;
	
}
	
	
	
	
	
	public static void main(String[] args) {
		/*
		 * 로또번호를 랜덤으로 생성하고, 당첨번호를 입력하여 몇등 당첨됐는지 출력하는 코드를 작성하세요. 숫자범위 1~45 1등 6개 2등 5개
		 * 보너스 3등 5개 4등 4개 5등 3개
		 * 
		 * 6개번호 +보너스 번호 총 7개
		 */
		int cnt = 7;
		int max = 45, min = 1;

		int[] arr = new int[cnt];
		Lotto(arr);
				
		
		
		Scanner scan = new Scanner(System.in);
		
		int[] mynum = new int[cnt];
		System.out.println("자동구매입니까? Y/N");

		char yn = scan.next().charAt(0);
		if(yn=='y'||yn=='Y') {
		
		Lotto(mynum);
		System.out.print("당신의 번호는 : ");
			for(int a = 0; a<cnt-1; a++) {
				System.out.print(mynum[a]+ ", ");
			}
			System.out.println("보너스번호 : " + mynum[cnt-1]);
		}
		else if(yn=='n'||yn=='N') {
		System.out.println("구매하실 번호를 입력해주세요.");
		// 번호 적합성 판정
		int inputcnt = 0;
		while(inputcnt<cnt) {
			int mytemp = scan.nextInt();
			if(mytemp<1||mytemp>45) { //입력값 무결성
				System.out.println("적합한 번호를 입력해주세요.");
				inputcnt=0;
				System.out.println("지금까지 입력된 번호가 초기화됩니다.");
			} else {
				mynum[inputcnt]=mytemp;
				inputcnt++;
				}
			for(int b = 1; b<inputcnt; b++) { // 입력값 중복값 검사
				if(mynum[b-1]==mytemp) {
					System.out.println("입력된 값중에 중복된 값이 있습니다.");
					inputcnt = 0;
					System.out.println("지금까지 입력된 번호가 초기화됩니다.");
				}
			}
			
		}
		}
		
		
		//로또번호 출력 
		System.out.println("이번주 당첨 번호");
		for (int j = 0; j < cnt - 1; j++) {
			System.out.print(arr[j] + " ");

		}
		System.out.println("보너스 번호 : " + arr[cnt-1]);
		
		System.out.println("------------------------------------");
		System.out.print("당신의 등수는? :");
		
		int potcnt=0;
		boolean bonus =false;
		for(int k =0; k<cnt-1; k++) {
			for(int j=0; j<cnt-1; j++) {
				if(arr[k]==mynum[j]) {
					potcnt++;
				}
			}
			if(arr[cnt-1]==mynum[cnt-1]) {
				bonus=true;
			}
		}
		
		if(potcnt<3) {
			System.out.println("꽝 다음 기회에");
		} else if(potcnt==3) {
			System.out.println("5등 당첨 축하합니다.");
		} else if(potcnt==4) {
			System.out.println("4등 당첨 축하합니다.");
		}else if(potcnt==5&&bonus==false) {
			System.out.println("3등 당첨 축하합니다.");
		}else if(potcnt==5&&bonus==true) {
			System.out.println("2등 당첨 축하합니다.");
		}else if(potcnt==6) {
			System.out.println("1등 당첨을 축하합니다.");
		}
			
		scan.close();

	}
}
