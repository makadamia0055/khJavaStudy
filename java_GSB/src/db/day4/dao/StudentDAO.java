package db.day4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day4.vo.CourseVO;
import db.day4.vo.StudentVO;

public interface StudentDAO {
	
	ArrayList<StudentVO> selectAllStudent();

	void insertStudent(@Param("std")StudentVO std);
	// 매개변수가 2개 이상인 경우는 @Param을 붙여야 함.

	void insertCourse(CourseVO co);

}
