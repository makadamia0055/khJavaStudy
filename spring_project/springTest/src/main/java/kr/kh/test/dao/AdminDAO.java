package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.BoardTypeVO;

public interface AdminDAO {

	ArrayList<BoardTypeVO> selectWholeType(@Param("authority")int adminAuthority);

}
