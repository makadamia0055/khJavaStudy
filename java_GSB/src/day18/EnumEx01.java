package day18;

public class EnumEx01 {

	public static void main(String[] args) {
		/*
		 * 제한된 값들을 활용하는 변수가 필요할 때 열거형을 이용함
		 */
		Type type = Type.수입;
		System.out.println("구분 : " + type);

		// 문자열을 그에 해당하는 값의 열거형으로 변환하는 
		type = Type.valueOf("수입");
		
		System.out.println("구분 : " + type);
		
	}

}

enum Type{ 수입, 지출 }
//기울어져있음 상수임. 