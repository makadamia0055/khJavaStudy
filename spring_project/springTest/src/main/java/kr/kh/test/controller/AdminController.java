package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.AdminService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.BoardTypeVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/admin/board/type/list", method = RequestMethod.GET)
	public ModelAndView boardType(ModelAndView mv) {
		ArrayList<BoardTypeVO> btVOList = adminService.selectWholeType();
		mv.addObject("btVOList",btVOList);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}
	@RequestMapping(value="/admin/board/type/insert", method = RequestMethod.POST)
	public ModelAndView boardTypeInsert(ModelAndView mv, BoardTypeVO bTVO, HttpServletResponse res, HttpServletRequest req) {
		if(adminService.insertBoardType(bTVO)) {
			MessageUtils.alertAndMovePage(res, "새 게시판을 추가 했습니다.", req.getContextPath(), "/admin/board/type/list");

		}else {
			MessageUtils.alertAndMovePage(res, "게시판 추가에 실패했습니다.", req.getContextPath(), "/admin/board/type/list");
		}
		
		return mv;
	}
	@RequestMapping(value="/admin/board/type/update", method = RequestMethod.POST)
	public ModelAndView boardTypeEdit(ModelAndView mv, BoardTypeVO bt, HttpServletResponse res, HttpServletRequest req) {
		if(adminService.editBoardType(bt)) {
			MessageUtils.alertAndMovePage(res, "게시판을 수정 했습니다.", req.getContextPath(), "/admin/board/type/list");

		}
		MessageUtils.alertAndMovePage(res, "게시판 수정에 실패했습니다.", req.getContextPath(), "/admin/board/type/list");


		return mv;
	}
	@RequestMapping(value="/admin/board/type/delete", method = RequestMethod.GET)
	public ModelAndView boardTypeDelete(ModelAndView mv, Integer bt_num, HttpServletResponse res, HttpServletRequest req) {
		if(bt_num==null||bt_num<1) {
			MessageUtils.alertAndMovePage(res, "이미 삭제된 게시판 이거나 없는 게시판 입니다.", req.getContextPath(), "/admin/board/type/list");

		}
		if(!adminService.deleteBoardType(bt_num)) {
			MessageUtils.alertAndMovePage(res, "이미 삭제된 게시판 이거나 없는 게시판 입니다.", req.getContextPath(), "/admin/board/type/list");

		}
		MessageUtils.alertAndMovePage(res, "게시판을 삭제했습니다.", req.getContextPath(), "/admin/board/type/list");


		return mv;
	}
}
