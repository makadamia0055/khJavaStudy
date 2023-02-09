<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<h1>
	예제2  
</h1>


<p>화면에서 서버로 데이터를 post 방식으로 전달하는 예제 </p>
<h2>예제 2-1</h2>
<h2>예제 2-2</h2>
<div class="container-fluid">
	<form action="/spring/ex1/" method="post">
		<input type="text" name="name" placeholder="이름을 입력해주세요"><br>
		<input type="text" name="age">
		<button>전송</button>
	</form>
	<p>post 방식으로 서버에 데이터를 보내는 경우</p>
	<ol>
		<li>uri에 데이터가 노출되면 안되는 경우 : 로그인, 회원가입</li>
		<li>서버에 보내는 데이터가 많은 경우 : 게시글 작성</li>
		<li>파일을 전송하는 경우</li>
	</ol>
</div>
