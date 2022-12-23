package weekend_homework4;

import lombok.Data;

@Data
public class Professor {

	String pr_num;
	String pr_name;
	String pr_tel;
	String pr_de_num;
	String pr_state;
	
	public Professor(String pr_num, String pr_name, String pr_tel, String pr_de_num, String pr_state) {

		this.pr_num = pr_num;
		this.pr_name = pr_name;
		this.pr_tel = pr_tel;
		this.pr_de_num = pr_de_num;
		this.pr_state = pr_state;
	}
	
	
	
	
}
