<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  안녕하세요. 제 이름은 ${name}입니다.</P>
<P> 제 나이는 ${age}입니다.</P>
<form action="/spring/" method="post">
<!-- action은 생략을 하거나 contextPath인 spring까지 넣어주거나 -->
	<input type="text" name="name"><br>
	<input type="text" name="age"><br>
	<button>전송</button>
</form>
</body>
</html>
