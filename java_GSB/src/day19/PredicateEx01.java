package day19;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateEx01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "이도흠", 100, 90, 80));
		list.add(new Student(1, 2, 1, "정민", 80, 60, 39));
		list.add(new Student(2, 1, 2, "이승수", 39, 22, 69));
		list.add(new Student(3, 1, 2, "유성호", 39, 22, 69));
		list.add(new Student(1, 2, 2, "서경석", 39, 22, 69));
		list.add(new Student(1, 1, 3, "신중진", 39, 22, 69));
		/*
		 * 1학년 1반 학생들을 출력하는 코드를 작성하세요. 1학년 2반 학생들을 출력하는 코드를 작성하세요. 1학년 학생들을 출력하는 코드를
		 * 작성하세요
		 */

		printClass(list, 1, 1);
		printClass(list, 1, 2);
		printClass(list, 1, 0);

		
		
		System.out.println("-----------------");
		print(list, s->s.getGrade()==1&&s.getClassNum()==1);
		System.out.println("-----------------");
		print(list, s->s.getName().charAt(0)=='신');
		
		
		
		
		
		
	}

	private static void printClass(ArrayList<Student> list, int gradeNum, int classNum) {
		if (gradeNum == 0 && classNum == 0) {
			System.out.print("전교생 리스트 : ");
			for (Student tmp : list) {
				System.out.print(tmp.getName() + " ");
			}
		} else if (gradeNum != 0 && classNum == 0) {
			System.out.print(gradeNum + "학년 전체 학생 :");
			for (Student tmp : list) {
				if (tmp.getGrade() == gradeNum) {
					System.out.print(tmp.getName() + " ");
				}
			}
		} else if (gradeNum != 0 && classNum != 0) {
			System.out.print(gradeNum + "학년 " + classNum + "반 학생 리스트 : ");
			for (Student tmp : list) {
				if (tmp.getGrade() == gradeNum && tmp.getClassNum() == classNum) {
					System.out.print(tmp.getName() + " ");
				}
			}
		}
		System.out.println();

		
	}
	public static void print(ArrayList<Student> list, Predicate<Student> p) {
		for(Student tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}
	
}
