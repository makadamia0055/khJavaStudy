package day11;

public class PolymorphismEx01 {

	public static void main(String[] args) {

		
		
	}

	
	
	// 세 타입에 대한 한 메소드를 쓰고 싶을때
	// 메소드를 오버로딩해서 써야한다 매우 불편
	/*public static void connectToComputer(Mouse obj) {
		System.out.println("마우스와 연결되었습니다.");
		
	}
	public static void connectToComputer(Keyboard obj) {
		System.out.println("마우스와 연결되었습니다.");
		
	}
	public static void connectToComputer(Speaker obj) {
		System.out.println("마우스와 연결되었습니다.");
		
	}*/
	/* 매개변수의 다형성
	 * 매개변수로 부모 클래스의 객체를 전달하여, 
	 * 같은 부모를 가진 자식 클래스 객체를 매개변수로 활용할 수 있에 하는 것
	 */
	public static void connectToComputer(UsbProduct obj) {
		System.out.println(obj.type+"와 연결되었습니다.");
		
	}
	
	
}

class UsbProduct{
	public String type;
}

class Mouse extends UsbProduct{
	{
		type = "마우스";
	}
}
class KeyBoard extends UsbProduct{
	{
		type = "키보드";
	}
}
class Speaker extends UsbProduct{
	{
		type = "스피커";
	}
}