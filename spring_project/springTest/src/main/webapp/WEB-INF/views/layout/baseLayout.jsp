<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!-- tiles로 시작되는 태그는 uri에서 가져오겠다.  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<title>스프링</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'></c:url>">
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'></c:url>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/popper.min.js'></c:url>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/bootstrap.bundle.min.js'></c:url>"></script>
	<style>
		.container #body{
		min-height: calc(100vh - 240px);
		}
	</style>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <div class="container">        
        <tiles:insertAttribute name="body" />
    </div>                                                  
    <tiles:insertAttribute name="footer" />
</body>
</html>
