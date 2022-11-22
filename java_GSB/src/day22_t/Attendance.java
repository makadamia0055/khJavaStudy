package day22_t;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Attendance {
	private ArrayList<Student> stds = new ArrayList<Student>();
	// 이건 인원변동 반영 된 리스트, 즉 퇴교나 전학 같은거 반영 되어 변화되는 리스트라는 뜻. 
	private ArrayList<Log> logs = new ArrayList<Log>();
	
	
}
