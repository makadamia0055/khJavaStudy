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
	Hello world!  home 2
</h1>
<!-- 필드 이름을 썼을 때 필드를 직접 호출하는 게 아니라 
클래스에 정의된 getter를 호출함. 
xxx.name를 쓰면 xxx.getName()이 호출된다.-->
${info1.name}
</body>
</html>
