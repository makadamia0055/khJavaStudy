package kr.kh.test.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberVO;

public class LoginRedirectInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		MemberVO user = (MemberVO)req.getSession().getAttribute("user");
		if(user==null) 
			return true;
		
		String prevURL = (String)req.getSession().getAttribute("prevURL");
		if(prevURL==null) {
			return true;
		}else {
			
			res.sendRedirect(prevURL);
			req.getSession().removeAttribute("prevURL");
			return false;
			
		}
		
			 
	}
}
