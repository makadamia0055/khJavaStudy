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
	로그인 페이지 입니다.
</h1>
<div class="islogin"></div>
<!-- <script type="text/javascript">
if(${id}!=null){
	let logon = document.getElementsByClassName('isLogin');
	logon.textContent(`${id}님이 접속중`);
	console.log(1);
}

</script>  -->
<form action="/spring/login/" method="post">
<input type="text" name="id" placeholder="아이디를 입력하세요">
<input type="password" name="pw">
<button>login</button>
</form>


</body>
</html>
