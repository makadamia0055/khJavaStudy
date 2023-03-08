<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- jsp를 제공해주는 태그-->
<!docType html>
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>추천수</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${boardList }" var="bo">
			<tr>
				<td>${bo.bo_num }</td>
				<td>
					<a href="<c:url value='/board/detail/${bo.bo_num}'></c:url>">
						${bo.bo_title}
					</a>
				</td>
				<td>${bo.bo_me_id}</td>
				<td>${bo.bo_register_date}</td>
				<td>${bo.bo_up - bo.bo_down}</td>
				<td>${bo.bo_views}</td>
				
		
			</tr>
		</c:forEach>
	</tbody>

</table>


<a class="btn btn-outline-danger" role="button" href="<c:url value='/board/insert'></c:url>">insert Page</a>
<ul class="pagination" style="justify-content: center;">
    <c:if test="${pm.prev}">
    	<li class="page-item">
    		<a class="page-link" href="<c:url value='/board/list?page=${pm.criteria.page -1}'></c:url>">이전</a>
    	</li>
    </c:if>
    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
    	<li class="page-item <c:if test='${ pm.criteria.page == index }'>active</c:if>" >
        	<a class="page-link"
        	 href="<c:url value='/board/list?page=${index}'></c:url>">${index }</a>
       	</li>
    </c:forEach>
    <c:if test="${pm.next}">
    	<li class="page-item">
    		<a class="page-link" href="<c:url value='/board/list?page=${pm.criteria.page + 1}'></c:url>">다음</a>
    	</li>
    </c:if>
</ul>