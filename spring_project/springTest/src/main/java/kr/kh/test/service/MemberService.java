package kr.kh.test.service;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberService {


	boolean insertSignup(MemberVO memberVO) throws Exception;

	MemberVO login(MemberVO member);

	boolean checkAuth(MemberOKVO mok);
}
