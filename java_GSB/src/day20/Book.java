package day20;

import lombok.Data;

@Data
public class Book {

	//필드 -> 객체를 나타내는 정보
	private String title, author, publisher, genre, isbn;
	private int price;
	
	
	
	
	
	//생성자=> 객체를 생성할 때 필드를 초기화 하는 메소드
	public Book(String title, String author, String publisher, String genre, String isbn, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.isbn = isbn;
		this.price = price;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	
	
	//메소드 -> 기능
	
	//getter setter = 롬복으로 처리
	//toString 오버라이드 -> 도서 정보를 간단히 문자열로 만들기위해
	//equals => 상황에 따라 오버라이딩
	
	
	
	
	
}
