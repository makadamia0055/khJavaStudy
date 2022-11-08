package day12;

public class Student {
	@Override
	public String toString() {
		return "Student [grede=" + grede + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}
	private int grede, classNum, num;
	private String name;
	
	@Override
	public int hashCode() { // 해시 알고리즘이 들어간 것들(해시맵, 해시셋)
					// 해시란?
				// 우리가 무언가를 찾을 때 기준이 되는 값들?
				// 남성 공승배를 찾을때는 여성은 거르고 남성 중에서만 찾으면 됨.
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grede;
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 같은 객체를 공유하는 지 여부
			return true;
		if (obj == null) // 할당되지 않은 객체와 비교 불가능임
			return false;
		if (getClass() != obj.getClass()) // 같은 클래스 데이터형을 가지고 있는지 여부
			return false;
		Student other = (Student) obj; //
		if (classNum != other.classNum)
			return false;
		if (grede != other.grede)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	

}
