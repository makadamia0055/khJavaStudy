package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.MemberOkVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	String selectMemberName(@Param("num")String num);
//	@Param의 이름과 MemberMapper의 쿼리문 속 #{이름}을 맞춰준다. 

	int insertMember(@Param("m")MemberVO member);

	void insertMemberOk(@Param("mok")MemberOkVO mok);

	MemberOkVO selectMemberOK(@Param("mok")MemberOkVO mok);

	void deleteMemberOK(@Param("mok")MemberOkVO mok);

	void updateAuthority(@Param("me_id")String me_id, @Param("me_authority")int i);

	MemberVO selectMemberById(@Param("me_id")String me_id);

	void updateSession(@Param("m")MemberVO user);

	MemberVO selectMemberBySession(@Param("me_session_id")String me_session_id);

	

}
