package day04;

public class BreakEx01 {

	public static void main(String[] args) {
			int i;
			// break를 만나면 증감식으로 가지 않고 , 반복문을 빠져 나감
			// 이때 빠져나가는 가장 가까운 반복문이란 break를 포함하고 있는 
			// 반복문을 뜻한다. (당연히 그 반복문을 빠져나가라는 뜻이니까)
			
			for(i = 1 ; i<=5; i++) {
				System.out.println(i+"번째 Hello World!");
				
				if(i==3) {
					break;
				}
				
			}
	}

}
