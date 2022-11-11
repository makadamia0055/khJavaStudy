package day14;

import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
		/*
		 *  Calendar 클래스 : 날짜와 관련된 클래스
		 *  get()을 통해서 년도, 월, 일, 시 , 분, 초 등 다양한 정보를 가져옴
		 */
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal);
		
		// 더하고 빼는 기능
		cal.add(Calendar.YEAR, 10);
		cal.add(Calendar.MONTH, -10);
		
		int year = cal.get(Calendar.YEAR);
		System.out.print(year+"년 ");
		int month = cal.get(Calendar.MONTH)+1;
		System.out.print(month + "월 ");
		int date = cal.get(Calendar.DATE);
		System.out.print(date + "일 ");
		int hour =cal.get(Calendar.HOUR_OF_DAY);
		System.out.print(hour + "시 ");
		int min = cal.get(Calendar.MINUTE);
		System.out.print(min+ "분 ");
		
	}

}
