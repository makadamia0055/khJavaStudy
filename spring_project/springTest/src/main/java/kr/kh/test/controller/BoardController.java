package kr.kh.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.pagination.PageMaker;
import kr.kh.test.service.BoardService;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.LikesVO;
import kr.kh.test.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		ArrayList<BoardTypeVO> typeList = 
				boardService.getBoardTypeList(user);
		mv.addObject("typeList", typeList);
		mv.setViewName("/board/insert");
		return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, 
			HttpSession session, BoardVO board, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		String msg;
		if(boardService.insertBoard(board,user,files)) {
			msg = "게시글 등록 성공!";
		}else {
			msg = "게시글 등록 실패!";
		}
		mv.addObject("msg",msg);
		mv.addObject("url","/board/list");
		mv.setViewName("/common/message");
		return mv;
	}
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		cri.setPerPageNum(5);
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCountBoard(cri);
		int displayPageNum = 3;
		PageMaker pm = 
			new PageMaker(totalCount, displayPageNum, cri);
		MemberVO user = new MemberVO();
		user.setMe_authority(10);
		ArrayList<BoardTypeVO> btList = boardService.getBoardTypeList(user);
		mv.addObject("btList", btList);
		mv.addObject("list", list);
		mv.addObject("pm", pm);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value="/board/detail/{bo_num}", method=RequestMethod.GET)
	public ModelAndView boardDetail(ModelAndView mv,
			@PathVariable("bo_num")int bo_num, HttpSession session) {
		BoardVO board = boardService.getBoardAndUpdateView(bo_num);
		ArrayList<FileVO> fileList = boardService.getFileList(bo_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		LikesVO likesVo = boardService.getLikes(user, bo_num);
		mv.addObject("like", likesVo);
		mv.addObject("board", board);
		mv.addObject("fileList", fileList);
		mv.setViewName("/board/detail");
		return mv;
	}
	@RequestMapping(value="/board/like/{bo_num}/{li_state}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> boardLikeState(ModelAndView mv, HttpSession session,
			@PathVariable("bo_num")int li_bo_num, @PathVariable("li_state")int li_state) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Map<String, Object> map = new HashMap<String, Object>();
		int res = boardService.updateLike(li_bo_num, li_state, user);
		BoardVO board = boardService.getBoardAndUpdateView(li_bo_num);
		map.put("board", board);
		map.put("state", res);
		return map;
	}
	
	
	
	@RequestMapping(value="/board/delete/{bo_num}", method=RequestMethod.POST)
	public ModelAndView boardDelete(ModelAndView mv,
			@PathVariable("bo_num")int bo_num, HttpServletRequest req, HttpSession session) {
		MemberVO user =(MemberVO)session.getAttribute("user");
		System.out.println(user);
		String msg = "";
		if(boardService.boardDelete(user, bo_num)) {
			msg="게시글 삭제를 성공했습니다.";
		}else {
			msg="게시글 삭제를 실패했습니다.";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", "/board/list");
		mv.setViewName("/common/message");
		return mv;
	}
	@RequestMapping(value="/board/update/{bo_num}", method=RequestMethod.GET)
	public ModelAndView boardUpdate(ModelAndView mv, @PathVariable("bo_num")int bo_num, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		ArrayList<BoardTypeVO> btList = boardService.getBoardTypeList(user);
		BoardVO board = boardService.justGetBoard(bo_num);
		ArrayList<FileVO> fileList = boardService.getFileList(bo_num);

		mv.addObject("fileList", fileList);
		mv.addObject("btList", btList);
		mv.addObject("board", board);
		mv.setViewName("/board/update");
		return mv;
	}
	@RequestMapping(value="/board/update/{bo_num}", method=RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv, @PathVariable("bo_num")int bo_num, HttpSession session, BoardVO board, MultipartFile[] files, int[] fileNums){
		MemberVO user = (MemberVO)session.getAttribute("user");
		ArrayList<FileVO> fileList = boardService.getFileList(bo_num);
		boolean res = boardService.updateBoard(board, user, files, fileNums);
		String url = "/board/detail/"+bo_num;
		String msg; 
		if(res) {
			msg = "게시글 수정 성공!";
		}else {
			msg = "게시글 수정 실패!";
		}
		mv.addObject("msg", msg);
		mv.addObject("url", url);
		mv.setViewName("/common/message");
		return mv;
	}
}
