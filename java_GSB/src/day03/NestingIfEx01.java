package day03;

public class NestingIfEx01 {
	public static void main(String[] args) {
		//중첩 if문을 이용한 236의 배수 예제
		
		int num = 6;
		
		if(num %2==0) {
			if(num %3 ==0){
				System.out.println(num + "는 6의 배수 입니다.");
			} 
			else {
				System.out.println(num+ "는 2의 배수입니다.");
			}
		} 
		else if(num%3==0) {
			System.out.println(num+ "는 3의 배수입니다.");
		} else {	
			System.out.println(num+ "는 2, 3, 6의 배수가 아닙니다.");
		}

	}

}
