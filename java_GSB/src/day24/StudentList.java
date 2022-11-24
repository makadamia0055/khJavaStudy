package day24;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class StudentList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4443392594801386691L;
	private ArrayList<Student> list = new ArrayList<Student>();
	
	
	StudentList(ArrayList<Student> list){
		this.list = list;
	}


	public StudentList() {
	}
	
	
	
}
