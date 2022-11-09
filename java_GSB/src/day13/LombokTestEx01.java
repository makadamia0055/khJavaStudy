package day13;

import lombok.Data;

public class LombokTestEx01 {

	public static void main(String[] args) {
		TestABC a = new TestABC();
		a.setNum(10);
		System.out.println(a.getNum());
		System.out.println(a);
		TestABC b = new TestABC();
		b.setNum(10);
		System.out.println(a.equals(b));
	}

}
@Data// @Getter, @Setter, @ToString, @EqualsAndHashCode, 
//			@RequiredArgsConstructor(기본생성자 추가) 를 합쳐놓은게 @Data 
class TestABC{
	private int num;
	
}