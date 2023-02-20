package kr.kh.test.vo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	String me_id;
	String me_pw;
	String me_email;
	Date me_birthday;
	int me_authority;
	Date me_join_time;
	
		
	public void setMe_birthday(String str){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.me_birthday = df.parse(str);
		} catch (ParseException e) {
			me_birthday  = null;
		} 
	}
	
}
