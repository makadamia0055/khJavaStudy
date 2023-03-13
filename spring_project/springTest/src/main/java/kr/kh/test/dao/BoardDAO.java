package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.LikesVO;

public interface BoardDAO {


	ArrayList<BoardTypeVO> selectBoardTypeList(@Param("authority")int adminAuthority);

	BoardTypeVO selectBoardTypeByName(@Param("bt_name")String bt_name);

	int insertBoardType(@Param("bt")BoardTypeVO bt);

	int updateBoardType(@Param("bt")BoardTypeVO bt);

	boolean deleteBoardType(@Param("bt_num")Integer bt_num);

	int insertBoard(@Param("bo")BoardVO board);

	void insertFile(@Param("file")FileVO fileVo);

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectTotalCountBoard(@Param("cri")Criteria cri);

	int updateViews(@Param("bo_num")int bo_num);

	BoardVO selectBoard(@Param("bo_num")int bo_num);

	ArrayList<FileVO> selectFileList(@Param("bo_num")int bo_num);

	int deleteFiles(@Param("fi_num")int bo_num);
	
	int deleteBoard(@Param("bo")BoardVO board);

	int updateBoard(@Param("bo")BoardVO board);

	FileVO selectFile(@Param("fi_num")int num);

	int updateLikes(@Param("li")LikesVO likeVo);

	int insertLikes(@Param("li")LikesVO likesVO);

	LikesVO selectLikes(@Param("li_bo_num")int li_bo_num, @Param("me_id")String me_id);
	
	void updateBoardUpAndDown(@Param("li_bo_num")int li_bo_num);


}
