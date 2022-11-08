package day12;

public class InterfaceEx01 {
	public static void main(String[] args) {
		
		//인터페이스를 통해서 객체를 생성할 수 없다.
		//TvRemoteController tr = new TvRemoteController(); 
		// 하지만 인터페이스 참조 변수에 객체를 저장할 수 있다.
		// 구현 클래스 객체를 인터페이스 참조변수에 저장할 수 있다.
		TvRemoteController remocon1 = new TvRemoteconA();
		//remocon1.print(); 하지만 인터페이스 말고 구현 클래스에만 선언, 구현된 메소드에 접근 불가능
		
		((TvRemoteconA)remocon1).print();
		// 그래서 다운캐스팅 해줘야됨.
		
		TvRemoteconA remocon2 = new TvRemoteconA();
		remocon2.turn();
		for(int i = 0; i<10; i++) {
			remocon2.channelUp();
		}
		for(int i = 0; i<2;i++) {
		remocon2.channelDown();
	}
		remocon2.channel(15);
		
		for(int i = 0; i<2; i++) {
			remocon2.volumeUp();
		}
		for(int i = 0; i<2; i++) {
			remocon2.volumeDown();
		}
		
		
		
		
		remocon2.print();
		
		
	}
	
}


