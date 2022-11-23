package day22_t;

import lombok.Data;

@Data
public class Student {
	private String name;
	private String birthday;
	
	Student(String name, String birthday){
		this.name = name;
		this.birthday = birthday;
	}
	
	Student(Student std){
		this.name = std.name;
		this.birthday = std.birthday;
	}
	
}
