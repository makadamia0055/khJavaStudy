package kr.kh.test.service;

import kr.kh.test.vo.MemberVO;

public interface MemberService {

	String selectMemberName(Integer num);

	boolean insertSignup(MemberVO memberVO) throws Exception;

	MemberVO login(MemberVO member);

}
