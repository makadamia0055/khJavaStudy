package kr.kh.test.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		MemberVO user = (MemberVO)req.getSession().getAttribute("user");
		if(user!=null) {
			return true;
		}
		Cookie testCookie = WebUtils.getCookie(req, "testCookie");
		if(testCookie!=null) {
			MemberVO tmpUser= memberService.getUserBySessionId(testCookie.getValue());
			System.out.println(tmpUser);	
			if(tmpUser!=null){
				req.getSession().setAttribute("user", tmpUser);
			}
		}
	
	
	 return true;	
	}

}
