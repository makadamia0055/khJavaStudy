package db.day01;

import java.sql.*;
import java.util.ArrayList;

import lombok.Data;

public class DBTest1 {
	static Statement stmt = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	public static void main(String[] args) {
		Connection conn = null;

		 String url = "jdbc:mysql://localhost/university";
         String id = "root";
         String pw = "root";
 		ArrayList<Student1> list = null;

         conn = connect(url, id, pw);
         
         // 쿼리 수행을 위한 객체 만들기
         try {
			stmt = conn.createStatement();
			
			//insertStudent(conn, "2022160004", "라길동", 1, "휴학중", "2022160002");
			//updateStudent(conn, "2022160001", "가나다");
			deleteStudent(conn, "2022160006");
			
			list = selectStudent(conn);
			System.out.println(list);
			connectClose(conn);
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	}
	
	private static void updateStudent(Connection conn, String st_num, String st_name) throws SQLException {
		String sql = "update student set st_name = ? where st_num = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, st_name);
		pstmt.setString(2, st_num);
		
		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("수정 실패");
		}else {
			System.out.println("수정 성공");
		}
		
	}
	
	public static void deleteStudent(Connection conn, String st_num) throws SQLException {
		String sql = "delete from student where st_num = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, st_num);
		
		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 성공");
		}
	}

	public static Connection connect(String url, String id, String pw) {
		Connection conn = null;
		
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            /* mysql : DBMS
             * localhost : 내부 로컬 주소-> 프로그램이 실행되는 곳과 db가 같은 pc에 있는 상태에서 테스트할때
             * 
             */
            // "jdbc:DBMS://ip/데이터베이스 이름";
           
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("[연결 성공]");

        }
        catch(ClassNotFoundException e){
            System.out.println("[드라이버 로딩 실패]");
        }
        catch(SQLException e){
            System.out.println("[에러: " + e +"]");
        }
        return conn;
	}
	
	public static void connectClose(Connection con) {
		try{
            if( con != null && !con.isClosed()){
                con.close();
                System.out.println("[연결 해체]");
            }
        }
        catch( SQLException e){
            e.printStackTrace();
        }
	}
	
	public static ArrayList<Student1> selectStudent(Connection con) throws SQLException{
		
		
		String sql = "select * from student";
		rs = stmt.executeQuery(sql);
		ArrayList<Student1> list = new ArrayList<Student1>();
		while(rs.next()) {
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(4);
			String st_state = rs.getString(5);
			String st_pr_num = rs.getString(3);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
		}
		return list;
	
	}
	
	public static void insertStudent(Connection conn, String st_num, String st_name, int st_semester, String st_state, String st_pr_num) throws SQLException {
		String sql = "insert into student(st_num, st_name, st_semester, st_state, st_pr_num) values(?, ?, ?, ?, ?)";
	    
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, st_num);
		pstmt.setString(2, st_name);
		pstmt.setInt(3, st_semester);
		pstmt.setString(4, st_state);
		pstmt.setString(5, st_pr_num);
		// String sql 문자열에 넣는 거기 때문에 일단은 String으로 그런데 int로 해도 자동 캐스팅 됨.
		
		int count = pstmt.executeUpdate(); // 몇개의 값을 넣었는가(몇개에 영향을 미쳤는가 갯수 리턴)
		// sql에서 어떤 쿼리를 실행할 때 row affected 같이 영향을 끼친, 혹은 접근한 값의 갯수를 리턴해줌. 그걸 받아와 리턴해줌.
		if(count == 0 ) {
			System.out.println("추가 실패");
		}else {
			System.out.println("추가 성공");
		}
}
}
	
@Data
	class Student1{
		private String st_num;
		private String st_name;
		private int st_semester;
		private String st_state;
		private String st_pr_num;
		
		public Student1(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
			this.st_num = st_num;
			this.st_name = st_name;
			this.st_semester = st_semester;
			this.st_state = st_state;
			this.st_pr_num = st_pr_num;
	}
		
}	
