<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- jsp를 제공해주는 태그-->
<!docType html>
<c:choose>
 <c:when test="${user != null && user.me_authority == 9 }">
 관리자 회원입니다.
 </c:when>
 <c:when test="${user != null && user.me_authority == 1 }">
 일반 회원 ${user.me_id }님 반갑습니다.
 </c:when>
 <c:when test="${user != null && user.me_authority == 0 }">
 미인증된 아이디입니다.
 </c:when>
 <c:otherwise>
 	로그인 해주십시오.
 </c:otherwise>
</c:choose>