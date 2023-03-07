<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script>
let msg = '${msg}';
let url = '<c:url value="${url}"></c:url>'
alert(msg);
location.href = url;
</script>