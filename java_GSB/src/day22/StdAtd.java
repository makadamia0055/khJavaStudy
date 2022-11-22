package day22;

import lombok.Data;

@Data
public class StdAtd{
	private Student std;
	private Character atd;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StdAtd other = (StdAtd) obj;
		if (std == null) {
			if (other.std != null)
				return false;
		} else if (!std.equals(other.std))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((std == null) ? 0 : std.hashCode());
		return result;
	}
	public StdAtd(Student std) {
		this.std = std;
	}
	@Override
	public String toString() {
		return "[" +std + "출결 : "+ atd + "]";
	}
	
	
	
}