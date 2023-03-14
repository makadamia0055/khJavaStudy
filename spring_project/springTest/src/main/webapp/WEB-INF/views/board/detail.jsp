<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>게시글 상세</h1>
	<div class="form-group">
		<label>제목</label>
		<div class="form-control">${board.bo_title }</div>
	</div>
	<div class="form-group">
		<label>게시판</label>
		<div class="form-control">${board.bt_type }</div>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<div class="form-control">${board.bo_me_id }</div>
	</div>
	<div class="form-group">
		<label>작성일</label>
		<div class="form-control">${board.bo_register_date_str }</div>
	</div>
	<c:if test="${board.bo_update_date != null }">
		<div class="form-group">
			<label>수정일</label>
			<div class="form-control">${board.bo_update_date_str }</div>
		</div>
	</c:if>
	<div class="form-group">
		<label>조회수</label>
		<div class="form-control">${board.bo_views }</div>
	</div>
	<div>
		<c:if test="${like == null || like.li_state !=1 }">
			<button class="btn btn-outline-success btn-up" data-state="1">추천(<span class="count">${board.bo_up}</span>)</button>
		</c:if>
		<c:if test="${like != null && like.li_state ==1 }">
			<button class="btn btn-success btn-up" data-state="1">추천(<span class="count">${board.bo_up}</span>)</button>
		</c:if>
		<c:if test="${like == null || like.li_state !=-1 }">
			<button class="btn btn-outline-danger btn-down" data-state="-1">비추천(<span class="count">${board.bo_down}</span>)</button>	
		</c:if>
		<c:if test="${like != null && like.li_state ==-1 }">
			<button class="btn btn-danger btn-down" data-state="-1">비추천(<span class="count">${board.bo_down}</span>)</button>			
		</c:if>
		
		
		
	</div>
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="min-height: 400px">${board.bo_content}</div>
	</div>
	<c:if test="${fileList != null && fileList.size() != 0 }">
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${fileList}" var="file">
				<a class="form-control" href="<c:url value='/file${file.fi_name}'></c:url>" download="${file.fi_ori_name}" >${file.fi_ori_name}</a>
			</c:forEach>
		</div>
	</c:if>
	<a class="btn btn-success" href="<c:url value='/board/list'></c:url>">목록</a>
	<c:if test="${board.bo_me_id == user.me_id }">
		<form action="<c:url value='/board/delete/${board.bo_num}'></c:url>" method="post"><button class="btn btn-danger">삭제</button></form>
		<form action="<c:url value='/board/update/${board.bo_num}'></c:url>" method="get"><button class="btn btn-primary">수정</button></form>
		
	</c:if>
	
	<script>
	$('.btn-up, .btn-down').click(function(e){
		if('${user.me_id}'==''){
			alert('로그인한 회원만 추천/비추천을 할 수 있습니다.');
			return;
		}
		let li_state = $(this).data('state');
		
		
		$.ajax({
	        async:true,
	        type:'GET',
//	        data:${map},
	        url:'<c:url value="/board/like/"></c:url>'+ ${board.bo_num}+'/'+li_state,
	        dataType:"json", // 서버에서 보낸 데이터의 타입. Map로 받을 것이기에 json으로
	        //contentType:"application/json; charset=UTF-8", 서버로 보내는 데이터의 타입
	        success: function(data){
	        	$('.btn-up>.count').text(data.board.bo_up);
	        	$('.btn-down>.count').text(data.board.bo_down);
	        	
	        	if(data.state==1){
	        		alert('추천했습니다.')
	        		$('.btn-up').removeClass('btn-outline-success').addClass('btn-success');
	        		$('.btn-down').addClass('btn-outline-danger').removeClass('btn-danger');
	        	}else if(data.state==-1){
	        		alert('비추천했습니다.')
	        		$('.btn-down').removeClass('btn-outline-danger').addClass('btn-danger');
	        		$('.btn-up').addClass('btn-outline-success').removeClass('btn-success');

	        	}else{
	        		if(li_state==1){
						alert('추천을 취소했습니다.');	        			
	        		}else{
	        			alert('비추천을 취소했습니다.');
	        		}
	        		$('.btn-down').addClass('btn-outline-danger').removeClass('btn-danger');
	        		$('.btn-up').addClass('btn-outline-success').removeClass('btn-success');
	        		
	        	}
	        		
	        }
	        
	    }); 
		
		
	})
	
	</script>