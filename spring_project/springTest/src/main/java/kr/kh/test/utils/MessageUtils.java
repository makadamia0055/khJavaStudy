package kr.kh.test.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class MessageUtils {
	private static void init(HttpServletResponse res) {
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
			
	}
	public static void alertAndMovePage(HttpServletResponse res, String text, String contextPath, String url) {
		init(res);
		PrintWriter out;
		try {
			out = res.getWriter();
			out.println("<script>alert('"+text+"'); location.href='"+contextPath+ url +"' </script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
