package day12;

public class HighStudent {

	private int grade;
	private int classNum;
	private int stdNum;
	private String stdName;
	private Score[] stdScores;
	
	HighStudent(int grade, int classnum, int stdnum, String name){
		this.grade = grade;
		this.classNum = classnum;
		this.stdNum = stdnum;
		this.stdName = name;
	}

	public int getGrade() {
		return grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public int getStdNum() {
		return stdNum;
	}

	public String getStdName() {
		return stdName;
	}

	public Score[] getStdScores() {
		return stdScores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + stdNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighStudent other = (HighStudent) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (stdNum != other.stdNum)
			return false;
		return true;
	}
	
		

	
}
