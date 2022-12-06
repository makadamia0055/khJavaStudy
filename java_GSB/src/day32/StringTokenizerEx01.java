package day32;

import java.util.StringTokenizer;

public class StringTokenizerEx01 {

	public static void main(String[] args) {
		String str = "abc,def,.ghi";
		String[] arr = str.split(",."); // 정규표현식으로 적용 ->,. ,과 아무문자 하나
		for(String tmp : arr) {
			System.out.println(tmp);
		}
		//StringTokenizer은 ,과 . 각각 구분자로 적용
		System.out.println("---------------");
		StringTokenizer st = new StringTokenizer(str, ".,");
		System.out.println("개수 : " +st.countTokens());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
		System.out.println("---------------");
		st = new StringTokenizer(str, ".,", true); 
		System.out.println("개수 : " +st.countTokens());
		//true를 추가하면 구분자도 같이 나옴.
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			System.out.println(tmp);
		}
	}

}
