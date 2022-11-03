package day09;

public class ThisEx01 {

	public static void main(String[] args) {
		//this는 해당 클래스를 나타내는 참조변수
		Test03 t1 = new Test03();
		Test03 t2 = new Test03(10);
		t1.print();
		t2.print();
		
		
	}

}
/*
 * this는 클래스 내에서 해당 클래스, 즉 객체본인을 나타내는 참조변수
 * 주로 매개변수의 이름과 필드의 이름이 같으면서 메소드 안에소 동시에 사용될 경우 사용
 * => 메소드에서 매개변수의 이름과 멤버변수(필드)의 이름이 같으면 변수를 호출했을 떄 
 *  	매개변수가 불려짐.
 *  => 메소드명이 길때 자동완성을 위해 사용하기도 한다.
 *  
 *  this() : 해당 클래스의 생성자를 호출할 때 사용, 생성자에서 첫번째 줄에 추가
 *  
*/ 

 class Test03{
	 private int num;
	 
	 public void setNum(int num) {
		 this.num = num;
		 
		 
	 }
	 
	 public Test03() {
		 this(10); //this()생성자는 해당 중괄호의 첫줄에 와야함.
		 //this();는 이 기본생성자 자체를 계속 호출, 무한루프
	 }
	 
	 public Test03(int num) {
		 this.num = num;
	 }
	 
	 
	 
	 public int getNum() {
		 return this.num;
		 
	 }
	 
	 public void print() {
		 System.out.println(this.getNum());
	 }
	 
	 
 }