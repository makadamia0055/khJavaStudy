package day28;

public class Viewer {

	
	
	public static boolean verifiedClient(Viewer obj) {
		if(obj instanceof Qulifiable) {
			return true;
		}else {
			return false;
		}
		
	}
	public static boolean verifiedMaster(Object obj) {
		if(obj instanceof Masterable) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
