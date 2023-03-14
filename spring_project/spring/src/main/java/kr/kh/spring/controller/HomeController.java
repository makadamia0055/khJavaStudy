package kr.kh.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberOkVO;
import kr.kh.spring.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired // 인터페이스의 구현클래스를 호출해서 자동으로 객체를 만들어줌.
	MemberService memberService;
	//단 Service 구현 객체에 @Service 어노테이션이 있어야함.
	
	
	
	@RequestMapping(value= {"/", "/main/home","/home.do"})
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");	  
	    return mv;
	}
	
	@RequestMapping(value = "/ex1")
	public ModelAndView ex1(ModelAndView mv, String name, Integer age) {
		System.out.println("예제 1 화면에서 전달한 이름 : " + name);
		System.out.println("예제 1 화면에서 전달한 나이 : " + age);
		mv.setViewName("/main/ex1");
		return mv;
	}
	
	@RequestMapping(value = "/ex2")
	public ModelAndView ex2(ModelAndView mv, String name, Integer age) {
		System.out.println("예제 2 화면에서 전달한 이름 : " + name);
		System.out.println("예제 2 화면에서 전달한 나이 : " + age);
		mv.setViewName("/main/ex2");
		return mv;
	}
	@RequestMapping(value = "/ex3")
	public ModelAndView ex3(ModelAndView mv) {
		
		mv.setViewName("/main/ex3");
		return mv;
	}
	@RequestMapping(value = "/ex3/{name}/{age}")
	public ModelAndView exNameAge3(ModelAndView mv,
			@PathVariable("name")String name, 
			@PathVariable("age")int age) {
		System.out.println("예제 3 화면에서 전달한 이름 : " + name);
		System.out.println("예제 3 화면에서 전달한 나이 : " + age);
		mv.setViewName("/main/ex3");
		return mv;
	}
	@RequestMapping(value = "/ex4")
	public ModelAndView ex4(ModelAndView mv) {
//		서버에서 화면으로 이름과 나이 전송 예제
//		화면에서 호출할 이름(변수명)과 값을 지정
//		-addObject메소드를 통해서
		mv.addObject("name", "둘리");
		mv.addObject("age", 1000);
		mv.setViewName("/main/ex4");
		return mv;
	}

	@RequestMapping(value ="/signup", method=RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value ="/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
		boolean isSignup = memberService.signup(member);
		
		if(isSignup) {
			memberService.emailAuthentication(member.getMe_id(), member.getMe_email());
			// 아이디가 주어지면 주어진 아이디의 인증번회를 발급하고, 
			// 발급한 이메일 인증번호를 db에 저장하고, 
			//이메일로 인증 번호가 있는 링크를 전송하는 기능
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
		// 해당 url에서 작업이 끝났을 떄 다른 url로 다시 전달하는것.
		// 화면을 전달하는게 아니라. 
		
		return mv;
	}
	@RequestMapping(value ="/email", method=RequestMethod.GET)
	public ModelAndView emain(ModelAndView mv, MemberOkVO mok) {
		if(memberService.emailAuthenticationConfirm(mok)) {
			
		}else {
			
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	@RequestMapping(value ="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("member/login");
		return mv;
	}
	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		MemberVO user = memberService.login(member);
		mv.addObject("user", user);
		if(user!=null) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/login");
		}
		System.out.println(user);
		return mv;
	}
	@RequestMapping(value ="/logout", method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView mv, HttpSession session, HttpServletResponse response) throws IOException {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user !=null) {
			//controller에서 alert창 보내기
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그아웃 되었습니다.'); location.href='/spring/' </script>");
			out.flush();
		}
		// 세션에 있는 회원 정보 삭제. 원래는 HttpRequest 받아서 세션 추출해줘야 되는데, 
		// 그냥 HttpSession으로 호출하면 알아서 매핑해준다고 함
		session.removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
	@ResponseBody 
	@RequestMapping(value ="/check/id", method=RequestMethod.POST)
	public Map<String, Object> boardLike(@RequestBody MemberVO user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.checkId(user);
		map.put("res", res);
		return map;
	}
}
