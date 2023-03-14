package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.LikesVO;
import kr.kh.test.vo.MemberVO;

public interface BoardService {


	ArrayList<BoardTypeVO> getBoardTypeList(MemberVO user);

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	ArrayList<BoardVO> getBoardList(Criteria cri);

	int getTotalCountBoard(Criteria cri);

	BoardVO getBoardAndUpdateView(int bo_num);

	ArrayList<FileVO> getFileList(int bo_num);

	boolean boardDelete(MemberVO user, int bo_num);

	BoardVO justGetBoard(int bo_num);

	boolean updateBoard(BoardVO board, MemberVO user, MultipartFile[] files, int[] fileNums);

	int updateLike(int li_bo_num, int li_state, MemberVO user);

	LikesVO getLikes(MemberVO user, int li_bo_num);


}
