package day09;

public class HighStudent {
	
		
		private int Grade;
		private int Class;
		private int Num;
		private String Name;
		
		private int kor;
		private int eng;
		private int math;
	
		public HighStudent(int grade1, int Class1, int num1, String name1){
			Grade = grade1;
			Class = Class1;
			Num = num1;
			Name = name1;
			
		}
		
		
			
		
		
		

		public String getName() {
			return Name;
		}







		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			if(kor<0||kor>100){
				System.out.println("잘못된 성적 입력입니다.");
			} else {
			this.kor = kor;
		}
			}

		

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			if(eng<0||eng>100){
				System.out.println("잘못된 성적 입력입니다.");
			} else {
			this.eng = eng;
		} 
			}

	

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			if(math<0||math>100){
				System.out.println("잘못된 성적 입력입니다.");
			} else {
			this.math = math;
		}
		}

		
		public void print() {
			System.out.println(Grade+"학년 "  + Class +" 반" +  Num+ "번  " + Name);
			System.out.println(" 국어 : " + kor + " 영어 : " + eng + " 수학 : " +math);
		}
		
		public void updateScore(int kor1, int eng1, int math1) {
			setKor(kor1);
			setEng(eng1);
			setMath(math1);
	}
		
		
		
		
	}

