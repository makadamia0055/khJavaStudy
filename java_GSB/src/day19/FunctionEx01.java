package day19;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionEx01 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "이도흠", 100, 90, 80));
		list.add(new Student(1, 2, 1, "정민", 80, 60, 39));
		list.add(new Student(1, 3, 1, "이승수", 39, 22, 69));
		/*
		 * 학생들의 국어 성적만 출력하는 코드를 작성하세요
		 * 영
		 * 수
		 */
// 기존 코드

		/*for(Student tmp : list) {
			System.out.println(tmp.getName()+"학생의 국어성적 : "+ tmp.getKor()+"점");
		}
		for(Student tmp : list) {
			System.out.println(tmp.getName()+"학생의 영어성적 : "+ tmp.getEng()+"점");
		}
		for(Student tmp : list) {
			System.out.println(tmp.getName()+"학생의 수학성적 : "+ tmp.getMath()+"점");
		}*/
		
		System.out.println("-----------------------------");
		
		print(list, (a)-> System.out.println(a.getName()+"학생의 국어성적 : "+a.getKor()));
		print(list, (a)-> System.out.println(a.getName()+"학생의 영어성적 : "+a.getEng()));
		print(list, (a)-> System.out.println(a.getName()+"학생의 수학성적 : "+a.getMath()));
		
		System.out.println("-----------------------------");

		printA(list, "국어", s->s.getKor());
		printA(list, "영어", s->s.getEng());
		printA(list, "수학", s->s.getMath());
		
		printA(list, "총합", s->s.getMath()+s.getEng()+s.getKor());
		
	}
	public static void printA(ArrayList<Student> list, String subject, Function<Student, Integer> f) {
		for(Student tmp : list) {
			System.out.println(subject+ " : " + f.apply(tmp));
		}
		
		
	}
			
	public static void print(ArrayList<Student> list, Consumer<Student> con) {
		for(Student tmp : list) {
			con.accept(tmp);
		}
		
		
	}
}

