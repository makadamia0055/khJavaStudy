package weekend_homework2;

import java.util.Calendar;

import lombok.Data;

@Data
public class HK {
	private boolean incomeExpend;
	private String sort;
	private String contents;
	private int amount;
	private Calendar cal; // 캘린더는 추상클래스라 객체생성 불가. 그레고리안 캘린더로 만들어야함.
							// 새로운 캘린터 클래스를 만들어야하나? 비교, equals까지 설정해두자.
							//
	public HK(boolean incomeExpend, String sort, String contents, int amount, int year, int month, int day) {
		this.incomeExpend = incomeExpend;
		this.sort = sort;
		this.contents = contents;
		this.amount = amount;
		
	}
	
	
	
}
