package day07;

public class MethodEx05 {

	public static void main(String[] args) {
			// 1~10까지 합을 구하는 코드 단 메소드를
	// 출력코드를 메인에 넣는 것을 지향하고, 메소드에 직접 넣는 것을 지양하기
	System.out.println(sumByNum(10, 1, 1));
	System.out.println(sumByNum(10, 1));
	System.out.println(sumByCount(1, 9, 1));
	System.out.println(sumByCount(1, 9));

	SumByNum sbn = new SumByNum(10, 1, 1);
	System.out.println(sbn.sumByNum());
	
	}
	
	//기능 1부터 10까지 합 반복문
	//매개변수 (시작값), 끝값, (증감값)
	//리턴 sum int
	//매소드명 sumByNum
	
	public static int sumByNum(int init, int end, int n) {
		if(init>end) {
			int tmp = init;
			init = end;
			end = tmp;
		}
		int sum = 0;
		for(int i = init; i<=end; i+=n) {
			sum+=i;
		}
		return sum;
	}
	public static int sumByNum(int init, int end) { //메소드 오버로딩
		if(init>end) {
			int tmp = init;
			init = end;
			end = tmp;
		}
		int sum = 0;
		for(int i = init; i<=end; i++) {
			sum+=i;
		}
		return sum;
	}
	
	public static int sumByCount(int init, int count, int n) {
		int sum = 0;
		for(int i= init; i<=init+(count)*n; i+=n) {
			sum+=i;
			
		}
		return sum;
	}
	public static int sumByCount(int init, int count) {
		int sum = 0;
		for(int i= init; i<=init+(count); i++) {
			sum+=i;
			
		}
		return sum;
	}
	

}
