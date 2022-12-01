package day29;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamEx01 {

	public static void main(String[] args) {
		String[] nameArr = {"IronMan", "Captain", "Hulk", "Thor"};
		List<String> nameList = Arrays.asList(nameArr);
		
		
		Stream<String> nameStream = nameList.stream(); // 기존 list(정확한 리스트는 아님)를 stream으로 받음
		Stream<String> arrayStream = Arrays.stream(nameArr); //
		
		
		nameStream.sorted().forEach(System.out::println);
		arrayStream.sorted().forEach(System.out::println);
		
		
	}

}
