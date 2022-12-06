package day32;

public class ExceptionEx01 {

	public static void main(String[] args) {
		try {
			//System.out.println(1/0);
			test();
			// 예외가 발생되는 즉시 후행코드는 실행안하니까 7라인 주석처리 해야함
		}catch(ArithmeticException e) {
			System.out.println("예외 발생 : "+ e.getMessage());
		}catch(Exception e) {
			System.out.println("예외 발생 : "+ e.getMessage());
		}// catch문이 여러개일 경우 순서 조심.

	}
	public static void test() throws Exception{
		//throw new RuntimeException("런타임 예외 발생"); 
		//런타임Exception은 throws 생략가능
		throw new Exception("예외 발생");
	}
}
