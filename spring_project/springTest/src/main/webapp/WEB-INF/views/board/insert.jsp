<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- jsp를 제공해주는 태그-->
<!docType html>
<link href="<c:url value='/resources/css/summernote.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote.min.js'></c:url>"></script>

<div class="main-box">
	<form action="<c:url value='/board/insert'></c:url>" method="post" enctype="multipart/form-data">
		<div class="input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">제목</span>
			</div>
			<input type="text" class="form-control" name="bo_title"/>
		
		</div>
		<div class="input-group">
			<div class="input-group-prepend">
			<span class="input-group-text">카테고리</span>
			</div>
			<select name="bo_bt_num">
				<option value="0">게시판을 선택하세요.</option>
				<c:forEach items="${btList}" var="bt">
				<option class="form-control" value="${bt.bt_num}">${bt.bt_name}</option>
				</c:forEach>
			</select>
		
		</div>
		
		
		
		<textarea name="bo_content"></textarea>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" class="form-control-file border" name="files">
			<input type="file" class="form-control-file border" name="files">
			<input type="file" class="form-control-file border" name="files">
		</div>
		<button class="btn btn-outline-danger col-12 mb-2">게시글 등록</button>
	</form>
	<a class="btn btn-outline-primary" role="button" href="<c:url value='/board/list'></c:url>">목록</a>
</div>
<script>
$('[name=bo_content]').summernote({
    placeholder: '내용을 입력해주세요',
    tabsize: 2,
    height: 400
  });
  
  $('form').submit(function(){
	  if($('[name=bo_title]').val().trim().length==0){
		  $('[name=bo_title]').focus();
		  alert('제목을 입력해주세요');
		  return false;
	  }
	  if($('[name=bo_content]').summernote('code').trim().length==0){
		  $('[name=bo_content]').focus();
		  alert('내용을 입력해주세요');
		  return false;
	  }
	  if($('[name=bo_bt_num]').val()==0){
		  $('[name=bo_bt_num]').focus();
		  alert('게시판을 선택해주세요');
		  return false;
	  }
  })
  
  </script>