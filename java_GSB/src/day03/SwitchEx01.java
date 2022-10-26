package day03;

public class SwitchEx01 {
	public static void main(String[] args) {
		/*switch(식 또는 변수명){
		 * 			case 값1:
		 * 						실행문1;
		 * 						break;
		 * 			case 값2:
		 * 						실행문2;		 * 
		 * 						break;
		 * 			default:
		 * 						실행문3;
		 * }
		 * 
		 *   => case 옆에 있는 값들은 정수, 문자, 문자열만 올 수 있다. 변수 명은 올 수 없다
		 *   	상수(리터럴 + final 변수)
		 *   => break 문은 switch문을 빠져나가는 역할을 한다.
		 *   => break 문이 없으면 switch문을 빠져나가지 못하고 다음 실행문으로 넘어간다.
		 *   => 여러 경우를 같이 처리하고 싶으면 
		 *   case 값 1, 값 2, 값 3, ..... 이렇게 묶어 처리 가능;
		 *  => default : 해당하는 케이스가 없을 경우 기본값. (if문의 else와 같음, 생략가능)
		 *  => switch문 사용하는 경우
		 *  1. 식의 값이 제한적일 때: % 연산자와 찰떡궁합
		 *  2. 사용하는 변수값이 제한적일때 : 산술연산자를 이용한 계산 예제
		 *  장점 : 코드가 간결, 가독성
		 * 
		 */
		
		int num = 0;
		switch(num%2) {
		case 0: System.out.println("짝");
		break;
		default:
			System.out.println("홀");
		
		//case 1: System.out.println("홀");
		//break;
		}
		
		
		
		
		
	}

}
