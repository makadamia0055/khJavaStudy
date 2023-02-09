<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<h1>
	예제1  
</h1>

<div class="container-fluid">

	
	<p>화면에서 서버로 데이터를 get 방식으로 전달하는 예제 </p>
	<h2>예제 1-1</h2>
	<a href="/spring/ex1?name=홍길동&age=20">서버로 홍길동 전송</a>
	<h2>예제 1-2</h2>
	<form action="/spring/ex1/" method="get">
		<input type="text" name="name" placeholder="이름을 입력해주세요"><br>
		<input type="text" name="age">
		<button>전송</button>
	</form>
</div>
