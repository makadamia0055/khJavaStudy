package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.CommentDAO;
import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;
	
	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment ==null || comment.getCo_content() == null || 
				comment.getCo_content().trim().length() ==0)
			return false;
		if(user == null || user.getMe_id() == null)
			return false;
		comment.setCo_me_id(user.getMe_id());
		return commentDao.insertComment(comment) !=0;
	}

	@Override
	public ArrayList<CommentVO> selectCommentList(Criteria cri, int bo_num) {
		if(cri==null)
			return null;
		if(bo_num<0)
			return null;
		return commentDao.selectCommentList(cri, bo_num);
	}

	@Override
	public int selectWholeCommentCount(int bo_num) {
		return commentDao.selectWholeCommentCount(bo_num);
	}
}
