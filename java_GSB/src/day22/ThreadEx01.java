package day22;

public class ThreadEx01 {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("현재 쓰레드 명 : " + t.getName());
	
		Thread01 t1 = new Thread01();
		t1.start(); // run()을 직접 실행하는 것이 아니라 start()로 실행
		for(int i = 0; i<10000; i++) {
			System.out.print("|");
		}
		
	}
}
class Thread01 extends Thread{
	
	@Override
	public void run(){
		for(int i = 0; i<10000; i++) {
			System.out.print("-");
			
		}
		
	}
	
	
	
}