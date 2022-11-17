package day19;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Book implements Comparable<Book>{
	private String title;
	private ArrayList<String> author;
	private int ISBN;
	private int price;
	private String company;
	private Sort sort;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ISBN != other.ISBN)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		return result;
	}
	@Override
	public int compareTo(Book o) {
		
		return ISBN-o.ISBN;
	}
	public Book(String title, ArrayList<String> author, int iSBN, int price, String company, Sort sort) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.price = price;
		this.company = company;
		this.sort = sort;
	}
	@Override
	public String toString() {
		return ISBN + title + "| 작가 : " + author + " | 가격 :" + price + " |  출판사 :"
				+ company + "| 분류 " + sort;
	}
	
	
private enum Sort{ 소설, 자기개발서, 과학, 사회학, 인문학, 원서, 실용서, 예체능 }	
	
	
	
}
