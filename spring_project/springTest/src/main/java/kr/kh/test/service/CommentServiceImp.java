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
			cri= new Criteria();
		return commentDao.selectCommentList(cri, bo_num);
	}

	@Override
	public int selectWholeCommentCount(int bo_num) {
		return commentDao.selectWholeCommentCount(bo_num);
	}

	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(comment ==null)
			return false;
		if(user == null || user.getMe_id() == null)
			return false;
		CommentVO tmpComment = commentDao.selectCommentByNum(comment);
		if(!tmpComment.getCo_me_id().equals(user.getMe_id())) {
			System.out.println("유저 다름");
			return false;
		}
		return commentDao.deleteComment(comment)!=0;
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(comment ==null||comment.getCo_num()<0)
			return false;
		if(user == null || user.getMe_id() == null)
			return false;
		CommentVO tmpComment = commentDao.selectCommentByNum(comment);
		if(tmpComment==null) {
			System.out.println("검색 결과 없음");
			return false;
		}
		if(!tmpComment.getCo_me_id().equals(user.getMe_id())) {
			System.out.println("유저 다름");
			return false;
		}
		comment.setCo_me_id(user.getMe_id());
		return commentDao.updateComment(comment)!=0;
	}

	
}
