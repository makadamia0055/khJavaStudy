package weekend_homework3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

@Data
public class Member extends Client implements Qualifiable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8963687747508245309L;
	
	private String id;
	private String pw;
	
	
	Member(ArrayList<Member> list){
		this.id = setId(list);
		this.pw = setPw();
	}

	private String setPw() {
		System.out.println("비밀번호는 입력하십시오.");
		do { System.out.println("비밀번호는 6~12자의 영문 대소문자와 숫자만 가능합니다.");
			String reg = "[\\w]{6,12}";
			Scanner scan = new Scanner(System.in);
			String pw = scan.next();
			if(java.util.regex.Pattern.matches(reg, pw)) {
				return this.pw = pw;
			}else {
				System.out.println("비밀번호의 조건이 맞지 않습니다.");
			}
		
		}while(true);
	}

	private String setId(ArrayList<Member> list) {
		System.out.println("아이디를 입력하십시오.");
		do { System.out.println("아이디는 6~12자의 영문 대소문자와 숫자만 가능합니다.");
			String reg = "[\\w]{6,12}";
			Scanner scan = new Scanner(System.in);
			String id = scan.next();
			if(java.util.regex.Pattern.matches(reg, id)) {
				boolean exist = false;
				for(Member tmp : list) {
					if(tmp.getId().equals(id)) {
						exist =true;
						break;
					}
				}
				if(exist) {
					System.out.println("이미 가입된 아이디입니다.");
					
				}else {
					return id;
				}
				
			}else {
				System.out.println("아이디의 조건이 맞지 않습니다.");
			}
		
		}while(true);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
