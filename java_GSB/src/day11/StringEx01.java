package day11;

public class StringEx01 {

	public static void main(String[] args) {
		/*
		 * 
		 */
		int num;// 기본 변수는 보라색
		String str1; // 변수 선언시 데이터 형의 색이 검은색
					//    private final byte[] value;
					// 상수화된 필드로 구성되어 있음.
					/* String은 클래스다. 
					 * String는 문자열의 값을 수정할 수 없다.
					 * 
					 */
		String str2 = "abc";
		System.out.println(str2);
		str2 = "def";
		System.out.println(str2); // 이 예시는 참조변수 str2의 참조값이 바뀐 것.
			
		/* StringBuffer 클래스 => 문자열의 값을 수정할 수 있다.
		 *  내부에 할당된 버퍼공간 안에서 문자열을 처리하여 출력
		 *  StringBuilder 클래스는 StringBuffer와 동일한 기능을 한다.
		 *  다만 StringBuffer는 쓰레드에서 safe기능 제공하고
		 *  StringBuilder는 제공하지 않는다는 차이가 있다.
		 * 
		 */
		str1 = new String("defe"); //생성자를 통한 스트링 생성
		
		// String 클래스의 다양한 메소드.
		// length : 문자열 길이
		System.out.println("문자열의 길이 : " + str1.length());
		int [] arr= new int[5]; // 배열의 length와 차이점. String length는 메서드
		System.out.println("배열의 길이 : " + arr.length); // array의 length는 속성
		
		
		// indexOf(문자 또는 문자열) : 해당 문자열/ 문자를 0번지부터 탐색하여 
		// 첫번째로 만나는 문자열 또는 문자의 시작번지를 리턴, 없는 경우 -1 리턴
		System.out.println("e의 위치 : " + str1.indexOf("e"));
		// lastIndexOf(문자 또는 문자열) : 마지막 번지부터 탐색
		System.out.println("e의 위치 : " + str1.lastIndexOf("e"));
		// contains(문자 또는 문자열): 해당 문자열, 문자가 있는지 없는지를 boolean 값으로 반환
		System.out.println("e의 위치 : " + str1.contains("e"));
		
		
		/*subString(시작번지) :문자열의 시작번지부터 끝까지 부분문자열을 추출
		 * subString(시작번지, 마지막번지) : 시작번지부터 (마지막번지-1)까지 해당하는 문자열을 추출
		 */
		System.out.println("1번지부터 부분 문자열 : "+str1.substring(1));
		System.out.println("1번지부터 2번지까지 부분 문자열 : " + str1.substring(1, 3));
		
		/* equals(문자열) : 문자열과 같은지 다른지 알려줌.
		 * 문자열은 참조변수이기 때문에 ==를 통해서 정확히 같은지 다른지를 비교할 수 없다.
		 * 왜냐면 참조변수를 비교할때는 같은 객체를 참조값으로 공유하는지 여부를 따지기 때문.
		 *  */
		String str4 = "abc";
		String str5 = "abc"; 
		// 자바에서 문자열이 같으면 같은 객체를 사용하도록 함.
		// => 리터럴 문자열은 리터럴들만 모여있는 공간에 할당됨. 
		// 같은 리터럴 문자열이 있는 경우 새로 만들지 않고 기존에 있는 리터럴 문자열을 반환.
		String str6 = new String("abc");
		// 다만 new를 통해 만들면 리터럴이 있는 공간(heap내에 생성된 String Constant Pool)이 아니라

		//다른 공간(heap)에 새로운 객체를 반환한다.
		
		
		System.out.println("str 4 : " + str4);
		System.out.println("str 5 : " + str5);
		System.out.println("str 6 : " + str6);
		System.out.println("str4와 str5가 같다 ? " + (str4==str5));
		System.out.println("str5와 str6가 같다 ? " + (str5==str6));
		System.out.println("str4와 str5가 같다 ? " + str4.equals(str5));
		System.out.println("str5와 str6가 같다 ? " + str5.equals(str6));
		
		/*
		 * charAt(번지) : 문자열에서 해당 번지에 있는 문자열을 반환
		 */
		
		String str7 ="Hello";
		System.out.println(str7 + " 문자열 2번지에 있는 문자 : "+ str7.charAt(2));
		
		/*
		 * split(정규표현식) : 정규표현식을 기준으로 문자열을 분할하여 배열로 만듦.
		 */
		String fruit = "사과,배,오렌지,귤";
		String[] fruits = fruit.split(",");
		for(String i: fruits) {
			System.out.println(i);
		}
		/*
		 * trim) : 시작문자 앞에 있는 공백을 제거하고 마지막 문자 뒤에 있는 공백을 제거함.
		 * 
		 */
		String str9 = "\n\n\n\n  \t안녕 하세요.\n\n\n  \t";
		System.out.println(str9.trim());
		
	}

}
