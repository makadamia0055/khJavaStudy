package day17;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Post implements Comparable<Post>{
	private int index;
	private String title;
	private String contents;
	private String author;
	private int views =0;
	private String date;
	
private static int totalIndex = 1;
	
	/**
	 * @return the totalIndex
	 */
	public static int getTotalIndex() {
		return totalIndex;
	}

	/**
	 * @param totalIndex the totalIndex to set
	 */
	public static void setOneTotalIndex() {
		Post.totalIndex += 1;
	}

	Post(String title, String contents, String author){
		this.title = title;
		this.contents = contents;
		this.author = author;
		this.views = 0;
		this.date=setDate();
		this.index = Post.getTotalIndex();
		// 메인페이지에서 증감 해줘야함. //강사님은 생성자에서 증감
		
	}
	
	public String setDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		String dateStr = format.format(date);
		return dateStr;
	}
	
	
	
	
	@Override
	public int compareTo(Post o) {
		if(this.index<o.index) {
			return -1;
		}else if(this.index>o.index){
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) { 
			//obj가 Integer로 클래스 변환이 가능하면 게시글 번호와 obj를 비교
			if(obj instanceof Integer) {
				if(index==(Integer)obj) {
					return true;
				}
			}
			// Integer, Post가 아니거나 게시글 번호가 다른 경우
			
			return false;
		}
		Post other = (Post) obj;
		if (index != other.index)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}

	@Override
	public String toString() {
		return "[" + index + "번 제목 : " + title + " 작성자 : " + author
				+ " 올린 일시 " + date + " " + views+  "회 열람 ]";
	};
	
	public void setViews(int num) {
		this.views+=num;
	}
	
	
	
}
