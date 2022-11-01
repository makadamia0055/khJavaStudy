package day07;



class Person{
 // 접근제한자 자료형 변수명;	// 멤버 변수
	/*
	 * 접근 제한자 종류
	 * private	: 본인 클래스 내부에서만 사용 가능  
	 * (default): 본인 클래스와 같은 패키지 안에서 호출 가능. 생략가능
	 * protected: 본인 클래스, 같은 패키지, 상속관계 자식 클래스
	 * public 	: 본인 클래스, 같은 패키지, 상속관계 자식 클래스, 외무 = 전부
	 */
	
	private String pno; // 일반적으로 멤버변수는 private 을 쓴다.
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// 그래서 private 멤버변수에 접근하기 위해서 set/get 메소드를 만들어준다.
	// 이클립스에서는 get/set 함수 쉽게 만드는 방법 있음
	//클래스 블럭 안에서 우클릭-source-generate getter and setter.... 선택
	
}







public class ClassTestEx01 {
	public static void main(String[] args) {
		/*
		 *  인스턴스화 방법
		 *  클래스명 객체명(참조변수명) = new 클래스명();
		 */
		String str = new String("abc");
		Person person1 = new Person();
		//name에 private를 추가하기 전에는 외부에서 접근이 가능했지만
		//person1.name = "홍길동"; // 접근제한자를 바꾸면서 접근불가됨
		person1.setName("홍길동"); //메소드를 이용한 접근으로 변경
		
		System.out.println(person1.getName());
		System.out.println(str.charAt(0));
		
		
		
		
	}

	
	
	
	
	
	
	
}
