package weekend_homework4;

import lombok.Data;

@Data
public class Student {
	String st_num;
	String st_name;
	int st_semester;
	String st_state;
	String st_pr_num;
	
	public Student(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
	}
	
	
	
	
	
}
