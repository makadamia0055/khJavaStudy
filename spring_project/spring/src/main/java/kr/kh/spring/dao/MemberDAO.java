package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {

	String selectMemberName(@Param("num")String num);
//	@Param의 이름과 MemberMapper의 쿼리문 속 #{이름}을 맞춰준다. 

}
