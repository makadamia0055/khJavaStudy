<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<style>
.file-box{
	width: 100px; height: 200px; 
	border: 1px solid black; font-size : 50px ;
	text-align : center; line-height : 200px ; font-weight : bold;
	border-radius : 5px; 
	float: left ; cursor : pointer;
}
#image>div::after{
	display : block; content: ''; clear: both;
}
#image>div>div{
float : left;
margin-right : 20px;
}
#image [type=file]{
	display:none;
}
#image .btn-times{
	position: absolute; top: 5px; right: 5px; width: 30px; height: 30px; 
	background-color: #fff; border: 1px solid black;
	line-height: 30px; font-size: 25px; 
	border-radius : 5px; text-align: center;
}
</style>

<link href="<c:url value='/resources/css/summernote.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote.min.js'></c:url>"></script>
<div class="container-fluid mt-3">
	<h1>게시글 수정</h1>
	<form action="<c:url value='/board/update/${board.bo_num}'></c:url>" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="type">게시글 타입 : </label>
			<select class="form-control" name="bo_bt_num" id = "type">
				<option value="0">게시판을 선택하세요.</option>
			<c:forEach items="${btList}" var="bt">
				
				<option value="${bt.bt_num}" <c:if test="${board.bo_bt_num == bt.bt_num }">selected</c:if>>${bt.bt_name}</option>
				
			</c:forEach>
			
			</select>
		</div>
		<div class="form-group">
			<label for="title">제목 : </label>
			<input type="text" class="form-control" id="title" name="bo_title" value="${board.bo_title}">
		</div>
		<div id="common" style="display : none">
			<textarea id="contents" name="bo_content" ></textarea>
			<div class="form-group mt-3 files">
				<label>첨부파일 : </label>
				<c:forEach items="${files}" var="file">
					<a href="<c:url value='/download${file.fi_name }'></c:url>" download="${file.fi_ori_name}" class="form-control" >${file.fi_ori_name}
						<i class="btn-times" style="color:red;" data-num="${file.fi_num}">X</i>
					
					</a>
				</c:forEach>
				<!-- input type="file"의 경우 accept를 입력하면 해당 유형의 파일들만 업로드창에서 보임. -->
				<c:forEach begin="1" end="${3 - files.size()}">
					<input type="file" class="form-control" name="files" accept="image/*">
				</c:forEach>
				
			</div>
		</div>
		<div id="image" style="display:none;" >
			<label>이미지 : </label>
			<div class="form-group mt-3">
				<!-- input type="file"의 경우 accept를 입력하면 해당 유형의 파일들만 업로드창에서 보임. -->
				<c:forEach items="${files }" var="file">
					<div style="position:relative;">
						<div class = "file-box" style="display:none; ">+</div>
						<input type="file" class="form-control" name="files" accept="image/*" onchange="readURL(this);">
						<img class="preview" src="<c:url value='/download${file.fi_name}'></c:url>">
						<span class="btn-times" data-num="${file.fi_num}">X</span>
		
					</div>
				</c:forEach>
				<c:forEach begin="1" end="${3 - files.size()}">
					<div>
						<div class = "file-box">+</div>
						<input type="file" class="form-control" name="files" accept="image/*" onchange="readURL(this);">
						<img class="preview">
		
					</div>
				</c:forEach>
				
			
			</div>

		<button class="btn btn-outline-success col-12">게시글 수정</button>
	
	</form>
</div>
<script>
      $('#contents').summernote({
        placeholder: '내용을 입력해주세요',
        tabsize: 2,
        height: 400
      });
      
      $('#type').change(function(){
    	  let val = $(this).val();
          $('#common').hide();
          $('#image').hide();
          if(val==0){
        	  return;
          }
          if(common.indexOf(val)>=0){
        	  $('#common').show();
          }else{
        	  $('#image').show();
          }  
      });
      
      $('form').submit(function(){
    	  let bo_bt_type = $('[name=bo_bt_num]').val();
    	  if(bo_bt_type ==0){
    		  alert("게시판을 선택하세요.");
    		  $('[name=bo_bt_type]').focus();
    		  return false;
    	  }
    	  let bo_title = $('[name=bo_title]').val();
    	  if(bo_title.trim().length ==0){
    		  alert("제목을 입력하세요.");
    		  $('[name=bo_title]').focus();
    		  return false;
    	  }
    	  let bo_content = $('[name=bo_content]').val();
    	  if(bo_content.trim().length ==0 && common.indexOf($('#type').val())>=0){
    		  alert("내용을 입력하세요.");

    		  return false;
    	  }
    	  // 이미지 게시판에서 이미지가 1개 이상 선택이 되어야 전송 되도록 유효성 검사
    	  if(common.indexOf($('#type').val())<0){
    		  let images = image.querySelectorAll('[type=file]');
    		  for(i = 0 ; i< images.length; i++){
    			  if(images[i].files && images[i].files[0]){
    				  
    				  
    			  }
    				  
    		  }
    		  // 기존 이미지 개수
    		  let imgCount = '${files.size()}';
    		  // 삭제될 기존 이미지 개수
    		  let deleteImgCount = image.querySelectorAll('[name=fileNums]').length;
    		  // 기존 이미지가 모두 삭제된 게 아니면
    		  if(imgCount - deleteImgCount != 0){
    			  return true;
    			  
    		  }else{
    		  alert('이미지를 1개 이상 선택하세요.');
    		  return false;
    			  
    		  }
    		  
				// 기존 이미지가 모두 삭제되면    		      	  
    		  
    		  
    	  }
      });
      
      // 게시판 타입이 일반인 게시판들의 기본키를 저장하는 common 배열
     	let common = [];
      // 게시판 타입이 일반인 게시판들의 기본키를 저장하는 작업
     	<c:forEach items = "${btList}" var="bt">
     		<c:if test="${bt.bt_type == '일반'}">common.push('${bt.bt_num}')</c:if>
     	</c:forEach>
     	console.log(common);
	// 현재 수정하려는 게시들의 게시판이 일반이면 일반 게시판이, 이미지면 이미지 게시판이 보이도록 하는 작업
     	if(common.includes('${board.bo_bt_num}'))
     			$('#common').show();
     	else
     		$('#image').show();
     	
	$('#contents').summernote('code', '${board.bo_content}');
	
	$('#common .btn-times').click(function(e){
		e.preventDefault();
		$('.files').append('<input type="file" class="form-control" name="files">');
		$('.files').append('<input type="hidden" name="filesNums" value="'+$(this).data('num')+'">');

		$(this).parent().remove();
		
	})
	
	$('.file-box, .preview').click(function(){
     		$(this).siblings('input').click();
     	});
	
     	function readURL(input){
     		if(!input.files || !input.files[0]){
     			input.nextElementSibling.src = '';
     			input.previousElementSibling.style.display = 'block';

     			return ; 
     		}
     		let reader = new FileReader();
     		reader.onload = function(e){
     			input.previousElementSibling.style.display = 'none';

     			input.nextElementSibling.src = e.target.result;
				input.style.display = 'none';
     		}
     		reader.readAsDataURL(input.files[0]);
     		
     	}
     	
     	$('#image .btn-times').click(function(){
     		$(this).siblings('.preview').attr('src', '');
     		$(this).siblings('.file-box').show();
     		$(this).parent().detach().appendTo('#image>div');
     		// input태그로 삭제할 첨부파일 번호를 전송하기 위한 준비 작업
    		$(this).after('<input type="hidden" name="fileNums" value="'+$(this).data('num')+'">');
     		$(this).remove();

     	})
     	</script>

	    