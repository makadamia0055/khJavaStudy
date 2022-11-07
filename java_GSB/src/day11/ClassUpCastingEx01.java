package day11;

public class ClassUpCastingEx01 {

	public static void main(String[] args) {
		//Car car = new KiaCar(4, "k5", "흰색", 1234);
		// 부모클래스 참조변수 = 자식클래스 객체
		/*
		 * 업 캐스팅은 자동으로 작동
		 */
		//car.info();
		Car[] carList = new Car[5];
		carList[0] = new KiaCar(4, "k5", "흰색", 1234);
		carList[1] = new HyundaiCar(4, "쏘나타", "검은색", 2313);
		
		// 하나의 클래스 타입으로 여러타입의 클래스를 관리할 수 있음. 
	
	}

}
