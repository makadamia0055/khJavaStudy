package kr.kh.test.service;

import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.MemberDAO;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

@Service 
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	String contextPath = "/test";
	
	

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
		if(authorizeUser(memberVO)) {
			
			return true;
		}else {
			return false;
		}
		
	}
	private boolean authorizeUser(MemberVO member) {
		MemberOKVO memberOKVO = new MemberOKVO();
		memberOKVO.setMo_me_id(member.getMe_id());
		memberOKVO.setMo_num(makeRandomStr(6));
		if(memberDao.insertMemberOKVO(memberOKVO)!=0) {
			String title ="계정 이메일 인증 메일입니다.";
			String href = "http://localhost:8080" + contextPath + "/email/authentication?mo_me_id="+memberOKVO.getMo_me_id()+"&mo_num="+memberOKVO.getMo_num();
			String content = "<a href='"+href+"'>이메일 인증 링크</a>";
			sendAuthMail(title, content, member.getMe_email());
			return true;
		}else {
			return false;
		}
		
		
	}
	private boolean sendAuthMail(String title, String content, String receiver) {
		 String setfrom = "psycat06@gmail.com";         
		   

		    try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		            = new MimeMessageHelper(message, true, "UTF-8");

		        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
		        messageHelper.setTo(receiver);     // 받는사람 이메일
		        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
		        messageHelper.setText(content, true);  // 메일 내용

		        mailSender.send(message);
		        return true;
		    } catch(Exception e){
		        System.out.println(e);
		        return false;
		    }

	}
	public String makeRandomStr(int size) {
		String str = "";
		String pattern = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int min = 0, max = pattern.length()-1;
		while(str.length() < size) {
			int r = (int)(Math.random()*(max-min+1)+min);
			str += pattern.charAt(r);
		}
		return str;
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
	@Override
	public boolean checkAuth(MemberOKVO mok) {
		if(mok==null||mok.getMo_me_id()==null|| mok.getMo_num()==null) {
			return false;
		}
		if(memberDao.checkAndDeleteAuth(mok)==0) {
			return false;
		}
		// 회원 등급 변수
		int updateCount = 1;
//		if(memberDao.updateAuth(updateCount, mok)==0) {
//			return false;
//		}
		return memberDao.updateAuth(updateCount, mok)!=0;
	
	}
	@Override
	public boolean checkIdDuplicate(MemberVO tmpId) {
		if(tmpId==null||tmpId.getMe_id()==null||tmpId.getMe_id().trim().length()==0) {
			System.out.println("객체 유효성 검사 실패");
			return false;
		}
			
		String reg = "^[a-zA-Z][a-zA-Z0-9!@#$]{4,12}$";
		
		if(!tmpId.getMe_id().matches(reg)) {
			System.out.println("정규식 검사 실패");
			return false;
		}
		if(memberDao.selectMemberById(tmpId.getMe_id())==null) {
			System.out.println("아이디 사용 가능");
			return true;
		}else {
			System.out.println("중복 아이디 검출");
			return false;
		}
	}
	@Override
	public void updateSessionInfo(MemberVO user) {
		if(user==null||user.getMe_session_id()==null) {
			return;
		}
		memberDao.updateSessionInfo(user);
	}
	@Override
	public MemberVO getUserBySessionId(String session_id) {
		
		
		return memberDao.getUserBySessionId(session_id);
	}
}
