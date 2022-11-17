package day19;

import java.util.ArrayList;
import java.util.function.Consumer;



public class ConsumerEx01 {

	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동"));
		list.add(new Student(1, 2, 1, "홍닐동"));
		list.add(new Student(1, 3, 1, "홍딜동"));
		list.add(new Student(1, 4, 1, "홍릴동"));
		
		print(list, (a) -> System.out.println(a));
		print(list, (a) -> {
			System.out.println("학년 : "+ a.getGrade());
			System.out.println("반 : "+ a.getClassNum());
			
		});

		
	}

	public static void print(ArrayList<Student> list, Consumer<Student> con) {
		for(Student tmp: list) {
			con.accept(tmp);
		}
	}
}
