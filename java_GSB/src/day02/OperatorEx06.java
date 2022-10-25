package day02;

public class OperatorEx06 {
	public static void main(String[] args) {
		/* 논리연산자
		 * && : 둘다 참이면 참, 나머진 거짓
		 * 		~이고, ~라고
		 * || : 둘 다 거짓이면 거짓, 나머진 참
		 * 		~이거나, 
		 * ! : 반대 . ~가 아닌
		 *  
		 */
		int score = 85;
		boolean isB; 
		//score가 80점 이상이고, score가 90점 미만인가;
		//score가 80점 이상 && score가 90점 미만;
		isB = (score >=80) && (score < 90);
		System.out.println(isB);
	}

}
