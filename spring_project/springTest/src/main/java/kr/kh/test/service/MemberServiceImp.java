package kr.kh.test.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.MemberDAO;
import kr.kh.test.vo.MemberVO;

@Service 
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	

	@Override
	public boolean insertSignup(MemberVO memberVO) throws Exception {
		if(memberVO==null) {
			System.out.println("예외처리");
			return false;
		}
		String idRegex ="^[a-zA-Z][a-zA-Z0-9!@#$]{4,12}$";
		String pwRegex =  "^[a-zA-Z0-9!@#$]{8,20}$";
		if(memberVO.getMe_id()==null|| !Pattern.matches(idRegex, memberVO.getMe_id()))
			return false;
			
		if(memberVO.getMe_pw()==null|| !Pattern.matches(pwRegex, memberVO.getMe_pw())) {
			return false;
			
		}
		String pw = passwordEncoder.encode(memberVO.getMe_pw());
		memberVO.setMe_pw(pw);
		System.out.println(memberVO.getMe_pw());
		if(memberVO.getMe_email()==null)
			return false;
		
		if(memberVO.getMe_birthday()==null)
			return false;
		
				
		if(memberDao.insertSignup(memberVO)==0) {
//			적용된 개수를 알려줌.
			return false;
		}
		return true;
		
	}

	@Override
	public MemberVO login(MemberVO member) {
		MemberVO serverMemberVO = memberDao.selectMemberById(member.getMe_id());
		if(serverMemberVO==null) {
			return null;
		}
		if(!passwordEncoder.matches(member.getMe_pw(), serverMemberVO.getMe_pw())) {
			return null;
		}
		return serverMemberVO;
	}
}
