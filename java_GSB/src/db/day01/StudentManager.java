package db.day01;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public class StudentManager {
	static Statement stmt = null; // 할당할 값이 없을 때 
	static ResultSet rs = null; // 받아온 값 저장할 객체(select로 얻은 쿼리 결과를 resultset이라고 부름)
	static PreparedStatement pstmt = null; // 할당할 값이 있을 때
	static Scanner scan = new Scanner(System.in);
	static Connection con = null;
	static ArrayList<Student> list ;

	public static void main(String[] args) {
	/*
	 * db에서 읽어온 정보를 보여주는 방법
	 * 1. 필요할 때마다 DB에 access
	 * 	-- 데이터 수정이 빈번할 때는 2가 1번과 다름이 없기 때문에 차라리 갱신이 적은 1번이 나을 수도.
	 * 2. DB에서 처음 한번에 전부 읽어온 다음, DB에 접근하는 대신 읽어온 그 정보들을 이후에 뿌려줌. 
	 * 	-- 데이터 소모량 작음. 단, 데이터 삽입, 삭제도 같이 이뤄질 시 데이터 갱신 설정하거나 자바에서 별도의 개체 추가 과정 필요
	 * 	-- 웹이라면 실시간으로 주고받는게 맞다. 그러나 이건 콘솔이라.
	 */
		
		
		int menu = -1;
		load();
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			try {
				runMenu(menu);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}while(menu!=4);
		
		
	}
	private static void load() {
		try {
			list = selectStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void runMenu(int menu) throws SQLException {
		switch(menu) {
		case 1:
			login();
			
			break;
		case 2: 
			if(!checklogin()) {
				break;
			}
			Student std = null;
			std = inputStudent();
			
			insertStudent(std);
			break;
		case 3:
			if(!checklogin()) {
				break;
			}
			ArrayList<Student> list = selectStudent();
			printStudent(list);
			break;
		case 4: connectClose(); break;
		default: System.out.println("잘못된 메뉴 접근입니다.");
		}
	}
	private static void printStudent(ArrayList<Student> list) {
		for(Student tmp : list) {
			System.out.printf("학번 : %s | 이름 : %s | 학기 : %d | 상태 : %s | 지도교수 : %s \n", tmp.getSt_num(), tmp.getSt_name(), tmp.getSt_semester(), tmp.getSt_state(), tmp.getSt_pr_num());
		}
		
	}
	public static boolean checklogin() {
		if(con==null) {
			System.out.println("로그인 되지 않은 사용자 입니다.");
			return false;
		}else {
			return true;
		}
	}
	private static void login() {
		String url = "jdbc:mysql://localhost/university";

		System.out.println("데이터베이스 아이디를 입력해주세요");
		String id = scan.nextLine();
		System.out.println("데이터베이스 비밀번호를 입력해주세요");

		String pw = scan.nextLine();
		con = connect(url, id, pw);
		if(con!=null) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}

	}
	private static Student inputStudent() {
		System.out.println("학생의 신상정보를 입력해주세요.");
		System.out.print("학번 : ");
		String stdnum = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("학기 : ");
		int semester = scan.nextInt();
		scan.nextLine();
		System.out.print("상태 : ");
		String state = scan.nextLine();
		System.out.print("지도교수 교번 : ");
		String prNum = scan.nextLine();
		
		return new Student(stdnum, name, semester, state, prNum);
	}
	private static void printMenu() {
		System.out.println("메뉴 입력");
		System.out.println("-----------------");
		System.out.println("1. 로그인");
		System.out.println("2. 학생기입");
		System.out.println("3. 학생열람");
		System.out.println("4. 종료 ");
		System.out.println("-----------------");
		System.out.print("메뉴 입력 : ");
	}
	public static Connection connect(String url, String id, String pw) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("연결 성공");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	public static void connectClose() {
		try {
			if(con !=null && !con.isClosed()) {
				con.close();
				System.out.println("[연결 해제]");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static ArrayList<Student> selectStudent() throws SQLException {
		stmt = con.createStatement();
		String sql = "select * from student";
		rs = stmt.executeQuery(sql);
		ArrayList<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(4);
			String st_state = rs.getString(5);
			String st_pr_num = rs.getString(3);
			Student std = new Student(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
		}
		return list;
	}
	public static void insertStudent(Student std) throws SQLException {
		String sql = "insert into student(st_num, st_name, st_semester, st_state, st_pr_num) value(?, ?, ?, ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, std.getSt_num());
		pstmt.setString(2, std.getSt_name());
		pstmt.setInt(3, std.getSt_semester());
		pstmt.setString(4, std.getSt_state());
		pstmt.setString(5, std.getSt_pr_num());
		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("추가 실패");
		}else {
			System.out.println("추가 성공");
		}
	}
}
@Data
class Student{
	private String st_num;
	private String st_name;
	private int st_semester;
	private String st_state;
	private String st_pr_num;
	
	public Student(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
}
	
	
}	