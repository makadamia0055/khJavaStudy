package day24;

import java.io.Serializable;

import lombok.Data;
@Data
public class Student implements Serializable, Comparable<Student> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3926074737545945152L;
	private String name;
	private int grade;
	private int classNum;
	private int num;
	
	public Student(String name, int grade, int classNum, int num) {
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}

	public void print() {
		System.out.println(grade+"학년 "+classNum + "반 "+ num+ "번 " + name);
		
	}

	@Override
	public int compareTo(Student o) {
		if(this.grade -o.grade<0 ) {
			return -1;
		} else if(this.grade - o.grade>0) {
			return 1;
		} else {
			if(this.classNum-o.classNum<0) {
				return -1;
			}else if(this.classNum-o.classNum>0) {
				return 1;
			}else {
				if(this.num-o.num<0) {
					return -1;
				}else if(this.num-o.num>0) {
					return 1;
				}else {
					return 0;
				}
			}
		}
	}
	
	
	
	
}
