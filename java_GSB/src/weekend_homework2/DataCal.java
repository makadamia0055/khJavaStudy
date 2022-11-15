package weekend_homework2;

import java.util.Calendar;

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
	
public static DataCal getDate() {
		AccountService aS = new AccountServiceImp();
	
		System.out.println("년 : ");
		int tmpYear=0;
		tmpYear = aS.inputScan(tmpYear, 1970, 2050, "1970과 2050 사이의 년도를 입력해주십시오.");
		
		System.out.println("월 : ");

		int tmpMonth = 0;
		tmpMonth= aS.inputScan(tmpMonth, 1, 12, "1과 12 사이의 월을 입력해주십시오.");
		
		System.out.println("일 : ");
		int tmpDay = 0;
		Calendar cal = Calendar.getInstance();
		
		do {
		tmpDay = aS.inputScan(tmpDay, 1, 31, "1과 31사이의 숫자를 입력해주십시오.");
		cal.set(tmpYear, tmpMonth-1, 1);
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		if(tmpDay>(cal.getActualMaximum(Calendar.DAY_OF_MONTH))) {
			System.out.println((tmpMonth)+ "월에는 "+tmpDay+"일이 없습니다.");
			System.out.println("일 : ");
		}else {
			
			System.out.printf("%d년 %d월 %d일이 정상 입력 되었습니다.", tmpYear, tmpMonth, tmpDay);
			break;
		}
		
		}while(true);
		
		 
		
		return new DataCal(tmpYear, tmpMonth, tmpDay);
	}

	
}
