package example.db.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import example.db.dao.StudentDAO;
import example.db.vo.StudentVO;
import example.db.vo.StudentVO2;


public class MainController {

	private SqlSession session;
	private StudentDAO studentDao;
	private Scanner scan = new Scanner(System.in);

	
	public MainController(SqlSession session) {
		this.session = session;
		studentDao = session.getMapper(StudentDAO.class);
	}
	// 추가 수정 조회
			/*
			 * 학생 추가
			 * 학생 수정
			 * 학생 조회
			 * 프로그램 종료
			 */
	public void run() {
		int menu = -1;
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			
		}while(menu !=4);
		
	}
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			
			studentDao.insertStudent(insertStd());
			
			break;
		case 2:
			
			updateStd();
			break;
		case 3:
			ArrayList<StudentVO2> list = studentDao.selectAllStudent2();
			if(list.size()==0) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			list.forEach(p->System.out.println(p));
			break;
		case 4:
			break;
			default: System.out.println("잘못된 메뉴 선택");
		}
		
	}
	private void updateStd() {
		System.out.println("수정할 학생의 학번을 입력하세요.");
		String st_num = scan.nextLine();
		
		System.out.println("이름 : ");
		String st_name = scan.nextLine();
		System.out.println("교수 교번 : ");
		String st_pr_num = scan.nextLine();
		System.out.println("학기 : ");
		int st_semester = scan.nextInt();
		scan.nextLine();
		System.out.println("상태 : ");
		String st_state = scan.nextLine();
		
		StudentVO std = studentDao.selectStudent(st_num);
		
		if(std == null) {
			System.out.println("학생수정 실패");
			return ;
		}
		std.setSt_name(st_name);
		std.setSt_pr_num(st_pr_num);
		std.setSt_semester(st_semester);
		std.setSt_state(st_state);
		
		studentDao.updateStudent(std);
		
	}
	private StudentVO insertStd() {
		System.out.println("학번 : ");
		String st_num = scan.nextLine();
		System.out.println("이름 : ");
		String st_name = scan.nextLine();
		System.out.println("교수 교번 : ");
		String st_pr_num = scan.nextLine();
		System.out.println("학기 : ");
		int st_semester = scan.nextInt();
		scan.nextLine();
		System.out.println("상태 : ");
		String st_state = scan.nextLine();
		return new StudentVO(st_num, st_name, st_pr_num, st_semester, st_state);
	}
	private void printMenu() {
		System.out.println("메뉴\n1.학생 추가 \n2.학생 수정 \n3.학생 조회 \n4.프로그램 종료"); 
		
	}
	
	
}
