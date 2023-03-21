package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

public interface CommentService {

	public boolean insertComment(CommentVO comment, MemberVO user);

	public ArrayList<CommentVO> selectCommentList(Criteria cri, int bo_num);

	public int selectWholeCommentCount(int bo_num);

	public boolean deleteComment(CommentVO comment, MemberVO user);

}
