package day27;

public class ThreadEx2 {

	public static void main(String[] args) {
		Runnable runnable = new NewThread2();
		Thread t = new Thread(runnable);
		t.start();
		Thread thisThread = Thread.currentThread();
		for(int i = 0; i < 20; i++) {
			System.out.println(thisThread.getName()+" 쓰레드 실행");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}

}
class NewThread2 implements Runnable{ // 이렇게 인터페이스 구현으로 처리하면
		// 쓰레드 클래스로부터 상속 못받으니 다른 메소드를 수행 못함. 
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			System.out.println("쓰레드 실행");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}