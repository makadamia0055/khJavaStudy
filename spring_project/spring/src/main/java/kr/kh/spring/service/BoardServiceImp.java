package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.utils.UploadFileUtils;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";

	@Override
	public ArrayList<BoardTypeVO> getBoardType(int authority) {
		return boardDao.selectAllBoardType(authority);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user==null) {
			return false;
		}
		
		if(!checkBoard(board)) {
			return false;
		}
		
		board.setBo_me_id(user.getMe_id());
		
		// 게시글 등록
		boardDao.insertBoard(board);
/*		mapper에서 useGeneratekey는 해당 작업이 일어난 후 
 * 		기본키를 지정한 프로퍼티에 넣어준다 
 * */		
		
		uploadFiles(files, board.getBo_num());
		
		
		// 첨부파일 서버에 업로드
		
		// 첨부파일 객체를 생성
		
		// dao에게 첨부파일 정보 주면서 추가하라고 요청
		
		return true;
		
	}
	private void uploadFiles(MultipartFile [] files, int bo_num) {
		if(files==null||files.length==0) {
			return ;
		}
		for(MultipartFile file : files) {
			if(file==null||file.getOriginalFilename().length()==0) {
				continue;
			}
			String fileName = "";
			try {
				fileName = UploadFileUtils.uploadFile(uploadPath, 
						file.getOriginalFilename(), // 파일명
						file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			} // 실제 파일 데이터
			System.out.println(fileName);
			FileVO fileVo = new FileVO(file.getOriginalFilename(), fileName, bo_num);
			boardDao.insertFile(fileVo);
		}
	}

	private boolean checkBoard(BoardVO board) {
		if(board==null|| 
				board.getBo_title()==null|| board.getBo_title().trim().length()==0
				||board.getBo_content()==null||board.getBo_content().trim().length()==0)
			return false;
	
		
		return true;
	}

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(int bo_num) {
		// 조회수 증가
		boardDao.updateBoardViews(bo_num);
		// 게시글 가져오기 
		// 순서를 바꾸면 db의 게시글과 화면에 나오는 게시글의 조회수가 다른 경우가 생김
		BoardVO board = boardDao.selectBoard(bo_num);
		return board;
	}

	@Override
	public ArrayList<FileVO> getFileList(int bo_num) {
		return boardDao.selectFileList(bo_num);
	}
	
}
