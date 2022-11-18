package day20;

import lombok.Data;

@Data
public class PhoneNumber implements Comparable<PhoneNumber>{
	private String numbername;
	private String number;
	
	
	public PhoneNumber(String numbername, String number) {
		super();
		this.numbername = numbername;
		this.number = number;
	}
	
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number)) 
			if(!stripNum(number).equals(stripNum(other.number))) 
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	
	public String stripNum(String num) {
		String tmp = new String(num.substring(4));
		num.replaceAll("-", "");
		num.replaceAll(" ", "");

		return tmp;
	}






	@Override
	public int compareTo(PhoneNumber o) {
		String tmp1 = stripNum(this.number);
		String tmp2 = stripNum(o.number);
		
		return Integer.parseInt(tmp1)-Integer.parseInt(tmp2);
	}
	
}
