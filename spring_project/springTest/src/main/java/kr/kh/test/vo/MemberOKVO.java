package kr.kh.test.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberOKVO {
	String mo_me_id;
	String mo_num;
	Date mo_valid_time;
	
	
	public void setMo_valid_time(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date tmp = format.parse(str);
			this.mo_valid_time = tmp;
		} catch (ParseException e) {
			this.mo_valid_time = null;
		}
	}


	public MemberOKVO(String mo_me_id, String mo_num) {
		super();
		this.mo_me_id = mo_me_id;
		this.mo_num = mo_num;
	}
}
