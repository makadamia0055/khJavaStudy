package db.day3.dao;

import java.sql.SQLException;

import db.day3.DBConnector;
import db.day3.vo.CourseVO;
import db.day3.vo.LectureVO;

public class CourseMapper implements CourseDAO{
	private DBConnector dbConnector;

	public CourseMapper(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}
	
	@Override
	public void insertLecture(LectureVO lectureVO) {
		String sql = "insert into lecture(le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num) value( ?,?,?,?,?, ? , ? )";
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, lectureVO.getLe_name());
			dbConnector.pstmt.setString(2, lectureVO.getLe_schedule());
			dbConnector.pstmt.setInt(3, lectureVO.getLe_point());
			dbConnector.pstmt.setInt(4, lectureVO.getLe_class());
			dbConnector.pstmt.setInt(5, lectureVO.getLe_year());
			dbConnector.pstmt.setString(6, lectureVO.getLe_term());
			dbConnector.pstmt.setString(7, lectureVO.getLe_pr_num());
			
			int count = dbConnector.pstmt.executeUpdate();
			if(count==0) {
				System.out.println("강좌 정보 추가 실패");
			}else {
				System.out.println("강좌 정보 추가 성공");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLecture(LectureVO lectureVO) {
		String sql = "update lecture set le_name = ? , le_schedule = ? , le_point = ? , le_class = ? , le_year = ? , le_term = ?, le_pr_num = ? where le_num = ?";
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, lectureVO.getLe_name());
			dbConnector.pstmt.setString(2, lectureVO.getLe_schedule());
			dbConnector.pstmt.setInt(3, lectureVO.getLe_point());
			dbConnector.pstmt.setInt(4, lectureVO.getLe_class());
			dbConnector.pstmt.setInt(5, lectureVO.getLe_year());
			dbConnector.pstmt.setString(6, lectureVO.getLe_term());
			dbConnector.pstmt.setString(7, lectureVO.getLe_pr_num());
			dbConnector.pstmt.setInt(8, lectureVO.getLe_num());
			
			int count = dbConnector.pstmt.executeUpdate();
			if(count==0) {
				System.out.println("강좌 정보 수정 실패");
			}else {
				System.out.println("강좌 정보 수정 성공");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteLecture(int le_num) {
		String sql = "delete from lecture where le_num = ?";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setInt(1, le_num);
			
			int count = dbConnector.pstmt.executeUpdate();
			if(count==0) {
				System.out.println("강좌 정보 수정 실패");
			}else {
				System.out.println("강좌 정보 수정 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}
	@Override
	public LectureVO selectLectureByName(String le_name, int le_class, int le_year, String le_term) {
		String sql = "select le_num, le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num from lecture where (le_name like ? and le_class = ? and le_year = ? and le_term like ? )";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1,  le_name);
			dbConnector.pstmt.setInt(2,  le_class);
			dbConnector.pstmt.setInt(3, le_year);
			dbConnector.pstmt.setString(4, le_term);
			dbConnector.rs = dbConnector.pstmt.executeQuery();
			if(dbConnector.rs.next()) {
				int le_num = dbConnector.rs.getInt(1);
				String le_schedule = dbConnector.rs.getString(3);
				int le_point = dbConnector.rs.getInt(4);
				String le_pr_num = dbConnector.rs.getString(8);
				
				return new LectureVO(le_num, le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num);
						
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertCourse(CourseVO courseVO) {
		String sql = "insert into course(co_st_num, co_le_num, co_type) value (?, ?, ?) ";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, courseVO.getCo_st_num());
			dbConnector.pstmt.setInt(2, courseVO.getCo_le_num());
			dbConnector.pstmt.setString(3, courseVO.getCo_type());
			int count = dbConnector.pstmt.executeUpdate();
			if(count==0) {
				System.out.println("수강 신청 실패");
			}else {
				System.out.println("수강 신청 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteCourse(int le_num, String co_st_num) {
		String sql = "delete from course where co_le_num = ? and co_st_num = ?";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setInt(1, le_num);
			dbConnector.pstmt.setString(2, co_st_num);
			int count = dbConnector.pstmt.executeUpdate();
			if(count==0) {
				System.out.println("수강 철회 실패");
			}else {
				System.out.println("수강 철회 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
