package kr.kh.test.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
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
				mv.setViewName("redirect:/");
				System.out.println("회원가입 완료");
				res.setContentType("text/html;charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.print("<script>alert('회원가입을 완료했습니다.') location.href='/test/' </script>");
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
		if(user!=null && user.getMe_authority() >0) {
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
		}else if(user!=null){
			System.out.println("인증되지 않은 회원입니다.");
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public ModelAndView loginOut(ModelAndView mv, HttpSession session) {
		session.removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
	@RequestMapping(value="/email/authentication", method = RequestMethod.GET)
	public ModelAndView authentication(ModelAndView mv, HttpServletRequest req) {
		String mo_me_id = req.getParameter("mo_me_id");
		String mo_num = req.getParameter("mo_num");
		MemberOKVO mok = new MemberOKVO(mo_me_id, mo_num);
		if(memberService.checkAuth(mok)) {
			// 인증 성공 메시지
		}else {
			// 인증 실패 메시지
		}
		
		mv.setViewName("redirect:/");
		return mv;
	}

}
