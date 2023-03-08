package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.pagination.Criteria;
import kr.kh.test.utils.UploadFileUtils;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	String uploadPath ="D:\\uploadfiles";

	@Override
	public ArrayList<BoardTypeVO> getBoardTypeVO(int i) {
		if(i<0) {
			return null;
		}
		return boardDao.selectBoardTypeByAuth(i);
	}

	@Override
	public boolean insertBoard(MemberVO user, BoardVO board, MultipartFile[] files) {
		if(user==null||user.getMe_id()==null) {
			return false;
		}
		if(board==null||board.getBo_title().trim().length()==0||board.getBo_content().trim().length()==0||board.getBo_bt_num()==0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		if(boardDao.insertBoardCommon(board)==0) {
			return false;
		}else {
			//첨부파일 추가
			if(!insertFiles(files, board.getBo_num())) {
				return false;
			}
			
			return true;
		}
	}

	private boolean insertFiles(MultipartFile[] files, int bo_num) {
		String fileName = "";
		for(MultipartFile file : files) {
			if(file==null||file.getOriginalFilename().trim().length()==0) {
				continue;
			}
			try {
				fileName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				
				FileVO tmpVo = new FileVO(bo_num, file.getOriginalFilename(), fileName);
				if(boardDao.insertFileInfo(tmpVo)==0) {
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
		
		
	}

	@Override
	public ArrayList<BoardVO> selectBoardList(Criteria crit) {
		if(crit==null) {
			crit = new Criteria();
		}
		
		return boardDao.selectBoardList(crit);
	}

	@Override
	public int selectBoardCount(Criteria crit) {
		if(crit==null) {
			crit = new Criteria();
		}
		return boardDao.selectBoardCount(crit);
	}

	
}
