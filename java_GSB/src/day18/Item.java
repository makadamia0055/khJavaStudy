package day18;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
@Data
public class Item implements Comparable<Item>{
	private String purpose, content;
	private int money, type;
	private Date date;
	
	Item(int type, String purpose, String content, int money, String date) throws ParseException{
		this.type = type;
		this.purpose = purpose;
		this.content = content;
		this.money = money;
		setDate(date);
		
	}
	
	public void setDate(String date) throws ParseException {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
		this.date = format.parse(date);
	}
	public String getDateStr() {
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public String getMoneyStr() {
		//10진수 포맷
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(money);
	}
	
	
	public void print() {
		System.out.println("----------------------");
		System.out.println("구분 : " + (getType()==1?"수입":"지출"));
		System.out.println("분류 : " + purpose);
		System.out.println("내용 : " + content);
		System.out.println("금액 : " + getMoneyStr() +"원");
		System.out.println("일시 : " + getDateStr());
		System.out.println("----------------------");
	}

	@Override
	public int compareTo(Item o) {
		if(this.date.compareTo(o.date)<0) {
			return -1;
		}else if(this.date.compareTo(o.date)>0){
			return 1;
		}else {
		return 0;
		}
	}

	@Override
	public String toString() {
		return (type==1?"수입":"지출") +" | 일시 : "+getDateStr()+ " | 분류 : " + purpose + " | 내용 : " + content + " | 금액 : " + money ;
	}
	
	
	
}
