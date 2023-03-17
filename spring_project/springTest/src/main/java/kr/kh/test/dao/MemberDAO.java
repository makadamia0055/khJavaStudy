package kr.kh.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberDAO {

	int insertSignup(@Param("m")MemberVO memberVO);

	MemberVO selectMemberById(@Param("me_id")String me_id);

	int insertMemberOKVO(@Param("memberOK")MemberOKVO memberOKVO);

	int checkAndDeleteAuth(@Param("mok")MemberOKVO mok);

	int updateAuth(@Param("num")int member_Auth, @Param("mok")MemberOKVO mok);
//	DAO 메소드에 매개변수가 2개 이상이면 무조건 @Param 써줘야함.

	void updateSessionInfo(@Param("m")MemberVO user);

	MemberVO getUserBySessionId(@Param("me_session_id")String session_id);

}
