package day05;

public class WhileEx01 {

	public static void main(String[] args) {
			/*	while(조건식){
			 * 		실행문;
			 * 	}
			 * 
			 *  for문처럼 표현하면
			 *  
			 *  초기화;
			 *  while(조건식){
			 *  	실행문;
			 *  	증감식;(구현할때 이건 만들어 주는 위치인거지 실제로 있는 요소가 아님)
			 *  }
			 *  
			 * continue는 while문에서 조건식으로 건너뜀.
			 * 
			 */
		
		int i = 1; 
		for( i =1 ; i<=5; i++) {
			System.out.print("Hello World!");
		}
		System.out.println();
		i = 1;
		while(i<=5) {
			
			System.out.print("Hello World!");
			i++;
		}
		
		/*
		 * while문에서는 조건식을 생략할 수 없다.
		 * 그래서 while문에서 무한루프를 만들려면 조건식에 true를 넣어주면 된다.
		 *  (c 가 아니라 정수 값은 못씀)
		 * 
		 * 
		 * */
		
		
		
		
	}

}
