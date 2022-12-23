package weekend_homework4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lombok.Data;

@Data
public class DBManager {
	private ArrayList<Department> departmentList = new ArrayList<>();
	private ArrayList<Lecture> lectureList = new ArrayList<>();
	private ArrayList<Professor> professorList = new ArrayList<>();
	private ArrayList<Student> studentList = new ArrayList<>();
	private ArrayList<Course> courseList = new ArrayList<>();
	private ArrayList<Score> scoreList = new ArrayList<>();
	private Statement stmt = null;
	private PreparedStatement pStmt = null;
	private Connection con = null;
	private ResultSet rs = null;


	public DBManager(ArrayList<Department> departmentList, ArrayList<Lecture> lectureList,
			ArrayList<Professor> professorList, ArrayList<Student> studentList, ArrayList<Course> courseList,
			ArrayList<Score> scoreList) {
		this.departmentList = departmentList;
		this.lectureList = lectureList;
		this.professorList = professorList;
		this.studentList = studentList;
		this.courseList = courseList;
		this.scoreList = scoreList;
		
	}
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/university", "root", "root");
			System.out.println("임시 : 연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 "+e.getMessage());	
		}
		
	}
	public void connectClose() {
		try {
			if( con!=null&& !con.isClosed()){
				con.close();
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	
	public void selectStudent() throws SQLException {
		String sql = "select * from student";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester= rs.getInt(4);
			String st_state = rs.getString(5);
			String st_pr_num = rs.getString(3);
			Student std = new Student(st_num, st_name, st_semester, st_state, st_pr_num);
			studentList.add(std);
		}
	}
	public void insertStudent(Student std) throws SQLException{
		String sql = "insert into student(st_num, st_name, st_semester, st_state, st_pr_num)";
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, std.st_num);
		pStmt.setString(2, std.st_name);
		pStmt.setInt(3, std.st_semester);
		pStmt.setString(4, std.st_state);
		pStmt.setString(5, std.st_pr_num);
		
		int count = pStmt.executeUpdate();
		if(count ==0) {
			System.out.println("추가 실패");
		}else {
			System.out.println("추가 성공");
		}
	} // 그냥 이걸 상속 관계로 여러 매니저로 할까 생각중?
	
	
}
