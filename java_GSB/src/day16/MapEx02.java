package day16;

import java.util.HashMap;

import lombok.Data;

public class MapEx02 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", new UserProfile("abc", "def"));
		map.put("age", 22);
		map.put("address", "서울시");
		System.out.println(map.get("user"));
		System.out.println(map.get("age"));
		System.out.println(map.get("address"));
		System.out.println(map.get("fmfmkds")); // 없는 키로 get하면 null
	}

}
@Data
class User { 
	private String id, pw;
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}
