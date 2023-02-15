<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand/logo -->
	  
	  
	  <!-- Links -->
	  <ul class="navbar-nav">
	  	
	  	<li class="nav-item">
	      <a class="nav-link" href="<c:url value='/main/home'></c:url>"> Home</a>
	    </li>
	    <!-- Links -->
	    <c:if test="${user==null}">
		    <li class="nav-item">
		      <a class="nav-link" href="<c:url value='/signup'></c:url>">회원가입</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<c:url value='/login'></c:url>">로그인</a>
		    </li>
	    </c:if>
	    <c:if test="${user!=null}">
	    	<li class="nav-item">
	      		<a class="nav-link" href="<c:url value='/logout'></c:url>">로그아웃</a>
	    	</li>
	    </c:if>
	    <c:if test="${user!=null }">
	     	<li class="nav-item">
	      		<a class="nav-link" href="/board/list">게시판</a>
	    	</li>
	    </c:if>
	    <li class="nav-item">
	      <a class="nav-link" href="/spring/ex5">ex 5</a>
	    </li>
	  </ul>
	</nav>