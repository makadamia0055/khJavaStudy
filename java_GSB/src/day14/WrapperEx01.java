package day14;

public class WrapperEx01 {

	public static void main(String[] args) {
		int num1 = 1;
		Integer num2 = num1; //박싱boxing
		//num2 = null;
		int num3 = num2; //언박싱unboxing 
		//언박싱 할 때는 조심
		//num2인 Integer 객체를 int로 언박싱하는 경우
		//num2가 null일 수 있어서 조심해야함. 
		//참조변수는 null을 저장할 수있으나 기본변수는 null을 저장할 수 없다.
		System.out.println(num3);
		
		
		// 문자열을 정수로
		String str = "1234";
		System.out.println(str+1);
		int num4 = Integer.parseInt(str);
		System.out.println(num4+1);
		
		// 정수를 문자열로 
		int num5 = 123;
		String str2 = Integer.valueOf(num5).toString();
		System.out.println(str2+1);
		String str3 = ""+num5; //문자열 + 정수는 문자열
		System.out.println(str3+1);
		
	}

}
