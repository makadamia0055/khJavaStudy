package day03;

public class IfEx03 {
	public static void main(String[] args) {
		/* if(조건식 1){
		 * 			실행문1;
		 * 	}
		 *  else if (조건식 2){
		 *  		실행문2;
		 *  }
		 *  else
		 *  {
		 *  		실행문3;
		 *  }
		 *  
		 *  if : 반드시 필요, 조건문을 시작, if조건문에서는 무조건 1개 존재
		 *  else if : 필요한 만큼(0개 이상)
		 *  else : 0~1개 
		 */
		// 정수가 양수, 음수, 0인지 판별하는 코드를 작성
		int num = -10;
		
		if(num>0) {
			System.out.println(num+"은 양수");
		} else if (num == 0) {
			System.out.println(num+" 은 0");
		} else {
			System.out.println(num + "은 음수");
		}
		
		
		
		
		
		
	}

}
