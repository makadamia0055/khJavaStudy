package day28;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class Client extends Viewer implements Qulifiable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3578333791318949483L;
	private String id;
	private String pw;
	private Date joinDate;
	private Authority authority;
	
	public Client(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	
	
}
enum Authority{
	ADMIN, MEMBER
}

