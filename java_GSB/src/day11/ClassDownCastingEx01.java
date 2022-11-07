package day11;

public class ClassDownCastingEx01 {

	public static void main(String[] args) {
		/*
		 * 클래스 다운 캐스팅은 조건부로 가능
		 * 안되는 경우 : 부모 클래스의 객체를 바로 자식 클래스의 객체에 저장하는 경우
		 */
		
		//KiaCar kcar = (KiaCar) new Car(4, "k5", "흰색", 1234, "기아");
		//kcar.info();
		
		KiaCar kcar1 = new KiaCar(4, "k5", "흰색", 1234);
		Car car = kcar1;
		// Car car = new KiaCar(4, "k5" , "흰색", 1234)
		KiaCar kcar2 = (KiaCar)car;
		kcar2.info();
		//되는 경우 : 자식 클래스의 객체ㅐ를 부모 클래스의 객체에 저장한 후 다시 자식
		// 클래스의 객체로 저장하는 경우
		Car[] carList = new Car[5];
		carList[0] = new KiaCar(4, "k5", "흰색", 1234);
		carList[1] = new HyundaiCar(4, "쏘나타", "검은색", 2313);
		for(Car tmp : carList) {
			if(tmp instanceof KiaCar) {
				((KiaCar) tmp).hand();
			}else if(tmp instanceof HyundaiCar) {
				((HyundaiCar) tmp).auto();
			}
		}
		
	}

}
