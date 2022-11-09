package day13;

public class Score2 {
	//필드 : 과목 , 학기, 중간, 기말, 수행평가, 총점
	private String title;
	private int term;
	private int midScore;
	private int finalScore;
	private int performance;
	private double totalScore;
	private double midRate =0.4, finalRate = 0.5, performanceRate = 0.1;

	//생성자 : 과목 학기 / 과목 학기 중간 기말 수행평가 
	public Score2(String title, int term, int midScore, int finalScore, int preformance) {
		
		this.title = title;
		this.term = term;
		this.midScore = midScore;
		this.finalScore = finalScore;
		this.performance = preformance;
		this.totalScore = midRate*midScore + finalScore*finalRate + performance*performanceRate;

	}
	
	
	
	
	public Score2(String title, int term) {
		
		this.title = title;
		this.term = term;
	}

	public Score2(Score2 s) { // 복사 생성자 깊은 복사 대용으로.
		
		this(s.title, s.term, s.midScore, s.finalScore, s.performance);
	}



	//메소드 equals() 성적 추가시 비교에서 활용, toString() 성적 출력 시 활용, getter setter
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + term;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "학생 성적 [과목=" + title + ", 학기=" + term + ", 중간고사=" + midScore + ", 기말고사=" + finalScore
				+ ", 수행평가=" + performance + ", 총점=" + totalScore + "]";
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}
	/**
	 * @return the midScore
	 */
	public int getMidScore() {
		return midScore;
	}
	/**
	 * @param midScore the midScore to set
	 */
	public void setMidScore(int midScore) {
		this.midScore = midScore;
	}
	/**
	 * @return the finalScore
	 */
	public int getFinalScore() {
		return finalScore;
	}
	/**
	 * @param finalScore the finalScore to set
	 */
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	/**
	 * @return the preformance
	 */
	public int getPreformance() {
		return performance;
	}
	/**
	 * @param preformance the preformance to set
	 */
	public void setPreformance(int preformance) {
		this.performance = preformance;
	}
	/**
	 * @return the totalScore
	 */
	public double getTotalScore() {
		return totalScore;
	}
	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score2 other = (Score2) obj;
		if (term != other.term)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
