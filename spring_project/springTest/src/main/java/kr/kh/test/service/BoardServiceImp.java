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
import kr.kh.test.vo.LikesVO;
import kr.kh.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";

	@Override
	public ArrayList<BoardTypeVO> getBoardTypeList(MemberVO user) {
		if(user == null || user.getMe_authority() == 0)
			return null;
		return boardDao.selectBoardTypeList(user.getMe_authority());
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || user.getMe_authority() == 0)
			return false;
		if(board == null || 
			board.getBo_title().trim().length() == 0 ||
			board.getBo_content().trim().length() == 0 ||
			board.getBo_bt_num() == 0)
			return false;
		
		board.setBo_me_id(user.getMe_id());
		
		int isOk = boardDao.insertBoard(board);
		
		if(isOk == 0)
			return false;
		//첨부파일 추가
		insertFileList(board.getBo_num(), files);
		return true;
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		cri = cri == null ? new Criteria() : cri;
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalCountBoard(Criteria cri) {
		cri = cri == null ? new Criteria() : cri;
		return boardDao.selectTotalCountBoard(cri);
	}

	@Override
	public BoardVO getBoardAndUpdateView(int bo_num) {
		
		int res;
		res = boardDao.updateViews(bo_num);
		if(res == 0)
			return null;
			return boardDao.selectBoard(bo_num);
		}

	@Override
	public ArrayList<FileVO> getFileList(int bo_num) {
			return boardDao.selectFileList(bo_num);
		}

	@Override
	public boolean boardDelete(MemberVO user, int bo_num) {
		if(bo_num<0) {
			return false;
		}
		BoardVO board = boardDao.selectBoard(bo_num);
		if(board==null)
			return false;
		if(user==null||!user.getMe_id().equals(boardDao.selectBoard(bo_num).getBo_me_id())) {
			return false;
		}
		ArrayList<FileVO> files = getFileList(bo_num);
		deleteFileList(files);
		if(boardDao.deleteBoard(board)==0){
			return false;
		}else {
			return true;
			
		}
			
		
	}
	private void insertFileList(int bo_num, MultipartFile[] files) {
		if(files == null || files.length == 0)
			return;
		for(MultipartFile file : files) {
			if(file == null || file.getOriginalFilename().length() == 0)
				continue;
			try {
				String path = UploadFileUtils.uploadFile(uploadPath, 
						file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(bo_num, file.getOriginalFilename(), path 
						);
				boardDao.insertFile(fileVo);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
		}
	}
	
	private void deleteFileList(ArrayList<FileVO> fileList) {
		if(fileList ==null || fileList.size()==0) {
			return;
		}
		String uploadPath = "D:\\uploadfiles\\";
		for(FileVO file : fileList) {
			if(UploadFileUtils.removeFile(uploadPath, file.getFi_name())) {
				System.out.println(file.getFi_ori_name() + "삭제 성공");
				boardDao.deleteFiles(file.getFi_num());
			}else {
				System.out.println(file.getFi_ori_name() + "삭제 실패");
			}
		}
	}

	@Override
	public BoardVO justGetBoard(int bo_num) {
		if(bo_num<0) {
			return null;
		}
		return boardDao.selectBoard(bo_num);
		
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, MultipartFile[] files, int[] fileNums) {
		if(user==null)
			return false;
		if(board==null||board.getBo_title().trim().length() == 0||
				board.getBo_content().trim().length()==0||
				board.getBo_bt_num()<=0)
			return false;
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		if(dbBoard==null)
			return false;
		if(!dbBoard.getBo_me_id().equals(user.getMe_id()))
			return false;
		
		int res = boardDao.updateBoard(board);
//		수정 누르고 아무 수정 안하고 제출하면 어떻게 처리 할 것인가
		if(res==0)
			return false;
		// 게시글 첨부파일 수정
		// 새 첨부파일 등록
		insertFileList(board.getBo_num(), files);
		
		// 기존 첨부파일을 삭제하지 않는 경우
		if(fileNums == null|| fileNums.length == 0)
			return true;
		
		//첨부파일을 삭제하는 메소드를 이용하기 위해서
		//int[] 정보를=> ArrayList<fileVO>로 변환하는 작업
		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		for(int num : fileNums) {
			FileVO fileVo = boardDao.selectFile(num);
			if(fileVo==null)
				continue;
			fileList.add(fileVo);
		}
		deleteFileList(fileList);
		return true;
		
	}

	@Override
	public int updateLike(int li_bo_num, int li_state, MemberVO user) {
		if(user==null)
			return -100;
		
		int res = 0;
		LikesVO dbLikesVo = boardDao.selectLikes(li_bo_num, user.getMe_id());
		if(dbLikesVo==null) {
			LikesVO likesVo = new LikesVO(li_state, user.getMe_id(), li_bo_num);
			boardDao.insertLikes(likesVo);
			res = li_state;
		}else if(dbLikesVo.getLi_state()==li_state) {
			//취소
			LikesVO likesVo = new LikesVO(0, user.getMe_id(), li_bo_num);
			boardDao.updateLikes(likesVo);
			res = 0;
		}else {
			// 변경
			LikesVO likesVo = new LikesVO(li_state, user.getMe_id(), li_bo_num);
			boardDao.updateLikes(likesVo);
			res = li_state;
		}
		boardDao.updateBoardUpAndDown(li_bo_num);

		return res;
	}

	@Override
	public LikesVO getLikes(MemberVO user, int li_bo_num) {
		if(user ==null)
			return null;
		LikesVO likesVo = boardDao.selectLikes(li_bo_num,  user.getMe_id());
		return likesVo;
	}

	
	
}
