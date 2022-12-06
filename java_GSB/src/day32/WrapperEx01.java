package day32;

public class WrapperEx01 {

	public static void main(String[] args) {
		String str = "123";
		int num = Integer.parseInt(str);
		System.out.println(num);
		
		str = "3.14";
		double dnum = Double.parseDouble(str);
		System.out.println(dnum);
		
		num = 30;
		str = String.valueOf(num);
		System.out.println(str);
				
	}

}
