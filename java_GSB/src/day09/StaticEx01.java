package day09;

public class StaticEx01 {

	public static void main(String[] args) {
		//Math.random(); // random 같은 static 메소드는 객체없이 호출됨
		//ClassEx01.main(null); // static으로 다른 main 클래스 호출하는 예제 
		
		KiaCar k1 = new KiaCar("모닝");
		KiaCar k2 = new KiaCar("레이");
		KiaCar k3 = new KiaCar("k3");
		
		k1.print();
		k2.print();
		k3.print();
		k1.name = "k5";
		k1.logo = "kia"; // static 키워드가 들어간 변수들은 인스턴스 명으로 호출 할 수 있으나
		KiaCar.logo = "kkiiaa"; // 이렇게 클래스 명으로 바꿔주는게 더 바람직.
		
		System.out.println("------------");
		k1.print();
		k2.print();
		k3.print();
		
		
	}

}


class KiaCar{
	public static String logo = "KIA";
	public String name;
	
	public KiaCar(String name) {
		this.name = name;
	}
	public void print() {  
		System.out.print(logo);
		System.out.println(" : " + name); 
	}
	public static void printlogo() { // 여기 static를 붙이면 name에 에러가 뜸 
		System.out.print(logo);
		// System.out.println(" : " + name); //name은 인스턴스 필드이기 때문
	}
}