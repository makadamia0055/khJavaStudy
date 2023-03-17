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

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	
	
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mv) throws Exception{
	ModelMap modelMap = mv.getModelMap();
	MemberVO user = (MemberVO)modelMap.get("user");
	
	if(user!=null) {
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		if(user.isAutoLogin()) {
			Cookie testCookie = new Cookie("testCookie", session.getId());
			testCookie.setPath("/");
		
			testCookie.setMaxAge(60*60*24*7);
			res.addCookie(testCookie);
			
			user.setMe_session_id(session.getId());
			Date maxTime = new Date(System.currentTimeMillis() + 60*60*24*7*1000L);
			user.setMe_session_limit(maxTime);
			memberService.updateSessionInfo(user);
			
			}
		}
	}

}
