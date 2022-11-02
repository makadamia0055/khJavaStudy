package day08;

class Point{
	private int x, y;
	
	public Point(){
		x = 3; 
		y = 3; 
	}
	
	public Point(int x1, int y1) { //생성자 오버로딩
		x = x1;
		y = y1;
	}
	public Point(Point pt) { //복사 생성자 // 복사생성자도 생성자 오버로딩
		x = pt.x;
		y = pt.y;
		
	}
	
	
	
	public void print() {
		System.out.println("좌표 : " + x+","+y);
	}
	
	public void move(int x1, int y1) {
		x = x1; 
		y = y1;	
		
	}
	
}
/* 좌표평면의 점을 나타내는 클래스
 * 필드 int x, int y;
 * 
 * -메소드 get, set, 프린트 (x, y)
 * 
 * 
 */


public class ClassEx01 {
	/*
	 * 클래스 앞 접근 제한자 public은 조건부로 올 수 있다.
	 * 클래스 명과 파일명이 동일해야 public을 붙일 수 있다. 
	 * => public 클래스는 다른 조건이 없는 한 기본적으로 한 파일당 하나만 만들 수 있다.
	 * 
	 */
	public static void main(String[] args){
		Point pt = new Point();
		pt.print();
		
		Point pt1 = new Point(3, 1);
		pt1.print();
		//복사 생성자 호출
		Point pt2 = new Point(pt1);
		pt2.print();
	}
	
	
	
	
}
