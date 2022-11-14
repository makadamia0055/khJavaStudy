package weekend_homework2;

import lombok.Data;

@Data
public class DataCal implements Comparable<DataCal>{
	private int year;
	private int month;
	private int day;
	
	public DataCal(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	
	@Override
	public int compareTo(DataCal o) {
		if(this.year<o.year) {
			return -1;
		}else if(year==o.year) {
			if(month<o.month) {
				return -1;
			}else if(month==o.month) {
				if(day<o.day) {
					return -1;
				}else if(day ==o.day) {
					return 0;
				}else return 1;
				
			}else {
				return 1;
			}
			
		}else {
			return 1;
		}
	
	}

	@Override
	public String toString() {
		return "" + year + "년 " + month + "월 " + day + "일";
	};
	
	
	
}
