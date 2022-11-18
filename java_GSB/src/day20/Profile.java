package day20;

import java.util.ArrayList;
import java.util.Collections;

import lombok.Data;

@Data
public class Profile implements Comparable<Profile>{
	private String sung;
	private String name;
	private String job;
	private ArrayList<PhoneNumber> numberList = new ArrayList<PhoneNumber>();
	
	public Profile(String sung, String name, String job) {
		super();
		this.sung = sung;
		this.name = name;
		this.job = job;
	}
	
	public Profile(String sung, String name) {
		super();
		this.sung = sung;
		this.name = name;
		
	}
	
	
	public void sortNumberList() {
		Collections.sort(this.numberList);
	}

	@Override
	public int compareTo(Profile o) {
		return this.sung.compareTo(o.sung);
	}
	
	public String getFullName() {
		String tmp = this.sung.concat(name); 
		return tmp;
	}
	
	
	
	
}
