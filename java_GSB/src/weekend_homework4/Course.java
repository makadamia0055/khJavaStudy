package weekend_homework4;

import lombok.Data;

@Data
public class Course {
	String co_num ;
	String co_le_num;
	String co_st_num;
	String co_type;
	String co_grade;
	
	public Course(String co_num, String co_le_num, String co_st_num, String co_type, String co_grade) {
		this.co_num = co_num;
		this.co_le_num = co_le_num;
		this.co_st_num = co_st_num;
		this.co_type = co_type;
		this.co_grade = co_grade;
	}

	public Course() {
		super();
	}
	
	
	
}
