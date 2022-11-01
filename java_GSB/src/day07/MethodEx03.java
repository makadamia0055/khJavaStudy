package day07;

public class MethodEx03 {

	public static void main(String[] args) {
		/*
		 * 주어진 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요
		 * 단 메소드를 활용할 것.
		 */
		int n = 13;
		int m = 15;
		int k = -1;

		MethodEx03 mte3 = new MethodEx03(); // 객체 생성
		System.out.println("정수 "+n+"이 소수 입니까? : " + mte3.isPNum(n));
		System.out.println("정수 "+m+"이 소수 입니까? : " + mte3.isPNum(m));
		System.out.println("정수 "+k+"이 소수 입니까? : " + mte3.isPNum(k));
	}

/* 구현 1
 * 기능 : 정수가 주어지면 소수인지 아닌지 출력하는 메소드
 * 매개변수 : 정수 => int num
 * 리턴타입 : void
 * 메소드명 : printPrimeNumber
 * 
 * 이렇게 정리하는 습관을 들여야 난제를 풀때 좋다.
 * 
 * 
 * 
 * 
 * 구현 2 
 * 기능 : 정수가 주어지면 소수인지 아닌지 판별하는 메소드
 * 매개변수 : 정수 => int num
 * 리턴타입 : boolean
 * 메소드명 : isPrimeNumber
 * 
 * 
 * 
 * 
 * 
 */

		

	public boolean isPNum(int num) { //static 빼고 해보기
		boolean isPrime; 
		int sum = 0;
		if(num<0) { // num 값 무결성 체크
			
			return isPrime=false;
		}
		for(int i =1; i <=num ; i++) {
			if(num%i==0) {
				sum+=i;
			}
		}
		if(sum==num+1) {
			isPrime = true;
		} else {
			isPrime = false;
		}
		return isPrime;
		
	}
	
	
	
}
