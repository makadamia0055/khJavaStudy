package day05;

public class ForEx01 {

	public static void main(String[] args) {
			/*
			 *  for 문을 사용할 때 종종 나오는 실수
			 *  
			 *  잘못된 ; 삽입에 의한 실수
			 *  
			 *  아래와 같은 for 문
			 */
		
			int i ;
			
			for(i = 1; i<=5; i++); 
			{
				System.out.println(i);
			}
			
			//for 문 뒤에 ;를 넣어 for문이 종료되고 그냥 중괄호가 나와 i가 프린트 됨.
			// 아래도 같은 실수
			i = 5;
			if( i % 2== 0);
			{
				System.out.println("짝수");
			}
			//else { } // else도 올 수 없음 앞이 if문이 아니라 
			
			
			// 보통은 조건문, 반복문에서 실행문이 1줄이어서 {}을 생략한 경우 이런 실수 
			// 많이 함.
			
			for(i =1 ; i<= 5; i++);
			System.out.println(i); //이렇게
			
			// 그 다음에는 괄호 실수 
			// 들여쓰기 중요
			
	}

}
