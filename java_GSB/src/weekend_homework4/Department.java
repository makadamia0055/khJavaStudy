package weekend_homework4;

import lombok.Data;

@Data
public class Department {
	String de_num;
	String de_name;
	String de_address;
	String de_tel;
	String de_pr_num; // 학과장 null 가능
	
	
	
	
	public Department(String de_num, String de_name, String de_address, String de_tel, String de_pr_num) {
		this.de_num = de_num;
		this.de_name = de_name;
		this.de_address = de_address;
		this.de_tel = de_tel;
		this.de_pr_num = de_pr_num;
	}




	public Department() {
		super();
	}
	
	
	
}
