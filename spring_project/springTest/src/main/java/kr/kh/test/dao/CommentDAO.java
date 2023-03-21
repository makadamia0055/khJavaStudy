package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.CommentVO;

public interface CommentDAO {

	int insertComment(@Param("comment")CommentVO comment);

	ArrayList<CommentVO> selectCommentList(@Param("cri")Criteria cri, @Param("bo_num")int bo_num);

	int selectWholeCommentCount(@Param("bo_num")int bo_num);

	CommentVO selectCommentByNum(@Param("comment")CommentVO comment);

	int deleteComment(@Param("comment")CommentVO comment);

	int updateComment(@Param("comment")CommentVO comment);


}
