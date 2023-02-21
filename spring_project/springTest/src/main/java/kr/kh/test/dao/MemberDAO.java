package kr.kh.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberDAO {

	int insertSignup(@Param("m")MemberVO memberVO);

	MemberVO selectMemberById(@Param("me_id")String me_id);

	int insertMemberOKVO(@Param("memberOK")MemberOKVO memberOKVO);

}
