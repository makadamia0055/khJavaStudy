package day09;

public class ClassEx01 {

	public static void main(String[] args) {

		int size = 3; 
		int[] x = new int[size];
		int[] y = new int[size];
		for(int i = 0; i<size; i++) {
			x[i] = i;
			y[i] = i;
		}
		for(int i =0; i<size ; i++) {
			System.out.println(x[i]+ ", "+ y[i]);
		}
		
		Point [] pts = new Point [size]; // Point 객체들을 저장하는 배열 생성
		for(int i = 0; i<size; i++) {
			pts[i] = new Point(i, i); // 좌표 하나를 저장한 Point 객체 생성
		}
		for(Point pt: pts) {
			pt.print();
		}
			
		
		
		
		
		
		
	}

}



class Point{
	private int x, y;
	public Point() { //기본 생성자 
		// 멤버변수의 필드는 기본값으로 초기화가 되기 때문에
			// 0으로 초기화 할 필요는 없음.
	}
	
	public Point(int x1, int y1) {
		x = x1;
		y = y1;
	}
	public void print() {
		System.out.println(x + " , " + y);
	}
	
	public void move(int x1, int y1) {
		x = x1;
		y = y1;
	}
}