package day22_t;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Attendance {
	private ArrayList<Student> stds = new ArrayList<Student>();
	// 이건 인원변동 반영 된 리스트, 즉 퇴교나 전학 같은거 반영 되어 변화되는 리스트라는 뜻. 
	private ArrayList<Log> logs = new ArrayList<Log>();
	
	// 만약 logs에서 입력된 date에 이미 해당 date로 객체가 존재할 떄 
	
	// 생성자에서 먼저 finddate를 구현한 후 있으면 그걸 리턴. 
	// 생성페이지에서는 리턴이 !=이면 이미 페이지 있다고 하고 수정으로 넘기고
	
	
}
