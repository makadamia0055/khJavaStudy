package day09;

public class AbstractionEx01 {

	public static void main(String[] args) {
		
		Student std1 = new Student(1, 1, 1, "홍길동");
		std1.print();
		std1.updateScoreMid(50, 30, 40);
		std1.print();
		std1.updateScoreFnl(50, 30, 40);
		std1.print();

		
		
	}

}
/*
 * 학생 성적 관리 프로그램에서 필요한 학생 클래스를 만들어보세요.
 * 
 * 고딩
 * 반/번호로 인덱스
 * 
 * 
 * 학생 학년/반/반번호-int  
 * 학생 이름 String
 * 
 * 과목 국어 1
 * 과목 영어 2
 * 과목 수학 3
 * 각 과목은 중간 50, 기말 50 총 100점 만점
 * 
 * 생성자(학번, 이름)
 * 
 * set/get메서드로 성적 접근
 * 학생정보 출력기능 info
 * 평균성적 및 석차 메서드
 * 
*/



class Student{
	
	private int Grade;
	private int Class;
	private int Num;
	private String Name;
	
	private int korMid;
	private int korFnl;
	//private int korScr = korMid + korFnl; //선언 당시의 값으로 컴파일때 연산 끝남?
	// 0으로 초기화가 되어있는 값이라 컴파일 시 연산이 끝나나?
	//A. 컴파일 연산 문제는 아니고, 처음 한번만 연산이 일어나서. 나중에 출력할 때 더 해줘야함
	// 컴파일러는 한줄 끝나면 그 이전의 값은 잊어버림. 그러니 korScr에 입력된 값은 korMid+korFnl이 아니라 그 결과인 상수값이라는 말.
	// 난자바를배운적 없다구요에서 컴파일러 한줄 지날때마다 잊어버린다는 개념으로 이해하
	private int engMid;
	private int engFnl;
	//private int engScr = engMid + engFnl;
	private int mathMid;
	private int mathFnl;
	//private int mathScr = mathMid + mathFnl;
	
	// 생성자
	
	Student(int grade1, int Class1, int num1, String name1){
		Grade = grade1;
		Class = Class1;
		Num = num1;
		Name = name1;
		
		Integer i1 = grade1, i2 = Class1, i3 = num1;
		String i4 = i1.toString()+ i2.toString() + i3.toString();
	
		
	}

	public int getKorMid() {
		return korMid;
	}

	public void setKorMid(int korMid) {
		if(korMid<0||korMid>50){
			System.out.println("잘못된 성적 입력입니다.");
		} else {
		this.korMid = korMid;
	}
		}

	public int getKorFnl() {
		return korFnl;
	}

	public void setKorFnl(int korFnl) {
		
		if(korFnl<0||korFnl>50){
		System.out.println("잘못된 성적 입력입니다.");
	} else {
		this.korFnl = korFnl;
	}
	}

	public int getEngMid() {
		return engMid;
	}

	public void setEngMid(int engMid) {
		if(engMid<0||engMid>50){
			System.out.println("잘못된 성적 입력입니다.");
		} else {
		this.engMid = engMid;
	} 
		}

	public int getEngFnl() {
		return engFnl;
	}

	public void setEngFnl(int engFnl) {
		if(engFnl<0||engFnl>50){
			System.out.println("잘못된 성적 입력입니다.");
		} else {
		this.engFnl = engFnl;
	}
	}

	public int getMathMid() {
		return mathMid;
	}

	public void setMathMid(int mathMid) {
		if(mathMid<0||mathMid>50){
			System.out.println("잘못된 성적 입력입니다.");
		} else {
		this.mathMid = mathMid;
	}
	}

	public int getMathFnl() {
		return mathFnl;
	}

	public void setMathFnl(int mathFnl) {
		if(mathFnl<0||mathFnl>50){
			System.out.println("잘못된 성적 입력입니다.");
		} else {
		this.mathFnl = mathFnl;
	}
	}
	
	public void print() {
		System.out.println(Grade + "학년 " + Class + "반 " + Num+ " 번" +Name);
		System.out.println(" 국어 : " + (korMid+korFnl) + " 영어 : " + (engMid+engFnl) + " 수학 : " +(mathMid+mathFnl));
	}
	
	public void updateScoreMid(int kor1, int eng1, int math1) {
		setKorMid(kor1);
		setEngMid(eng1);
		setMathMid(math1);
}
	public void updateScoreFnl(int kor1, int eng1, int math1) {
		setKorFnl(kor1);
		setEngFnl(eng1);
		setMathFnl(math1);
}
	
	
	
	
	
	
}