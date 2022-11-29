package day27;

import java.io.Serializable;

import lombok.Data;
@Data
public class Client extends Viewer implements Qulifiable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3578333791318949483L;
	private String id;
	private String pw;
	
	public Client(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	
	
	
}
