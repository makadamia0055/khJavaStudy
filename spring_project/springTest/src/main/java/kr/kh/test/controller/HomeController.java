package kr.kh.test.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Integer num) {
		String name = memberService.selectMemberName(num);
		System.out.println(name);
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
				mv.setViewName("redirect:/");
				System.out.println("회원가입 완료");
				res.setContentType("text/html;charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.print("<script>alert('회원가입을 완료했습니다.')</script>");
				out.close();
			}else {
				mv.setViewName("/member/signup");
				
				System.out.println("회원가입 실패");
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
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		System.out.println(member);
		MemberVO user = memberService.login(member);
		if(user!=null) {
			mv.addObject(user);
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
}
