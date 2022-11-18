package day08;

import java.util.Arrays;
import java.util.Scanner;

public class MethodLottoEx01 {
	
	
	
	public static void main(String[] args) {
		/* 
		 * 
		 * 기능 : 배열 출력(로또 번호- 당첨 출력, 내 번호 출력)
		 * 		스캐너(내번호 입력)/ 
		 * 매개변수
		 * 리턴값
		 * 매소드명
		 * 
		 */
		// 번호 입력부
		int min = 1, max = 45;
		int size = 6;
		int [] lotto = creatRandomArray(min, max, size);
		
		Arrays.sort(lotto);
		System.out.println("로또 번호 : ");
		printArray(lotto);
		
		int bonus;
		do {
			bonus = random(1,45);
				
			}while(contains(bonus, lotto));
		
		
		int[] myLottoNum = purchaseLotte();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("보너스 숫자를 입력해주세요.");

		int mybonus1 = scan.nextInt();


		printRank(getRank(lotto, myLottoNum, bonus, mybonus1));
		
		
		
		
		
	}

	public static void printArray(int[] arr1) {
		if(arr1 == null) {
			return;
		}		
		for(int i = 0; i <arr1.length; i++) {
			System.out.print(arr1[i] + " ");
			
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
	//로또 수동 입력
		public static int[] purchaseLotte() {
			Scanner scan = new Scanner(System.in);
			int min = 1, max = 45;
			int size = 6;
			int[] myNumArr = new int[size];
			
			for(int i = 0 ; i<myNumArr.length-1;i++) {
				int tmp = scan.nextInt();
				myNumArr[i] = tmp;
				}
			scan.close();

			return myNumArr;
		}
			
			
			
			
		
		
	
			
		
		/*
		 * 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
		 * 매개변수 arr1 arr2
		 * 리턴타입 int
		 * 메소드명 countLotto
		 */
		
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
		
		/*
		 * 기능: 등수를 알려주는 메소드 // 등수가 입력되면 그 등수를 출력하는 메소드
		 * 매개변수 로또, 내로또번호, 보너스, 내보너스
		 * 리턴값 출력이니 없음
		 * 매소드명 로또 그래이드?
		 * 
		 * 
		 */
		
		public static int getRank(int[] arr1, int[] arr2, int bonus, int mybonus) {
			int count = countLotto(arr1, arr2);
			if(count<3) {
				return -1;
			} else if(count==3) {
				return 5;
			} else if(count==4) {
				return 4;
			} else if(count==5&&bonus!=mybonus) {
				return 3;
			} else if(count==5&&bonus==mybonus) {
				return 2;
			} else if(count==6) {
				return 1;
			} else {return -1;}
			
		}
		
	// switch 문으로 할때 return contains(bonus, arr)? 2: 3;으로 2/3등 처리가능
		
		 public static void printRank(int rank) {
			 switch(rank) {
			 case 1: System.out.println("1등"); break;
			 case 2: System.out.println("2등"); break;
			 case 3: System.out.println("3등"); break;
			 case 4: System.out.println("4등"); break;
			 case 5: System.out.println("5등"); break;
			 case -1: System.out.println("꽝"); break;
			 }
		 }
		
		
		
		
}
