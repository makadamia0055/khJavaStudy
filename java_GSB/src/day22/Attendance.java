package day22;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import lombok.Data;

@Data
public class Attendance {
	private String date;
	//private HashMap<Student, Character> stdmap = new HashMap<Student, Character>();
	private ArrayList<StdAtd> stdatdList = new ArrayList<StdAtd>();
	
	


	public Attendance(String date, ArrayList<Student> stdList) {
		this.date = date;
		for(Student tmp : stdList) {
			this.stdatdList.add(new StdAtd(tmp));
			
		}
	}
	public boolean scanArray() {
		if(this.stdatdList!=null&&this.stdatdList.size()!=0) {
			System.out.println("출석 : O, 지각 : L, 조퇴 :E , 결석 : X ");
			for(StdAtd tmp : stdatdList) {
				updateAtd(tmp);
			}
			return true;
		}else{
			return false;
		}
	}
	public void updateAtd(StdAtd tmp) {
		System.out.println(tmp.getStd().getName()+" 학생의 출결 :");
		Scanner scan = new Scanner(System.in);
		char tmpch = scan.next().toUpperCase().charAt(0);
		tmp.setAtd(tmpch);
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}


	public Attendance searchByDate(String date) {
		if(this.date.equals(date)) {
			return this;
		}else {
			return null;
		}
		
	}
	public void printByName(String name) {
		for(StdAtd tmp : stdatdList) {
			if(tmp.getStd().getName().equals(name)) {
				System.out.println(this.date+" : "+ tmp.getAtd());
			}
		}
	}
	
	public void print() {
		System.out.println("일자 : " +date);
		for(StdAtd tmp : stdatdList) {
			System.out.println(tmp);
		}
		
	}
	
	
}
