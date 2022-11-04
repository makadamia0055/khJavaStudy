package day10;

import java.util.Scanner;




public class Baseball {

	private int[] ranNum;

	
	// 강사님은 int [] user 도 클래스 내에 만듦.
	
	private int playCnt =0;
	// 강사님은 카운트도 객체의 공통된 요소가 아닌거 같아서 뺏음.

	
	// 생성자로 난수 만들어서 ranNum 만들고
	
	public Baseball() {
		
		this.ranNum = creatRandomArray(); 
		// 테스트용 코드
		System.out.println(ranNum[0]+""+ranNum[1]+""+ranNum[2]);
		//만들어진 난수 호출때마다 고정인지 아닌지 실험 필요
		//강사님은 외부에서 만든 배열을 인자로 받아 카피함.
		// this.com = Arrays.copyOf(com, com.length);
	
	}
	
	public void baseballReStart() {
		this.ranNum = creatRandomArray(); 
		this.playCnt = 1;
	}
	
	
	public int[] creatRandomArray() {
		int min =1, max = 9, size = 3;
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
	
	public boolean contains(int num, int[] arr) {
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
	
	public static int random(int min, int max) {
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max-min+1)+min);
	}
	
	public int[] judge(int[] pit) {
		int[] judge = new int [3]; // S B O
		int strike =0, ball = 0;
		for (int i = 0; i < pit.length; i++) {
			for (int j = 0; j < ranNum.length; j++) {
				if (pit[i] == ranNum[j]) {
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
		playCnt++;
		return judge ;
	}
	
public void printJudge(int[] arr) {
		
		System.out.println(arr[0]+ " Strike!");
		System.out.println(arr[1]+ " Ball!");
		System.out.println(arr[2]+ " Out!");
		
	}
public int getPlayCnt() {
	return this.playCnt;
}

// contains 없는 코드
/*private void getStrike() {
	int count = 0;
	int size = com.length< user.lenght ? com.length : user.length;
}

*/
// 강사님 깃헙 보고 강사님 파일도 받아두기
}