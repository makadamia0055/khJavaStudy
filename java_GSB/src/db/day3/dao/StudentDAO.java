package db.day3.dao;

import java.sql.SQLException;

import db.day3.vo.StudentVO;

public interface StudentDAO {

	
	void insertStudent(StudentVO std);
	void updateStudent(StudentVO std);
	StudentVO selectStudent(String st_num);
}
