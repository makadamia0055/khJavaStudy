package day14;

public class ThrowEx01 {

	public static void main(String[] args) {
		/* throws : 메소드가 실행됐을 때 발생할 수 있는 예외를 표시
		 * 			여러개 가능
		 * 			RuntimeException과 자식 예외 클래스들은 생략가능
		 * 			그 외 예외 클래스들은 생략 불가능
		 * throw : 예외를 발생시킴. 
		 * 			원래 예외가 발생하는 상황이 아닌데 얘가 의도적으로 예외를 만듦.
		 * 			예외 객체를 던져줌. 
		 * 			throw를 통해 예외가 발생하면 메소드를 빠져나옴.
		 * */ 
		
		//System.out.println(mod(1,0));
		try{
			throwTest();
		}catch(Exception e){
			System.out.println("예외발생");
			
		}

	}
	
	public static int mod(int num1, int num2) throws ArithmeticException {
		return num1%num2;
	}
	public static void throwTest() throws Exception { // 런타임예외의 자식클래스가 아니기때문에 무조건 throws로 표시해줘야
		throw new Exception(); // 객체를 던져줘야하기 때문에 new를 통해 만듦.
	}

}
