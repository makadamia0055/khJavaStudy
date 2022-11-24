package day24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMain {
	private static Scanner scan = new Scanner(System.in);
	/*
	 * 학생 정보를 관리하는 프로그램을 작성하되, 파일로 저장이 되게하라. 
	 * 1. 학생 추가(이름, 학년, 반, 번호)
	 * 2. 학생 출력
	 * 3. 종료
	 * - 프로그램 시작 전 학생 정보를 읽어오는 기능 추가(load)
	 * - 프로그램 종료 전 학생 정보를 저장하는 기능 추가(save)
	 */
	
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			fis = new FileInputStream("Student.txt");
			ois = new ObjectInputStream(fis);
			
			
			while(true) {
				list.add((Student) ois.readObject());
			} // true 로 계속 빼고 에러로 빠져나오는거
			
			 
			
		}catch (FileNotFoundException e) {
			File file = new File("Student.txt");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch(IOException e) {
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)
				fis.close();
				if(ois!=null)
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		if(list==null) {
			list=new ArrayList<Student>();
		}
		int menu =-1;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(list, menu);
		}while(menu!=3);
		
		
		
	}
	private static void runMenu(ArrayList<Student> list, int menu) {
		switch(menu) {
		case 1: 
			System.out.println("1. 학생 정보 추가");
			System.out.println("학생의 이름을 입력해주십시오.");
			String name = scan.next();
			System.out.println("학생의 학년, 반, 번호를 입력해주십시오.");
			int grade =scan.nextInt();
			int classNum = scan.nextInt();
			int num = scan.nextInt();
			Student tmpStd = new Student(name, grade, classNum, num);
			
			if(list.contains(tmpStd)) {
				System.out.println("이미 등록된 학생입니다.");
				break;
			}else {
				list.add(tmpStd);
				System.out.println(name+"학생이 추가되었습니다.");
			}
			
			break;
		case 2:
			System.out.println("2. 학생 정보 출력");
			Collections.sort(list);
			for(Student tmp : list) {
				tmp.print();
			}
			
			System.out.println("====================");
			break;
		case 3:
			
			saveAndClose(list);
			
			System.out.println("저장하고 종료합니다.");
			
			break;
			default:
		}
		
	}
	private static void saveAndClose(ArrayList<Student> list) {
		FileOutputStream fos= null;
		ObjectOutputStream oos= null;
		
		try {
			fos = new FileOutputStream("Student.txt");
			oos = new ObjectOutputStream(fos);
			//StudentList stdList = new StudentList(list); //필요한가?
			
			for(Student tmp : list) {
				oos.writeObject(tmp);
			}
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 출력");
		System.out.println("3. 학생 종료");
		
	}

}
