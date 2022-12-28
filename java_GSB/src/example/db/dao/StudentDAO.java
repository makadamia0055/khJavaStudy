package example.db.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import example.db.vo.StudentVO;
import example.db.vo.StudentVO2;

public interface StudentDAO {

	ArrayList<StudentVO> selectAllStudent();
	void insertStudent(StudentVO std);
	void updateStudent(StudentVO updateStd);
	StudentVO selectStudent(String st_num);
	ArrayList<StudentVO2> selectAllStudent2();
	
}
