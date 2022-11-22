package day22;

import lombok.Data;

@Data
public class Student {

	private String name;
	private int birth;
	
	


	@Override
	public String toString() {
		return  name +" : "+ birth ;
	}




	public Student(String name, int birth) {
		
		this.name = name;
		this.birth = birth;
	}
	
	
	
}
