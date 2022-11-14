package weekend_homework2;

import java.util.Calendar;

import lombok.Data;

@Data
public class HK implements Comparable<HK>{
	private int incomeExpend; // 1 수입 2지출 0 미기록
	private String sort;
	private String contents;
	private int amount;
	private DataCal dataCal;
	
	
	
	
	; // 캘린더는 추상클래스라 객체생성 불가. 그레고리안 캘린더로 만들어야함.
							// 새로운 캘린터 클래스를 만들어야하나? 비교, equals까지 설정해두자.
							//
	public HK(int incomeExpend, String sort, String contents, int amount, int year, int month, int day) {
		this.incomeExpend = incomeExpend;
		this.sort = sort;
		this.contents = contents;
		this.amount = amount;
		this.dataCal = new DataCal(year, month, day);
		
		
	}

	


	public HK(int incomeExpend, String sort, String contents, int amount, DataCal dataCal) {
		super();
		this.incomeExpend = incomeExpend;
		this.sort = sort;
		this.contents = contents;
		this.amount = amount;
		this.dataCal = dataCal;
	}




	@Override
	public int compareTo(HK o) {
		if(dataCal.compareTo(o.dataCal)==-1){
			return -1;
		} else if(dataCal.compareTo(o.dataCal)==0){
			return 0;
		} else {
			return 1;
		}
		
	}




	@Override
	public String toString() {
		return "| "+(incomeExpend==1?"수입":"지출") +"| "+ dataCal +"| "+ sort +"| "+ contents +"| "+ amount+"원";
	}
	
	
	
	
	public void printBy(int inputY) {
		if(this.dataCal.getYear()==inputY) {
			System.out.println(this);
		}
	}
	

	public void printBy(int inputY, int inputM) {
		if(this.dataCal.getYear()==inputY&&this.dataCal.getMonth()==inputM) {
			System.out.println(this);
		}
	}
	
	public void printBy(int inputY, int inputM, int inputD) {
		if(this.dataCal.getYear()==inputY&&this.dataCal.getMonth()==inputM&&this.dataCal.getDay()==inputD) {
			System.out.println(this);
		}
	}
	
	public HK seachBy(int inputY, int inputM, int inputD) {
		if(this.dataCal.getYear()==inputY&&this.dataCal.getMonth()==inputM&&this.dataCal.getDay()==inputD) {
			return this;
		} else {
			return null;
		}
		
	}
	
}
