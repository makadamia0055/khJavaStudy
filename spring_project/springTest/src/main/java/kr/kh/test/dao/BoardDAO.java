package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;

public interface BoardDAO {

	ArrayList<BoardTypeVO> selectBoardTypeByAuth(@Param("i")int i);

	int insertBoardCommon(@Param("bo")BoardVO board);

	int insertFileInfo(@Param("fi")FileVO tmpVo);

	ArrayList<BoardVO> selectBoardList(@Param("crit")Criteria crit);

	int selectBoardCount(@Param("crit")Criteria crit);

}
