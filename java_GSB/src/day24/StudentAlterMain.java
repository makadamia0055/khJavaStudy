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

public class StudentAlterMain {
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
		StudentList list = new StudentList();
		String fileName = "Students.txt";
		
		list = load(list, fileName);
		
		int menu =-1;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(list, menu, fileName);
		}while(menu!=3);
		
		
		
	}
	private static StudentList load(StudentList list, String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			
			list = ((StudentList) ois.readObject());
			
		}catch (FileNotFoundException e) {
			System.out.println("파일이 없어서 불러오지 못했습니다.");
		}catch(IOException e) {
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	private static void runMenu(StudentList list, int menu, String fileName) {
		switch(menu) {
		case 1: 
			addStd(list);
			
			
			break;
		case 2:
			printStd(list);
			
			break;
		case 3:
			
			saveAndClose(list, fileName);
			System.out.println("저장하고 종료합니다.");
			
			break;
			default: System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	private static void printStd(StudentList list) {
		if(list.getList()==null) {
			throw new RuntimeException("예외 발생 : 학생을 관리할 리스트가 생성되지 않았습니다.");
		}
		if(list.getList().size()==0) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}
			
		System.out.println("2. 학생 정보 출력");
		Collections.sort(list.getList());
		for(Student tmp : list.getList()) {
			tmp.print();
		}
		
		System.out.println("====================");
	}
	private static void addStd(StudentList list) {
		if(list.getList()==null)
			throw new RuntimeException("학생을 관리할 리스트가 생성되지 않았습니다.");
		System.out.println("1. 학생 정보 추가");
		System.out.println("학생의 이름을 입력해주십시오.");
		String name = scan.next();
		System.out.println("학생의 학년, 반, 번호를 입력해주십시오.");
		int grade =scan.nextInt();
		int classNum = scan.nextInt();
		int num = scan.nextInt();
		Student tmpStd = new Student(name, grade, classNum, num);
		
		if(list.getList().contains(tmpStd)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}else {
			list.getList().add(tmpStd);
			System.out.println(name+"학생이 추가되었습니다.");
		}
	}
	private static void saveAndClose(StudentList list, String fileName) {
		if(list.getList()==null) {
			throw new RuntimeException("저장할 리스트가 없습니다.");
		}
				
		try(ObjectOutputStream oos=
			 new ObjectOutputStream(new FileOutputStream(fileName))) {
			
			//StudentList stdList = new StudentList(list); //필요한가?
			
			//for(Student tmp : list.getList()) {
				oos.writeObject(list);
			//}
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName+"을 생성할 수 없어서 저장에 실패했습니다.");
			//파일 경로에 디렉토리가 없어서 생성 실패하는 경우
		
		}catch (IOException e) {
			e.printStackTrace();
		
		}
	}
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 출력");
		System.out.println("3. 학생 종료");
		
	}

}
