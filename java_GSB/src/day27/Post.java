package day27;

import java.io.Serializable;

import lombok.Data;

@Data
public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2306831176202268634L;
	private Sort sort;
	private String title;
	private String contents;
	private String author;
	private int view;
	private int num;
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

enum Sort{
	공지, 자유
}