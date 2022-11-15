package day17;

import lombok.Data;

@Data
public class Member {
	
	private String pw, name, ResidentNumber;
	private int age;// map를 이용할 때는 equals를 오버라이딩 할 필요 없다.
	
	
	public Member(String pw, String name, String residentNumber, int age) {
		super();
		this.pw = pw;
		this.name = name;
		ResidentNumber = residentNumber;
		this.age = age;
	}


	@Override
	public String toString() {
		return " 비밀번호 : " + pw + " 이름 : " + name + " 주민번호 : " + ResidentNumber + " 나이 : " + age;
	}
	
	
	
	
	
}
