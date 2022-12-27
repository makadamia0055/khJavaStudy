package db.day3.service;

import java.util.Scanner;

import db.day3.DBConnector;
import db.day3.dao.ProfessorMapper;
import db.day3.dao.StudentMapper;
import db.day3.vo.ProfessorVO;
import db.day3.vo.StudentVO;

public class ProfessorServiceImp implements ProfessorService {

	private ProfessorMapper professorDao;
	private Scanner scan = new Scanner(System.in);
	private StudentMapper studentDao;
	
	public ProfessorServiceImp(DBConnector dbConnector) {
		professorDao = new ProfessorMapper(dbConnector);
		studentDao = new StudentMapper(dbConnector);

	}
	
	@Override
	public void insertProfessor() {
		System.out.println("교수 정보를 입력하세요  ");
		System.out.println("교번: ");
		String pr_num = scan.nextLine();
		System.out.println("이름: ");
		String pr_name = scan.nextLine();
		System.out.println("상태: ");
		String pr_state = scan.nextLine();
		System.out.println("학부 번호: ");
		String pr_de_num = scan.nextLine();
		System.out.println("전화번호 : ");
		String pr_tel = scan.nextLine();
		
		ProfessorVO professorVO= new ProfessorVO(pr_num, pr_name, pr_state, pr_de_num, pr_tel);
		professorDao.insertProfessor(professorVO);
		
	}

	public void updateProfessor() {
		System.out.println("수정할 교수 정보를 입력하세요  ");
		System.out.println("교번: ");
		String pr_num = scan.nextLine();
		System.out.println("이름: ");
		String pr_name = scan.nextLine();
		System.out.println("상태: ");
		String pr_state = scan.nextLine();
		System.out.println("학부 번호: ");
		String pr_de_num = scan.nextLine();
		System.out.println("전화번호 : ");
		String pr_tel = scan.nextLine();
		
		ProfessorVO professorVO= new ProfessorVO(pr_num, pr_name, pr_state, pr_de_num, pr_tel);
		professorDao.updateProfessor(professorVO);
		
	
	}
	@Override
	public void updateAdvisor() {
		System.out.println("교수번호: ");
		String st_pr_num = scan.nextLine();
		System.out.println("학번 : ");
		String st_num = scan.nextLine();
		StudentVO std = studentDao.selectStudent(st_num);
		if(std==null) {
			System.out.println("해당 학생이 없습니다.");
			return;
		}
		std.setSt_pr_num(st_pr_num);
		studentDao.updateStudent(std);
		
	}

}
