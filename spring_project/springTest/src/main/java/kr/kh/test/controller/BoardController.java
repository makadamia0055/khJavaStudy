package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.pagination.PageMaker;
import kr.kh.test.service.BoardService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.MemberVO;

@Controller
public class BoardController {
	
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv, Criteria crit) {
		if(crit==null) {
			crit = new Criteria();
		}
		System.out.println(crit);
		ArrayList<BoardVO> list = boardService.selectBoardList(crit);
		int boardCount = boardService.selectBoardCount(crit);
		int viewPage = 4;
		PageMaker pm = new PageMaker(boardCount, viewPage, crit);
		mv.addObject("pm", pm);
		mv.addObject("boardList", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user==null) {
			MessageUtils.alertAndMovePage(resp, "로그인 해주십시오", req.getContextPath(), "/board/list");
		}
		ArrayList<BoardTypeVO> list = boardService.getBoardTypeVO(user.getMe_authority()); 
		mv.addObject("btList", list);
		mv.setViewName("/board/insert");
		return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board, MultipartFile[] files, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		String msg;
		if(user==null) {
			mv.setViewName("/board/insert");
			return mv;
		}
		
		if(!boardService.insertBoard(user, board, files)) {
			msg = "게시글 등록 실패";
			req.setAttribute("url", "/board/insert");

		}else {
			msg = "게시글 등록 성공";
			req.setAttribute("url", "/board/list");
		}
		 
		req.setAttribute("msg", msg);
		
		mv.setViewName("/common/message");
		return mv;
	}
	
	
}
