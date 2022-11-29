package day27;

import java.io.Serializable;
import java.util.ArrayList;

public class PostManager implements Serializable{
	private ArrayList<Post> postList = new ArrayList<Post>();
	
	
	
	
	
	
	public int getSize() {
		if(postList==null||postList.size()==0) {
			return 0;
		}else {
			return postList.size();
		}
			
	}
}
