package weekend_homework3;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class Post implements Comparable<Post>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6921105867627457395L;
	private postSort sort; // 분류
	private int num; // 번호
	private String title ; //제목
	private String author; //글쓴이
	private String contents; // 내용
	private String date;
	private int views = 0;
	
	
	Post(postSort sort, String title, String author, String contents){
		this.sort = sort;
		this.title = title;
		this.author = author;
		this.contents = contents;
		this.date = setDate();
		this.num = PostManager.getPostLatestNum();
		
	}
	
	
	public String setDate() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");
		return formatter.format(ldt);
	}
	
	
	
	
	
	
	@Override
	public int compareTo(Post o) {
		if(this.sort.ordinal()-o.sort.ordinal()!=0) {
			return this.sort.ordinal()-o.sort.ordinal();
		}else {
			return this.num - o.num;
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
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
}











enum postSort{
	공지사항, 잡담, 질의응답, 건의사항;
}