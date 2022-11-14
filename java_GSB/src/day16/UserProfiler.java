package day16;

import java.util.HashMap;
import java.util.Scanner;

public class UserProfiler {
	private HashMap<String, UserProfile> userMap = new HashMap<String, UserProfile>();
	Scanner scan;
	
	
	
	
public UserProfiler(Scanner scan){
		if(scan==null) {
			this.scan =new Scanner(System.in); 
		}
			this.scan = scan;
	}

public void addProfile(String id, String pw) {
		if(findUser(id)==null) {
		
		this.scan = new Scanner(System.in);
		userMap.put(id ,new UserProfile(id, pw));
		}
	}
	
public void addProfile(String id, String pw, String name, int age, String ssn) {
if(findUser(id)==null) {
		
		this.scan = new Scanner(System.in);
		userMap.put(id ,new UserProfile(id, pw, name, age, ssn));
		}
}

public void printInfo(String id) {
	
	if(verifyPw(id)) {
		UserProfile tmpUserProfile = userMap.get(id);
		System.out.println(tmpUserProfile);
	}else {
		System.out.println("비밀번호가 틀렸습니다.");
	}
	
	
}

public boolean verifyPw(String id) {
	UserProfile tmpUserProfile = userMap.get(id);
	//테스트용 코드
	System.out.println("test : "+tmpUserProfile.getPw());
	System.out.println("열람하실 계정의 비밀번호를 입력해주세요.");
	String inputPw = scan.next();
	scan.nextLine();
	if(inputPw.equals(tmpUserProfile.getPw())) {
		return true;
	}else {
		return false;
	}
}






	/**
 * @return the userMap
 */
public HashMap<String, UserProfile> getUserMap() {
	return userMap;
}

	public UserProfile findUser(String id) {
		if(userMap.containsKey(id)) {
			return userMap.get(id);
		}
		else {
			return null;
		}		
	}
}
