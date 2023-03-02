package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.service.BoardService;
import kr.kh.spring.utils.MessageUtils;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikesVO;
import kr.kh.spring.vo.MemberVO;

//@RequestMapping(value="/board") // 여기에 추가하면 기본 경로를 저걸로 매핑
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value ="/board/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		mv.setViewName("/board/list");
		// 우선 전체 게시글을 가져오는 코드로 작성하고 
				// 추후에 페이지네이션 및 검색기능을 적용
		ArrayList<BoardVO> list = boardService.getBoardList();
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value ="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv, HttpServletRequest request) {
		// 세션에서 회원 정보 가져옴
		// => 쓰기 권한이 있는 게시판을 가져오기 위해서
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		ArrayList<BoardTypeVO> btList = boardService.getBoardType(user.getMe_authority());
		mv.addObject("btList", btList);
//		작성할 타입이 없으면 작성 페이지로 갈 필요가 없어서 게시글 리스트로 		
		if(btList.size()==0) {
			mv.setViewName("redirect:/board/list");
		}else {
			
			mv.setViewName("/board/insert");
		}
		
		return mv;
	}
	@RequestMapping(value ="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board,
			HttpSession session, MultipartFile[] files) {
			//input.jsp의 files와 이름 맞춰야함.
		
		// 세션에 잇는 회원 정보 가져옴. 작성자에 넣어주려고
		MemberVO user = (MemberVO)session.getAttribute("user");
		// 게시글 정보와 회원 정보를 이용하여 게시글 등록하라고 시킴
		boardService.insertBoard(board, user, files);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value ="/board/detail/{bo_num}", method=RequestMethod.GET)
	public ModelAndView boardDetail(ModelAndView mv,@PathVariable("bo_num")int bo_num, HttpSession session, HttpServletResponse res) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		BoardVO board = boardService.getBoard(bo_num, user);
		ArrayList<FileVO> files = boardService.getFileList(bo_num);
		LikesVO likesVo = boardService.getLikes(bo_num, user);
		mv.addObject("likes", likesVo);
		mv.addObject("board", board);
		mv.addObject("files", files);
		if(board==null) {
			MessageUtils.alertAndMovePage(res, "삭제된 게시글이거나 조회 권한이 없습니다.", "/spring", "/board/list");
			
		}else {

			mv.setViewName("/board/detail");
		}
		return mv;
	}
	@ResponseBody // 리턴값을 직접 화면에 보내주겠다는 표시
	@RequestMapping(value ="/board/like/{li_state}/{bo_num}", method=RequestMethod.GET)
	public Map<String, Object> boardLike(ModelAndView mv, BoardVO board,
			HttpSession session, @PathVariable("li_state")int li_state,
			@PathVariable("bo_num")int bo_num) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		HashMap<String, Object> map = new HashMap<String, Object>();
		// res가 1이면 추천 -1이면 비추천
		int res = boardService.updateLikes(user, bo_num, li_state);
		map.put("res", res);
		return map;
	}
	@RequestMapping(value ="/board/delete/{bo_num}", method=RequestMethod.GET)
	public ModelAndView boardDelete(ModelAndView mv,
			HttpSession session, @PathVariable("bo_num")int bo_num, HttpServletResponse response) {
		// 세션에 있는 회원 정보 가져옴. 작성자와 아이디 같은지 확인하려고	
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.deleteBoard(bo_num, user);
		if(res) {
			MessageUtils.alertAndMovePage(response, "게시글을 삭제했습니다.", "/spring", "/board/list");
		}else {
			MessageUtils.alertAndMovePage(response, "작성자가 아니거나 이미 삭제된 게시글 입니다.", "/spring", "/board/list");
		}
		return mv;
	}
	@RequestMapping(value ="/board/update/{bo_num}", method=RequestMethod.GET)
	public ModelAndView boardUpdate(ModelAndView mv,
			HttpSession session, @PathVariable("bo_num")int bo_num, HttpServletResponse response) {
		// 세션에 있는 회원 정보 가져옴. 작성자와 아이디 같은지 확인하려고	
		MemberVO user = (MemberVO)session.getAttribute("user");
		BoardVO board = boardService.getBoardByWriteAuthority(bo_num, user);
		ArrayList<FileVO> files = boardService.getFileList(bo_num);

		if(board==null) {
			MessageUtils.alertAndMovePage(response, "작성자가 아니거나 존재하지 않는 게시글 입니다.", "/spring", "/board/list");
		}else {
			mv.addObject("board", board);
			ArrayList<BoardTypeVO> btList = boardService.getBoardType(user.getMe_authority());
			mv.addObject("btList", btList);
			mv.addObject("files", files);
//			작성할 타입이 없으면 작성 페이지로 갈 필요가 없어서 게시글 리스트로 		
			if(btList.size()==0) {
				MessageUtils.alertAndMovePage(response, "작성할 수 있는 게시판이 없습니다.", "/spring", "/board/list");

			}else {
				
				mv.setViewName("/board/update");
			}
		}
		return mv;
	}
	@RequestMapping(value ="/board/update/{bo_num}", method=RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv,
			HttpSession session,
			@PathVariable("bo_num")int bo_num, 
			HttpServletResponse response, // 수정할 게시글 정보
			BoardVO board, MultipartFile[] files, // 추가된 첨부파일
			int[] fileNums) { // 삭제될 첨부파일
		// 세션에 있는 회원 정보 가져옴. 작성자와 아이디 같은지 확인하려고
//		System.out.println(board);
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(boardService.updateBoard(board, files, fileNums, user)) {
			MessageUtils.alertAndMovePage(response, "게시글 수정이 완료되었습니다.", "/spring", "/board/detail/"+bo_num);

		}else {
			MessageUtils.alertAndMovePage(response, "게시글을 수정하지 못하였습니다.", "/spring", "/board/list");
		}
		
		return mv;
	}
}
