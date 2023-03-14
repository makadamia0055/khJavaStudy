package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import kr.kh.spring.vo.MemberOkVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberService {


	boolean signup(MemberVO member);

	void emailAuthentication(String me_id, String me_email);

	boolean emailAuthenticationConfirm(MemberOkVO mok);

	MemberVO login(MemberVO member);

	boolean checkId(MemberVO user);
	
	
}
