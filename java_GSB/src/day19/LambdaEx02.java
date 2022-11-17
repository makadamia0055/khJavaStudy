package day19;

import java.util.function.Consumer;

public class LambdaEx02 {

	public static void main(String[] args) {
		Sum sum = (a, b) -> a+b;  
		// 타입 생략 가능
		System.out.println(sum.run(1, 2));	
		// 인터페이스의 메소드를 오버라이딩해주는 역할을 하기 때문에 타입 생략 가능
		// 실행문이 1개인 경우 {} 생략 가능
		// 다만 실행문이 return인 경우 {} 생략은 가능하나 이때 return도 같이 생략해야함.
		
		Print<String> print = num -> System.out.println(num);
		// 매개변수가 1개인 경우 () 생략 가능
		print.run("10");
		Consumer<String> print2 = str2-> System.out.println(str2);
		print2.accept("10");
	}	
}

interface Sum{
	double run(double a, double b);
}

interface Print<T>{
	void run(T num);
}