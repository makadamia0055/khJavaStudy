package day12;

public class Score {

	private String subject;
	private int semester;
	private int midScore;
	private int finalScore;
	private int pfas; //performance assessment 수행평가
	
	Score(String subject, int semester, int midscore, int fnlscore, int pfas){
		this.subject = subject;
		this.semester = semester;
		this.midScore = midscore;
		this.finalScore = fnlscore;
		this.pfas = pfas;
	}
	
	Score(String subject, int semester){
		this.subject = subject;
		this.semester = semester;
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + semester;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Score other = (Score) obj;
		if (semester != other.semester)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	public int getMidScore() {
		return midScore;
	}
	public void setMidScore(int midScore) {
		if(midScore<0||midScore>50) {
			System.out.println("잘못된 성적 입력입니다.");
		}else {
		this.midScore = midScore;
		}
	}
	public int getFinalScore() {
		
		return finalScore;
	}
	public void setFinalScore(int finalScore) {
		if(finalScore<0||finalScore>50) {
			System.out.println("잘못된 성적 입력입니다.");
		} else {
		this.finalScore = finalScore;
		}
	}
	public int getPfas() {
		return pfas;
	}
	public void setPfas(int pfas) {
		if(pfas<0||pfas>50) {
			System.out.println("잘못된 성적 입력입니다.");
		} else {
		this.pfas = pfas;
		}
		
	}
	
	public void printInfo() {
		
		System.out.printf("%d학기 %s과목 성적 : 중간고사 %d점, 기말고사 %d점, 수행평가 %d점 \n", semester, subject, midScore, finalScore ,pfas);

		
	}
	
	
	
	
	
}
