package weekend_homework4;

import lombok.Data;

@Data
public class Lecture {

	int le_num;
	String le_pr_num;
	String le_name;
	String le_current_capa;
	String le_schedule;
	int le_point;
	int le_year;
	int le_term;
	int le_class;
	
	public Lecture(int le_num, String le_pr_num, String le_name, String le_current_capa, String le_schedule,
			int le_point, int le_year, int le_term, int le_class) {
		this.le_num = le_num;
		this.le_pr_num = le_pr_num;
		this.le_name = le_name;
		this.le_current_capa = le_current_capa;
		this.le_schedule = le_schedule;
		this.le_point = le_point;
		this.le_year = le_year;
		this.le_term = le_term;
		this.le_class = le_class;
	}
	
	
	
}
