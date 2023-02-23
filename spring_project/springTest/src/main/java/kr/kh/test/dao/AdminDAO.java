package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.BoardTypeVO;

public interface AdminDAO {

	ArrayList<BoardTypeVO> selectWholeType(@Param("authority")int adminAuthority);

	BoardTypeVO selectTypeByName(@Param("name")String bt_name);

	int insertNewType(@Param("bt")BoardTypeVO bTVO);

}
