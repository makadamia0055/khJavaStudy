package day28_T;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6236676571200427266L;
	private String title, contents, writer, category;
	private Date regDate, upDate;
	private int views;
	private int num;
	private static int count = 0;
	
	public static void setCount(int count) {
		Board.count = count;
	}
	
	public static int getCount() {
		return count;
	}
	
	public Board(String title, String contents, String writer, String category) {
		super();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.category = category;
		
		this.num = ++count;
		this.regDate = new Date();
	}
	
	public Board(int num) {// 위의 생성자에서 num을 카운트로 증가시키게 해서 
		this.num = num; //검색용으로 하나
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	public String getRegDate() {
		if(regDate == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(regDate);
	}
	
	public String getUpDate() {
		if(upDate == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(upDate);
	}
	public void update(String title, String contents) {
		this.title = title ;
		this.contents = contents;
		this.upDate = new Date();
		
	}
	public String toString() {
		return num +"." + category + " | " + title + " | " + getRegDate() + " | " +
				views + " | " + writer + " | ";
	}

	public void print() {
		System.out.println("번호 : "+num);
		System.out.println("제목 : " + title);
		System.out.println("작성일 : " + getRegDate());
		if(upDate!=null)
			System.out.println("수정일 : " + getUpDate());
		System.out.println("조회수 : "+ views);
		System.out.println("작성자 : " + writer);
		System.out.println("내용 : " + contents);
		
	}
}
