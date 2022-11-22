package day22;

public class ThreadEx02 {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드 명 : " + t.getName());
	
		//Thread t2 = new Thread(new Thread02());
		//t2.start(); // Thread의 생성자 활용
		
		//람다식 활용
		Thread t2 = new Thread(()->{
			for(int i = 0 ; i < 10000; i++) {
				System.out.println("-");
			}
		}); // 생성자에 람다식으로 익명 클래스 객체 활용
		
		
		
		for(int i = 0; i<10000; i++) {
			System.out.print("|");
		}
		
	}
}
class Thread02 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i<10000; i++) {
			System.out.println("-");
		}
		
	}
	
	
	
	
	
}