package day21;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PhoneBook {
	private String name;
	private String company;
	private ArrayList<PhoneNumber> pnList;
	
	
	public PhoneBook(String name, String company, ArrayList<PhoneNumber> pnlist) {
		this.name = name;
		this.company = company;
		this.pnList = pnlist;
		
	}
	public void print() {
		System.out.println("=========================");
		System.out.println("성명 : "+this.name);
		System.out.println("직장 : " + company);
		for(PhoneNumber tmp : pnList) {
			System.out.println(tmp);
		}
		System.out.println("=========================");

	}
	public void update(String editName, String editCompany) {
		this.name = editName;
		this.company = editCompany;
	}
	
	
	
}
