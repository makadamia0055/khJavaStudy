package day14;

public class TryCatchEx01 {

	public static void main(String[] args) {
		/*
		 *  try{
		 *  		예외가 발생할 수 있는 영역
		 *  }catch(예외클래스1 e){
		 *  	예외처리;
		 *  }catch(예외클래스2 e){
		 *  	예외처리;
		 *  }finally{
		 *  	실행문;
		 *  }
		 *  -try, catch는 필수
		 *  -catch는 1개 이상
		 *  -catch가 여러개인 경우 위에 있는 예외 클래스는 아래 클래스의 조상 클래스가 오면 안됨.
		 *  예 : 예외 클래스1에 RuntimeException이 오고, 
		 *  	예외클래스2에 ArithmeticException이 오면 안됨.
		 *  조상클래스가 더 큰 범위이기 때문에 미리 다 처리해버리기 때문. 
		 *  그래서 세부적 처리 클래스는 범용 클래스보다 앞에 배치 
		 *  -finally 는 선택(여러개는 불가능)
		 *  
		 *  
		 */
		exception();
		
		
	}
	public static void exception() {
		try { 
			System.out.println(1/0);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누면 안됩니다.");
			return;
		}catch(RuntimeException e) {
			System.out.println("런타임 오류 발생");
			
		}finally {
			System.out.println("메소드 종료"); // return이 실행되도 출력이 됨
		}
		System.out.println("안녕"); // return이 출력되면 실행안됨.
	}
}
