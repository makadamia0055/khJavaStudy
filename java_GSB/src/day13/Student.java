package day13;

import lombok.Data;

@Data
public class Student {
	// 필드 : 학년, 반, 번호, 이름, 성적들
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private Score[] scoreList;
	private int maxSize; // 최대 저장 가능한 성적 수 
	private int count; // 현재 저장된 성적 수
	// 생성자 : 초기화, 
	// 학년, 반, 번호, 이름이 필요한 생성자. 학생정보 추가시
	// 학년, 반, 번호가 필요한 생성자. 학생정보 비교시
	
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.maxSize = 30;
		scoreList = new Score[maxSize];
	}
	
	
	public Student(int grade, int classNum, int num) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.maxSize = 30;
		scoreList = new Score[maxSize];
	}


	

	@Override
	public String toString() {
		return "StudentTVer [학년=" + grade + ", 반=" + classNum + ", 번호=" + num + ", 이름=" + name + "]";
	}

	
	
	// 메소드 : getter/setter equals(오버라이딩): 같은 객체인지 비교하기 위해서, 
	//toString(오버라이딩): 객체를 쉽게 문자열로 만들기 위해
	
	/**
	 * 학생 정보에 성적을 추가하는 메소드. Score객체 탐색해서 있으면 true, 없으면 false
	 * @param 추가할 성적 Score객체
	 * @return 추가 여부 boolean
	 */
	public boolean addScore(Score score) {
		if(score==null) {
			return false;
		}
		if(count==maxSize) {
			return false;
		}
		for(int i= 0; i<count; i++) {
			if(!score.equals(scoreList[i])) {
			return false;
		}
		
	}
		//scoreList[count]=score; // 얕은 복사라 안좋은 방식
		//score에서 복사생성자 만들어준 후 깊은 복사해줌
		scoreList[count]=new Score(score);
		count++;
		return false;
	}


	public void printScore() {
		for(int i =0; i<count; i++) {
			System.out.println(scoreList[i]);
		}
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}
	
	
	
}
