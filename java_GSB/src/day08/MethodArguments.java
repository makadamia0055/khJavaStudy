package day08;

public class MethodArguments {

	public static void main(String[] args) {
		/* 가변인자
		 *  매개변수의 개수를 다양하게 하고 싶을 때 
		 * 매개변수에 자료형... 배열명 => 메소드에서 배열처럼 사용
		 * 가변인자를 사용할 때는 항상 마지막에 사용(가변인자 뒤에 다른 변수가 오면 에러)
		 */
		
		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1, 2));
		System.out.println(sum(1, 2, 3));
		// 배열을 입력해주는게 아님. 배열을 아닌 것을 넣어도
		// 배열처럼 사용해줄 수 있게 하는 것
		
		
	}
	public static int sum(int ...nums) {
		if(nums.length==0||nums==null) {
			return 0;
		}
		int sum = 0;
		for( int num: nums) {
			sum+= num;
		}
		return sum;
	}
	
	
	
	// 가변인자는 무조건 마지막에 써야함
	public static void score(int grade, int classNum, int num, String name , int ...score) {
		
		
	}

}
