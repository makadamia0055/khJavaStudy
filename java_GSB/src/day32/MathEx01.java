package day32;

public class MathEx01 {

	public static void main(String[] args) {
		double pi = 3.141592;
		double pi1 = Math.round(pi);
		System.out.println(pi1);		
		
		double pi2 = Math.round(pi*10)/10.0;
		System.out.println(pi2);
		
		double pi3 = Math.round(pi*100)/100.0;
		System.out.println(pi3);

		double pi4 = Math.round(pi*1000)/1000.0;
		System.out.println(pi4);
		
		int num = 4;
		double pi4_2 = Math.round(pi*Math.pow(10,  num-1))/ Math.pow(10,  num-1);
		System.out.println(pi4_2);

	}

}
