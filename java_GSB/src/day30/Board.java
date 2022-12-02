package day30;
/*
 * 필드 : 게시글 번호, 제목, 내용, 작성자
 * 게시글 번호는 게시글 등록할 때 입력해 줌
 *  - getter/setter
 *  - toString : 번호, 제목, 작성자 순으로 출력
 *  - equals/hashCord : 게시글 번호로 판별
 *  - print : 게시글 번호, 제목, 작성자, 내용 순으로 콘솔에 출력하는 메소드
 *  - 생성자 : 
 *  	- 생성자(번호) : 번호를 이용해  게시글 생성
 *  	- 생성자(번호, 제목, 내용, 작성자) : 번호, 제목, 내용, 작성자를 이용하여 게시글 객체 생성
 *   
 */

public class Board {
	private String title;
	private String contents;
	private String writer;
	private int num;
	
	Board(int num){
		this.num= num;
		}
	Board(int num, String title, String contents, String writer){
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return num+" | "+title+" | "+writer;
	}
	
	public void print() {
		System.out.printf("%d %s %s %s\n", num, title, writer, contents);	
	}
	
	
	
	
}
