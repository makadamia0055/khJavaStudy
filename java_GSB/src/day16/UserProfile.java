package day16;

import lombok.Data;

@Data
public class UserProfile {
	//아이디, 비번, 이름, 나이, 주민번호
	private String id, pw;
	private String name;
	private int age;
	private String ssn;
	
	public UserProfile(String id, String pw, String name, int age, String ssn) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}
	
	public UserProfile(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Id : " + id + " Password : " + pw + " 이름 : " + name + " 나이 : " + age + " 주민번호 : " + ssn;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	

}
