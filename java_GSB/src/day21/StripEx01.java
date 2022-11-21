package day21;

public class StripEx01 {

	public static void main(String[] args) {
		String num = "010-2511-9226";
		String tmp = stripNum(num);
		System.out.println(tmp);
		
		
		
	}
	public static String stripNum(String num) {
		String tmp = new String(num);
		tmp = tmp.replaceAll("-", "");
		tmp = tmp.replaceAll(" ", "");
		//result 값을 다시 tmp에 대입 해줘야 함.

		return tmp;
	}

	
}
