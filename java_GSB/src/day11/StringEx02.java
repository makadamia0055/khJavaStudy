package day11;

public class StringEx02 {

	public static void main(String[] args) {
		/* 문자열 str에 search가 몇번 등장하는지 확인하는 코드 작성하세요.
		 * */
		
		String str = "Hello world ! My name is a Hong";
		String search = "o";
		int index=0;
		int count=0;
		String tmp = str; // 나중에 원본 문자열을 활용하기 위해서 tmp로 진행
		do {
			System.out.println(tmp);
			tmp = tmp.substring(index);
		if(tmp.indexOf(search)!=-1) {
			index = tmp.indexOf(search)+search.length();
			// search.length 만큼 더해줘야 해당 문자열을 빼고 다시 검색함.
			// 대소문자 구분함.
			
			count++;
		} 
			
			
		}while(tmp.indexOf(search)!=-1);
		
		System.out.println("str 속 search의 등장 횟수는 : "+count);
				

	}

}
