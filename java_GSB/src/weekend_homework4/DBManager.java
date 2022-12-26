package weekend_homework4;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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


	
	public DBManager() {
		super();
	}
	
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
			con = DriverManager.getConnection("jdbc:mysql://localhost/university?createDatabaseIfNotExist=true", "root", "root");
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
	public void printCount() throws SQLException {
		int count = pStmt.executeUpdate();
		if(count ==0) {
			System.out.println("추가 실패");
		}else {
			System.out.println("추가 성공");
		}
	}
	
	public <T> void selectObj(T t) throws SQLException {
		String sql = "select * from ";
		sql = sql+ t.getClass().getSimpleName();
		System.out.println(sql);
		stmt = con.createStatement();
				
		rs = stmt.executeQuery(sql);
		
		switch(t.getClass().getSimpleName()) {
		case "Course":
			while(rs.next()) {
				String co_num = rs.getString(1);
				String co_le_num = rs.getString(2);
				String co_st_num = rs.getString(3);
				String co_type = rs.getString(4);
				String co_grade= rs.getString(5);
				Course course = new Course(co_num, co_le_num, co_st_num, co_type, co_grade);
				courseList.add(course);
			}
			// 향후 성적 조회 조인으로 쿼리 제대로 만들기
			courseList.forEach(d-> System.out.println(d.getCo_num()+ "| "+ d.getCo_le_num() + " | " + d.getCo_st_num() + " | " +d.getCo_type() + "|"+ d.getCo_grade()));
			
			break;
			
		case "Department":
			while(rs.next()) {
				String de_num = rs.getString(1);
				String de_name = rs.getString(2);
				String de_address = rs.getString(3);
				String de_tel = rs.getString(4);
				String de_pr_num= rs.getString(5);
				Department dpt = new Department(de_num, de_name, de_address, de_tel, de_pr_num);
				departmentList.add(dpt);
			}
			departmentList.forEach(d-> System.out.println(d.getDe_num()+ "| "+ d.getDe_name() + " | " + d.getDe_pr_num() + " | " +d.getDe_tel() + "|"+ d.getDe_address()));

			break;
		case "Lecture" :
			while(rs.next()) {
				String le_num = rs.getString(1);
				String le_pr_num = rs.getString(2);
				String le_name = rs.getString(3);
				String le_current_capa = rs.getString(4);
				String le_schedule= rs.getString(5);
				String le_point= rs.getString(6);
				String le_year= rs.getString(7);
				String le_term= rs.getString(8);
				String le_class= rs.getString(9);
				Lecture lecture = new Lecture(le_num, le_pr_num, le_name, le_current_capa, le_schedule, le_point, le_year, le_term, le_class);
				lectureList.add(lecture);
			}
			lectureList.forEach(d-> System.out.println(d.getLe_num()+ "| "+ d.getLe_pr_num() + " | " + d.getLe_name() + " | " +d.getLe_current_capa() + "|"+ d.getLe_schedule()
			+ "|" + d.getLe_point() +"|"+ d.getLe_year() +"|" + d.le_term + "|" + d.le_class));

			break;
			
		case "Professor" : 
			while(rs.next()) {
				String pr_num = rs.getString(1);
				String pr_name = rs.getString(2);
				String pr_tel = rs.getString(3);
				String pr_de_num = rs.getString(4);
				String pr_state= rs.getString(5);
				Professor professor = new Professor(pr_num, pr_name, pr_tel, pr_de_num, pr_state);
				professorList.add(professor);
			}
			professorList.forEach(d-> System.out.println(d.getPr_num()+ "| "+ d.getPr_name() + " | " + d.getPr_tel() + " | " +d.getPr_de_num() + "|"+ d.getPr_state()));

			break;
		case "Score" :
			while(rs.next()) {
				int sc_num = rs.getInt(1);
				int sc_mid = rs.getInt(2);
				int sc_final = rs.getInt(3);
				int sc_homework = rs.getInt(4);
				int sc_attendance = rs.getInt(5);
				int sc_total = rs.getInt(6);
				int sc_co_num = rs.getInt(7);
				Score score = new Score(sc_num, sc_mid, sc_final, sc_homework, sc_attendance, sc_total, sc_co_num);
				scoreList.add(score);
			}
			scoreList.forEach(d-> System.out.println(d.getSc_num()+ "| "+ d.getSc_mid() + " | " + d.getSc_final() + " | " +d.getSc_homework() + "|"+ d.getSc_attendance() + "|"+ d.getSc_total() +"|"+ d.getSc_co_num()));

			break;
		case "Student" :
			while(rs.next()) {
				String st_num = rs.getString(1);
				String st_name = rs.getString(2);
				String st_pr_num = rs.getString(3);
				String st_state = rs.getString(4);
				String st_semester= rs.getString(5);
				Student std = new Student(st_num, st_name, st_semester, st_state, st_pr_num);
				studentList.add(std);
			}
			break;
			default:
		}
		studentList.forEach(d-> System.out.println(d.getSt_num()+ "| "+ d.getSt_name() + " | " + d.getSt_pr_num() + " | " +d.getSt_state() + "|"+ d.getSt_semester()));

		
	}
	public <T> void insertObj(T t) throws SQLException{
		String sql = makeInsertStr(t, "insert into ? value(");
		pStmt = con.prepareStatement(sql);
		
		pStmt.setString(1, t.getClass().getSimpleName());
//		setPstmt(t);
		int count = t.getClass().getDeclaredFields().length;
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<count ; i++) {
			System.out.println(t.getClass().getDeclaredFields()[i]+"를 입력해주십시오.");
			String str = scan.nextLine();
			pStmt.setString(i+2, str);
		}
		String newstr = pStmt.toString().substring(pStmt.toString().indexOf(":")+2).replaceFirst("\'", "").replaceFirst("\'", "") + ";";

		pStmt = con.prepareStatement(newstr);
		int cnt = pStmt.executeUpdate();
		if(cnt==0) {
			System.out.println("입력 실패");
		}else {
			System.out.println("");
		}
		

		
	} 
	
	public static <T> String makeInsertStr(T t, String str) {
		int count = t.getClass().getDeclaredFields().length;
//		for(int i = 0; i<count-1; i++) {
//			str = str.concat("?,");
//		}
//		str = str.concat("?) value(");
		for(int i = 0; i<count-1; i++) {
			str = str.concat("?,");
		}
		str = str.concat("?)");
		
		return str;
	}
	public <T> void setPstmt(T t) throws SQLException {
				
		Field[] TArr= t.getClass().getDeclaredFields();
		for(int i = 0; i<TArr.length; i++) {
			pStmt.setString(i+2, TArr[i].getName());
			
		}
			
	}
	public <T> void updateObj(T t) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 "+t.getClass().getName()+"의 "+t.getClass().getDeclaredFields()[0].getName()+"를 입력해주세요.");
		String primary_key = scan.nextLine();
		
		String sql = "update ? set ?=? where ?=?";
		
		
		int count = t.getClass().getDeclaredFields().length;
		String four =t.getClass().getDeclaredFields()[0].getName();
		String two;
		for(int i = 1; i<count ; i++) {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, t.getClass().getSimpleName());
			pStmt.setString(4, four);
			pStmt.setString(5, primary_key);
			
			System.out.println(""+t.getClass().getDeclaredFields()[i].getName()+"의 값을 입력하십시오(공백입력시 생략)");
			String tmp = scan.nextLine();
			if(!tmp.equals("")) {
				two = t.getClass().getDeclaredFields()[i].getName();
				pStmt.setString(2, two);
				pStmt.setString(3, tmp);
				String newsql = pStmt.toString().substring(pStmt.toString().indexOf(":")+2).replaceFirst("\'", "").replaceFirst("\'", "").replaceFirst("\'"+two+"\'", two).replaceFirst("\'"+four+"\'", four) + ";";
				System.out.println(newsql);
				int cnt = pStmt.executeUpdate(newsql);
				if(cnt==0) {
					System.out.println("수정 실패");
				}else {
					System.out.println("수정 성공");
				}
			}
			
		}
		
		
	}
	
	

	public <T> void deleteObj(T t) throws SQLException {
		String sql = "delete from ? where ? = ?";
		System.out.println("삭제할 대상의 기본키를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		String primaryKey = scan.nextLine();
		pStmt = con.prepareStatement(sql);
		Field[] primarykeyArr = t.getClass().getDeclaredFields();
		pStmt.setString(1, t.getClass().getSimpleName());
		pStmt.setString(2, primarykeyArr[0].getName());
		pStmt.setString(3, primaryKey);
		String newsql = pStmt.toString().substring(pStmt.toString().indexOf(":")+2).replace("\'", "") + ";";
		System.out.println(newsql);
		
		int count = pStmt.executeUpdate(newsql);
		if(count==0) {
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 성공");
		}
	}

	
	
}
