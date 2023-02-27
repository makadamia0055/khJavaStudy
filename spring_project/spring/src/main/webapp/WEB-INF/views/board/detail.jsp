<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<style>
	
</style>
<link href="<c:url value='/resources/css/summernote.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote.min.js'></c:url>"></script>
<div class="container-fluid mt-3">
	<h1>게시글 확인</h1>
		<div class="form-group">
			<label >게시판 : </label>
			<div class="form-control">${board.bt_name }</div>
			
			
			
		</div>
		<div class="form-group">
			<label >제목 : </label>
			<div class="form-control"  name="${board.bo_title }"></div>
		</div>
		<div class="form-group">
			<label>작성자 : </label>
			<div class="form-control"  name="${board.bo_me_id}"></div>
		</div>
		<div class="form-group">
			<label>작성일 : </label>
			<div class="form-control" name="${board.bo_register_date}"></div>
		</div>
		<div class="form-group">
			<label>조회수 : </label>
			<div class="form-control" name="${board.bo_views}"></div>
		</div>
		<c:if test="${board.bt_type =='일반' }">
		<div id="common">
			<div style="min-height : 400px;">${board.bo_content}</div>
			<c:if test="${files.size() !=0}">
			<div class="form-group mt-3">
				<label>첨부파일 : </label>
				<c:forEach items="${files}" var="file">
					<a href="<c:url value='/download${file.fi_name }'></c:url>" download="${file.fi_ori_name}" class="form-control" >${file.fi_ori_name}</a>
				</c:forEach>
			</c:if>	
			</div>
		</div>
		</c:if>
		<div id="image" style="display : none">
			<div class="form-group mt-3">
				<label>첨부파일 : </label>
				<!-- input type="file"의 경우 accept를 입력하면 해당 유형의 파일들만 업로드창에서 보임. -->
				<input type="file" class="form-control" name="files" accept="image/*">
				<input type="file" class="form-control" name="files" accept="image/*">
				<input type="file" class="form-control" name="files" accept="image/*">
			</div>
		</div>
	
	
	
</div>


