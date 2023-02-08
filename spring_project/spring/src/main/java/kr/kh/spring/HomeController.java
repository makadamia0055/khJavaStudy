package kr.kh.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value ="/")
	public ModelAndView home(ModelAndView mv, String name, Integer age) {
//		ModelAndView => 모델과 뷰를 동시에 전달하는 클래스이름
		
		// 서버로 정보를 넘겨받기 : 메소드에 받을 정보를 매개변수의 형태로 선언한다.
		// 매개변수 정보가 없을 경우 null이 전달됨. 그런데 기본형의 경우 null이 
		// 불가능하기 때문에 에러 발생. 
		// get 방식으로 정보를 넘길때는 가능할 떄 Wrapper클래스로 넘길것.
		mv.addObject("name", name);
		mv.addObject("age", age);
		// 첫번째 매개변수 : 화면에서 불릴 이름/ 변수명
		// 두번째 매개변수 : 실제 데이터
		mv.setViewName("home");
		return mv;
	}
	
//	경로를 변수로 받는 방법
	@RequestMapping(value = "/board/{num}")
	public ModelAndView home(ModelAndView mv,@PathVariable("num")Integer num1) {
		System.out.println("게시글 번호 : " + num1);
		mv.setViewName("home");
		return mv;
		
	}

	@RequestMapping(value ="/test")
	public ModelAndView home(ModelAndView mv,InfoVO info) {
//		클래스의 기본 생성자를 호출해서 입력 받음. 만약 기본생성자(매개변수가 없는)가 없다면 에러
		System.out.println(info);
		mv.addObject("info1", info);
		mv.setViewName("home2");
		return mv;
	}
	@RequestMapping(value ="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public ModelAndView login(ModelAndView mv, String id, String pw) {
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		mv.addObject("id", id);
		mv.setViewName("login");
		return mv;
	}
	
	
}
