package weekend_homework3;

import java.io.Serializable;

public class Client implements Serializable{

	
	
	public static boolean checkVerified(Object obj){
		if(obj instanceof Qualifiable) {
			return true;
		}else {
			return false;
		}
	}

}
