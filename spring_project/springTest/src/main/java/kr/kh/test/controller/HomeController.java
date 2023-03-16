package kr.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	String contextPath = "/test";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/main/home");
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO memberVO, HttpServletResponse res) {
		
		try {
			if(memberService.insertSignup(memberVO)) {
				MessageUtils.alertAndMovePage(res, "회원가입에 성공했습니다.", contextPath, "/");
				mv.setViewName("redirect:/");
				
			}else {
				MessageUtils.alertAndMovePage(res, "회원가입에 실패했습니다.", contextPath, "/signup");
				mv.setViewName("/member/signup");
			}
			return mv;
		} catch (Exception e) {
			mv.setViewName("/member/signup");
			System.out.println("회원가입실패(예외 발생)");
			e.printStackTrace();
			return mv;
		}
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member, HttpServletResponse res, 
			HttpServletRequest req) {
		System.out.println(member);
		MemberVO user = memberService.login(member);
		if(user!=null && user.getMe_authority() >0) {
			mv.addObject("user", user);
			
			MessageUtils.alertAndMovePage(res, "로그인 완료", req.getContextPath(), "/");
			
			mv.setViewName("redirect:/");
		}else if(user!=null){
			MessageUtils.alertAndMovePage(res, "이메일 인증이 완료되어야 로그인이 가능합니다.", req.getContextPath(), "/");
			mv.setViewName("redirect:/");
		}else {
			MessageUtils.alertAndMovePage(res, "로그인에 실패했습니다.", req.getContextPath(), "/login");
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public ModelAndView loginOut(ModelAndView mv, HttpSession session, HttpServletResponse res) {
		session.removeAttribute("user");
		MessageUtils.alertAndMovePage(res, "로그아웃이 완료되었습니다.", contextPath, "/");
		mv.setViewName("redirect:/");
		return mv;
	}
	@RequestMapping(value="/email/authentication", method = RequestMethod.GET)
	public ModelAndView authentication(ModelAndView mv, HttpServletRequest req, HttpServletResponse res) {
		String mo_me_id = req.getParameter("mo_me_id");
		String mo_num = req.getParameter("mo_num");
		MemberOKVO mok = new MemberOKVO(mo_me_id, mo_num);
		if(memberService.checkAuth(mok)) {
			MessageUtils.alertAndMovePage(res, "이메일 인증에 성공했습니다.", contextPath, "/");
			mv.setViewName("redirect:/");
			
		}else {
			MessageUtils.alertAndMovePage(res, "이메일 인증에 실패했습니다.", contextPath, "/");
			mv.setViewName("redirect:/");

		}
		
		mv.setViewName("redirect:/");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/check/id", method = RequestMethod.POST)
	public Map<String, Object> joinIdCheck(MemberVO tmpId) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.checkIdDuplicate(tmpId);
		map.put("isChecked", res);
		return map;
	}

}
