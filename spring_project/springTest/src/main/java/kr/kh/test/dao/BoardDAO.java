package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardTypeVO> selectBoardTypeByAuth(@Param("i")int i);

	int insertBoardCommon(@Param("bo")BoardVO board);

}
