package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.service.MemberService;

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
	@RequestMapping(value = "/ex5")
	public ModelAndView ex5(ModelAndView mv, String num) {
		String name = memberService.getNameByNum(num);
		mv.addObject("name", name);
		mv.addObject("num", num);
		mv.setViewName("/main/ex5");
		return mv;
	}
	
	
	
}
