package day11;

public class InheritanceEx02 {

	public static void main(String[] args) {
		KiaCar kcar = new KiaCar(4, "k5", "0xff0000", 12345);
		kcar.powerON();
		kcar.changeGear('d');
		kcar.info();
		for(int i = 0; i<30; i++) {
			kcar.accelerator();
		}
		for(int i = 0; i<30; i++) {
			kcar.breaker();
		}
		kcar.changeGear('p');
		kcar.powerOff();
		kcar.info();
		HyundaiCar hcar = new HyundaiCar(4, "k5", "0xff0000", 12345);
		hcar.powerON();
		hcar.changeGear('d');
		hcar.info();
		for(int i = 0; i<30; i++) {
			hcar.accelerator();
		}
		for(int i = 0; i<30; i++) {
			hcar.breaker();
		}
		hcar.changeGear('p');
		hcar.powerOff();
		hcar.info();
		
		
	}

}
/* 
 * 자동차 클래스(Car), 타이어(Tire) 클래스
 * 기아자동차(KiaCar) 클래스, 현대자동차(HyundaiCar) 클래스를 만들어 보세요
 */

class Car { // 타이어, 차종, 색상, 번호, 전원(시동), 속력, 기어, 제조사, 타이어 수
	public Tire[] tires;
	public int tireCount;
	public String model;
	public String color;
	
	public int carNum;
	public String company;
	public boolean power;
	public int speed;
	public char gear;
	

	public Car(int tireCount, String model, String color, int carNum, String company) {
		this.tireCount = tireCount<=0?4:tireCount;;
		this.model = model;
		this.color = color;
		this.carNum = carNum;
		this.company = company;
		this.gear = 'P';
		tires = new Tire[tireCount];
	}


	public Car() {

	}
	// 전원 켜기/ 끄기, 기어 변경, 속력 업/다운
	
	public void powerON() {
		power = true;
	}
		
	
	public void powerOff(){
		power = false;
	}
	public void changeGear(char gear){
		if(gear=='P'&& speed!=0) {
			return;
		}
		this.gear = gear;
	}
	
	public void accelerator() {
		
		speed+=1;
	}
	public void breaker() {
		
		speed-=1;
		if(speed<0) {
			speed = 0;
		} //speed = speed<= 0 ? 0 : speed-1;
	}
	
	public void info() {
		System.out.println("전원 : " + (power? "on" : "off"));
		System.out.println("속력 : " + speed);
		System.out.println("기어 : " + gear);
		System.out.println("회사 : " + company);
		System.out.println("차종 : " + model);
	}
	
	
	
	
}

class Tire { // 제조사, 크기, 종류, 상태
public String company;
public int size;
public boolean isSnow;
public boolean isStop;
	
	public Tire() {
	}
	
	public void print() {
		if(isStop) {
			System.out.println("정지해있습니다.");
		}else {
			System.out.println("굴러가는 중입니다.");
		}
	}
	
	// 상태 출력
	
}

class KiaCar extends Car {

	public KiaCar(int tireCount, String model, String color, int carNum) {
		super(tireCount, model, color, carNum, "기아");
		// TODO Auto-generated constructor stub
	} // 제조사가 기아
	public void hand() {
		System.out.println("트렁크가 수동입니다.");
	}
}



class HyundaiCar extends Car {

	public HyundaiCar(int tireCount, String model, String color, int carNum) {
		super(tireCount, model, color, carNum, "현대");
		// TODO Auto-generated constructor stub
	} // 제조사가 현대
	public void auto() {
		System.out.println("트렁크가 자동입니다.");
	}
 
}