package day02;

public class TypeCastingEx01 {
	public static void main(String[] args) {
		//접미사 f(F)가 없는 실수 리터럴은 double형(lf가 생략된)이다.
		//1.23은 8바이트인 double이고 , float인 num1은 4바이트이기 때문에
		//자동 형변환이 불가능하다. - > 접미사를 붙이거나 강제형변환
		float num1 = (float)1.23;
		
		long num2 = 3; // 정수 리터럴은 자료형에 맞는 타입으로 설정됨.
		// 사실 int도 시스템 의존형이니까
		byte num3 = 3;
		int num4 = (int)12345678901L; //out of range 에러가 나오지만 L을 붙여서 에러 없애고, 강제 int화
		System.out.printf("%d,\n %d", num2, num3);
		
		}
}
