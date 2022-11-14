package day16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {

	public static void main(String[] args) {
		HashMap<String, String> userList = new HashMap<String, String>();
		//맵은 key와 value로 이루어져있음.
		userList.put("id1", "pw1");
		userList.put("id2", "pw2");
		userList.put("id3", "pw2");
		userList.put("id2", "pw3"); // 키 값은 중복이 안됨.
									// 그래서 키 값을 중복으로 하고 넣으면
									// 덮어쓰기가 일어남
			// map는 순서를 보장하지 않는다.


		System.out.println(userList);

		//map에서 key 값과 value값 얻는 방법
		
		//맵의 get메소드는 key 값을 바탕으로 value값을 얻는다.
		
		//방법 1. keySet을 이용
		//keySet()은 map에 있는 key들을 하나의 set에 담아 반환하는 메소드
		Set<String> keySet = userList.keySet();
		for(String tmp: keySet) {
			System.out.println(tmp + " : " + userList.get(tmp));
		}
		
		//방법2. EntrySet을 이용
		Set<Entry<String, String>> entrySet = userList.entrySet();
		//Entry => key와 객체로 구성된 하나의 클래스
		for(Entry<String, String> tmp: entrySet) {
			System.out.println(tmp.getKey() + " : " + tmp.getValue());
			
		}
	}

}
