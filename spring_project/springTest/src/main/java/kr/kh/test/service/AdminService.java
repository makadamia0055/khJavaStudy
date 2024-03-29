package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.vo.BoardTypeVO;

public interface AdminService {

	ArrayList<BoardTypeVO> selectWholeType();

	boolean insertBoardType(BoardTypeVO bTVO);

	boolean editBoardType(BoardTypeVO bt);

	boolean deleteBoardType(Integer btNum);

}
