package weekend_homework;

import java.util.Scanner;

public class ThirtyoneGame {

	private int[] thirtyOneArr = new int[31]; // 패배조건 30을 받음. 31까지 있어야하나?
	private int winner =0;
	private int[] winCount = new int[2];
	private Com com = new Com();
	public class Com{
		
		
		public int ranNum() {
			//1~3 무작위 숫자 내보내는
			int min = 1, max = 3;
			int ran = (int)(Math.random()*(max-min+1)+min);
						System.out.println("컴퓨터가 "+ran+"칸 움직입니다.");
			return ran;
		}
		
		
	}
	
	public Com getCom() {
		return this.com;
	}
	
	
	public ThirtyoneGame() { // vs 컴 or vs 1p 2p
	//생성자
		Com com = new Com();
	}


	public void startGame() {
		System.out.println("------------------");
		System.out.println(" 31 게임을 시작합니다. ");
		System.out.println("------------------");
		this.thirtyOneArr = new int[31];
		winner = 0;

		
		
		return ;
	}

	public int[] getThirtyoneArr() {
		return this.thirtyOneArr;
		
	}

	/**
	 *  숫자 받아서 배열에 기입하는 메소드
	 *  숫자의 칸은 컴퓨터 1, 나 2로 표기, 빈칸은 0; 
	 *  
	 * @param arr 31 배열
	 * @param num 진행 숫자
	 * @param side 1p, 2p
	 * @return
	 */
	public int[] step(int[] arr, int num, int side) {
		// if(남은 칸 수가 num 이하일때)
		if(29-countStep(arr)<num) {
			arr[30]=side;
			} else {
			// else(남은 칸 수가 num 초과일때)			
		arr[countStep(arr)+num] = side;	
			
		}
			return arr;
	}
	
	/** 승자 찾기
	 * 
	 * @param arr 31 배열
	 * @return 승자
	 */
	public int whoIsWinner(int []arr) {
		int winner = (arr[30]==1)?2:1;
		
		
		return winner;
	}






	/**
	 * 배열을 입력받아 남은 칸 수을 계산해주는 메서드.
	 * @return 값이 입력된 마지막 인덱스값(0~30) 반환.
	 */
	public int countStep(int[] arr) {
	//끝에서부터 값이 0이 아닌 칸 찾기 - 거기서부터 num값
		int i;
		for(i = arr.length-1; i>=0; i-- ) {
			if(arr[i]!=0) {
				break;
			}
		}
		return i;
	}
	
	
	

	/**
	 * 사용자의 숫자를 입력받아 리턴
	 * @return 콘솔로 입력받은 1~3에 속하는 숫자
	 */
	public int scanMynum() {
		Scanner scan = new Scanner(System.in);
		int myNum;
		do {
		System.out.println("1~3 숫자를 선택하세요");
		myNum = scan.nextInt();
		if(myNum>=1&&myNum<=3) {
			break;
		} else {
			System.out.println("잘못된 숫자입니다.");
			continue;
		}
		} while(true);
		
		return myNum;
	}
	
	public void printStep(int index, int step) {
		
		for(int i = 1 ; i <=step ; i++) {
			System.out.printf("\'%d\' ", index+1+i);
			
		}
		System.out.println();
		System.out.printf("%d에 도착했습니다. \n", index+1+step);
		
		
	}
	/**
	 * 승 set 메서드
	 * @param side 컴=1 사람=2 인덱스 값 아님
	 */
	 
	public void setWinCount(int side) {
		this.winCount[side-1]++;
	}
	
	
	/**
	 * 승get 메서드
	 * @param side 컴=1 사람=2 인덱스 값 아님
	 * @return
	 */
	public int getWinCount(int side) {
		return this.winCount[side-1];
	}
	
	
	
	
	
}	
	



