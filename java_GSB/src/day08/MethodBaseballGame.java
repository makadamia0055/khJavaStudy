package day08;

import java.util.Scanner;
public class MethodBaseballGame {

	public static void main(String[] args) {
		/*
		 * 숫자 야구 게임
		 * 1~9사이의 중복되지 않은 3개의 숫자가 랜덤으로 생성이 되고, 
		 * 생성된 숫자를 맞추는 게임
		 *  규칙 : 숫자가 같은 자리에 있으면 스트라이크
		 *  		숫자가 있지만 다른자리에 있으면 ball
		 *  		일치하는 숫자가 하나도 없으면 out
		 * 
		 */
	
	// 게임카운트 while
		
		//중복되지 않는 난수 3개 배열 생성
		int min = 1, max = 9, size = 3;
		int[] baseball = creatRandomArray(min, max, size);
		int[] myNum =new int[size];
		boolean win = false;
		
		
		System.out.println("test용-----------");
		printArray(baseball);
		System.out.println();
		System.out.println("test용-----------");
		
		int playCount = 0;
		do {
		Scanner scan = new Scanner(System.in);
		// 판정
		int cnt= 0;
		System.out.println("숫자입력");
		do {
			int tmp = scan.nextInt();
			if(tmp>=1&&tmp<=9) {
			myNum[cnt]=tmp;
			cnt++;
			} else {
				scan.nextLine();
				System.out.println("정확한 숫자를 입력해 주세요.");
				cnt=0;
			}
			
		} while(cnt<3) ; 
		
		System.out.println();
		int[] result=judge(baseball, myNum);
		printJudge(result);
		playCount++;

		if(result[0]==3) {
			
			System.out.println("---------------------");
			System.out.println("3 Strike!! GAME SET!!");
			System.out.println("---------------------");
		win = true;
		}
		
	
		} while(!win);
	
	System.out.println(playCount);
	
	}
	// 이거 선생님 코드는 교실이 너무 더워서 제대로 못쳤음. 
	/* 선생님 구현 함수
	 * 기능 : Scanner 가 주어지면 정수를 size 개만큼 입력받아 배열에 저장하고, 
	 * 		저장된 배열을 돌려주는 메소드
	 * 매개변수 : Scanner, size개 Scanner scan, int size
	 * 리턴타입 ; int[]
	 * 메소드명 ; scanArray
	 * 
	 * @param scan Scanner
	 * @param size 입력받을 정수의 개수
	 * @return 입력받을 값들이 저장된 배열
	 * 
	 */
	public static int[] scanArray(Scanner scan, int size) {
		if(size <=0) {
			return null;
		}
		
		int [] arr = new int[size];
		for(int i = 0 ; i< size; i++) {
			arr[i] = scan.nextInt();
		}
		return null;
	} 
	
	/* 선생님 구현
	 * 기능 : 두 배열이 주어지면 같은 번지에 있는 수를 비교하여 일치하는 숫자들이
	 * 몇개 있는지 알려주는 메소드
	 * @param arr1 int[] : 첫번째 정수 배열
	 * @param arr2 int[] : 두번째 정수 배열
	 * @return 같은 번지에서 일치하는 숫자들의 개수
	 * 
	 */
	public static int getStrike(int []arr1, int arr2[]) {
		int strike = 0;
		if(arr1 ==null|| arr2 == null ) {
			return 0;
		}
		int size =arr1.length< arr2.length? arr1.length : arr2.length; 
		for(int i = 0; i<size; i ++) {
			if(arr1[i] == arr2[i]) {
				strike++;
			}
			
		}
		return strike;
	}
	/*
	 * 기능 두 정수 배열이 주어지면 같은 숫자들 중에서 번지가 서로 다른 숫자들의 개수를 알려주는 메소드
	 * @param arr1 int[] : 첫번째 정수 배열
	 * @param arr2 int[] : 두번째 정수 배열
	 * @return 같은 숫자들 중에서 번지가 서로 다른 숫자들의 개수
	 */
	public static int getBall(int[] arr1, int[] arr2) {
		if(arr1==null||arr2==null) {
			return 0;
		}
		int ball = 0;
		int strike = getStrike(arr1, arr2);
		for(int num : arr1) { 
			if(contains(num, arr2)) {
				ball++;
			}
		}
		return ball;
	}
	
	/*
	 * 기능 : strike와 ball의 개수가 주어지면 콘솔에 결과를 출력하는 메소드
	 * @param strike 스트라이크 개수
	 * @param ball 볼의 개수
	 * 
	 */
	public static void printGame(int strike, int ball) {
		if(strike != 0) {
			System.out.println(strike + "S " );
			
		}
		if(ball!=0) {
			System.out.println(ball+"B");
		} 
		if(strike == 0 && ball == 0) {
			System.out.println("out");
		}
		
	}
	
	
	public static int[] creatRandomArray(int min, int max, int size) {
		if(max-min+1<=size) {
			return null;
		}
		int[] arr = new int[size];
		for(int i = 0 ; i<arr.length ; ) {
			int tmp = random(min, max);
			if(contains(tmp, arr)) {
				continue;
			} else {
				arr[i++]=tmp;
				
			}
			
		}		
		return arr;
	}
	public static int random(int min, int max) {
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max-min+1)+min);
	}
	public static boolean contains(int num, int[] arr) {
		if(arr==null||arr.length==0) {
			return false;
		}
		
		for(int i: arr) {
		if(i==num) {
				return true;
			}
		}
		return false;
	}
	
	public static int[] judge(int[] pit, int[] bat) {
		int[] judge = new int [3]; // S B O
		int strike =0, ball = 0;
		for (int i = 0; i < pit.length; i++) {
			for (int j = 0; j < bat.length; j++) {
				if (pit[i] == bat[j]) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				} 
					
				

			}
			judge[0] = strike;
			judge[1] = ball;
			judge[2] = 3-judge[0]-judge[1];	
			
			}
		
		return judge ;
	}
		
	public static void printArray(int[] arr1) {
		if(arr1 == null) {
			return;
		}		
		for(int i = 0; i <arr1.length; i++) {
			System.out.print(arr1[i] + " ");
			
		}
	}



	public static void printJudge(int[] arr) {
		
		System.out.println(arr[0]+ " Strike!");
		System.out.println(arr[1]+ " Ball!");
		System.out.println(arr[2]+ " Out!");
		
		
		
	}
	public static int countLotto(int[] arr1, int[] arr2) {
		if(arr1 ==null||arr2 ==null) {
			return 0;
		}
		int count=0; // 향상된for 문으로 꺼내고 contains로 처리해보기
		for(int i : arr1) {
			if(contains(i, arr2)) {
			count++;
				}
				
			}
			
		
		return count;
	}
	


}