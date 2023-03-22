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
	<!-- 댓글 창 -->
	<div class="input-group mt-3 mb-3">
	  <textarea class="form-control co_content" placeholder="댓글을 입력해주세요." name="co_content"></textarea>
	  <div class="input-group-append">
	    <button class="btn btn-success btn-comment-insert" type="button">댓글등록</button>
	  </div>
	</div>
	<!-- 댓글 조회 창 -->
	<div class="comment-list">
		
	</div>
	<!-- 댓글 페이지 네이션 -->
	<ul class="pagination comment-pagination justify-content-center">
	
	</ul>
	<hr>
	<!-- 댓글 조회 코드 -->
	<script>
	const bo_num = '${bo_num}';

	let cri = {
			page:1,
			perPageNum: 5
			
	}
	commentSelect();
	function commentSelect(){
		
		$.ajax({
			async: true,
			type: 'POST',
			data: JSON.stringify(cri),
			url: "<c:url value='/comment/list/"+bo_num+"'></c:url>",
			dataType: "JSON",
			contentType:"application/json; charset=UTF-8",
			success : listSuccess
		})
	}
	
	function listSuccess(data){
		addCommentList(data.list);
		addPagination(data.pm);
	}
	function addCommentList(list){
		str = '';
		for(i = 0 ; i<list.length; i++){
			str += createComment(list[i]);
		}
		$('.comment-list').html(str);
		$('.comment-list .btn-update').on('click', function(){
			if(${user== null}){
				if(confirm("로그인된 회원만 사용할 수 있는 기능입니다. 로그인 페이지로 이동하시겠습니까?")){
					location.href='<c:url value="/login"></c:url>';
					return;
				}else{
					return;
				}	
			}
			$('.comment').show();
			$('.comment-list .btn').show();
			$('.reply-group, .update-group').remove();
			let content = $(this).parent().siblings('.comment-content').text();
			let co_num = $(this).data('num');
			str = createUpdateComment(content, co_num);
			$(this).parents('.comment').after(str);
			$(this).parents('.comment').hide();
			$('.btn-update-insert').click(clickUpdateButton)
		});
		$('.comment-list .btn-delete').on('click', function(){
			
			if(${user== null}){
				if(confirm("로그인된 회원만 사용할 수 있는 기능입니다. 로그인 페이지로 이동하시겠습니까?")){
					location.href='<c:url value="/login"></c:url>';
					return;
				}else{
					return;
				}
				
			}
		
			if(!confirm("정말 삭제하시겠습니까?")){
				return;
			}
			let num = $(this).data('num');
			let deleteObj = {
					co_bo_num : bo_num, 
					co_num : num
			}
			ajaxPost(deleteObj, '<c:url value="/comment/delete"></c:url>', deleteSucess)
		})
		$('.comment-list .btn-reply').on('click', function(){
			let dataNum = $(this).data('num');
			$('.btn').filter(function(){return $(this).data('num')==dataNum}).hide();
			$('.btn').filter(function(){return $(this).data('num')!=dataNum}).show();
			var str2 = createReplyComment();
			$('.reply-group').remove();
			$(this).parent().after(str2);
			$('.btn-reply-insert').on('click', function(e){
				let reply_content = $('.reply-group textarea').val();
				let replyObj = {
					co_content: reply_content,
					co_bo_num : bo_num
				}
				e.preventDefault();
				$.ajax({
			async: true,
			type: 'POST',
			data: JSON.stringify(replyObj),
			url: "<c:url value='/comment/reply/"+bo_num+"/"+dataNum+"'></c:url>",
			dataType: "JSON",
			contentType:"application/json; charset=UTF-8",
			success : insertComment
		})
				
			})
		})
	}
	function clickUpdateButton(){
		if(${user== null}){
			if(confirm("로그인된 회원만 사용할 수 있는 기능입니다. <br>로그인 페이지로 이동하시겠습니까?")){
				location.href='<c:url value="/login"></c:url>';
				return;
			}else{
				return;
			}
		}
		let co_content = $(this).parent().siblings('[name=co_content]').val();
		if(co_content.trim().length==0){
			alert('댓글을 입력해주세요');
			return;
		}
		let co_num = $(this).data('num');
		let updateObj = {
				co_content: co_content,
				co_bo_num : bo_num, 
				co_num : co_num
		}
		ajaxPost(updateObj, "<c:url value='/comment/update'></c:url>", updateSuccess);

	}
	function updateSuccess(data){
		if(data.res){
			alert('댓글이 수정되었습니다.');
			$('.update-group').remove();
			choosePage(1);

		}else{
			alert('댓글 수정이 실패하였습니다.');
		}
	}
	function createUpdateComment(content, co_num){
		str = '';
		str += '<div class="input-group update-group mt-3 mb-3">'+
		  '<textarea class="form-control co_content" placeholder="댓글을 입력해주세요." name="co_content">'+content+
		  '</textarea>'+
		  '<div class="input-group-append">'+
		   ' <button class="btn btn-success btn-update-insert" type="button" data-num="'+co_num+'" >댓글수정</button>'+
		  '</div>'+
		'</div>';
		return str;
	}
	function createReplyComment(){
		str = '';
		str += '<div class="input-group reply-group mt-3 mb-3">'+
		  '<textarea class="form-control co_content" placeholder="댓글을 입력해주세요." name="co_content"></textarea>'+
		  '<div class="input-group-append">'+
		   ' <button class="btn btn-success btn-reply-insert" type="button">댓글등록</button>'+
		  '</div>'+
		'</div>';
		return str;

		}
	function createComment(comment){
	str = '';
	let ml = comment.co_ori_num != comment.co_num ? 'ml-3': '';
	str += '<div class="comment '+ml+'">'+
		'<div class="comment-id">'+comment.co_me_id+'</div>'+
		'<div class="comment-date">'
		if(comment.co_update_date_str ==''){
		str+= comment.co_register_date_str
		}else{
		str+= comment.co_update_date_str	
		}
		
	str+=
		'</div>'+
		'<div class="comment-content">'+comment.co_content+'</div>'+
		'<div class="btn-group">'+
			'<button type="button" class="btn btn-outline-success btn-reply" data-num="'+comment.co_num+'">답글</button>';
		if(comment.co_me_id=='${user.me_id}'){
			str+=
		
			'<button type="button" class="btn btn-outline-success btn-update" data-num="'+comment.co_num+'">수정</button>'+
			'<button type="button" class="btn btn-outline-success btn-delete" data-num="'+comment.co_num+'">삭제</button>';
		}
		str+=
		'</div>'+
	'</div>';
		return str;
	}
	function addPagination(pm){
		let prev = pm.prev ? '' : 'disabled';
		let next = pm.next ? '' : 'disabled';
				
		str = '';
		str += '<li class="page-item '+ prev +'">'+
  		'<a class="page-link" href="#" data-page="'+(pm.startPage - 1)+'">이전</a>'+
		'</li>';
		for(i=pm.startPage; i<=pm.endPage; i++){
		let page = pm.cri.page == i ? 'active':'';
			str+=			
  		'<li class="page-item '+ page +'">'+
  			'<a class="page-link" href="#" data-page="'+i+'">'+i+'</a>'+
		'</li>';
		}
		str+=
  	'<li class="page-item '+ next +'">'+
  		'<a class="page-link" href="#" data-page="'+(pm.endPage + 1)+'">다음</a>'+
		'</li>';
		$('.comment-pagination').html(str);
		$('.comment-pagination .page-link').on('click', movePage)
		
		
	}
	// 페이지 네이션 이벤트 등록
	$('.comment-pagination .page-link').click(movePage)
	function movePage(){
		e.preventDefault();
		let page = $(this).data('page');
		cri.page = page;
		commentSelect();
	}
	function choosePage(page){
		cri.page = page;
		commentSelect();
	}
	
	
	</script>
	
	
	
	<!-- 추천 비추천 스크립트 -->
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
	        url:'<c:url value="/board/like/"></c:url>'+ bo_num+'/'+li_state,
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
	<!-- 댓글 등록 버튼 클릭 이벤트 -->
	<script>
	
	$('.btn-comment-insert').click(function(){
		checkLogin("로그인한 회원만 댓글 입력이 가능합니다.");
		let co_content = $(this).parent().siblings('[name=co_content]').val();
		if(co_content.trim().length==0){
			alert('댓글을 입력해주세요');
			return;
		}
		let commentObj = {
				co_content: co_content,
				co_bo_num : bo_num
		}
		ajaxPost(commentObj, "<c:url value='/comment/insert'></c:url>", insertSuccess);
	});
	
	function insertComment(data){
		if(data.res){
			alert('댓글이 등록되었습니다.');
			$('[name=co_content]').val('');
			choosePage(cri.page);
		}
	}
	function deleteSucess(data){
		if(data.res){
			alert('댓글이 삭제되었습니다.');
			choosePage(cri.page);

		}else{
			alert('댓글 삭제가 실패하였습니다.');
		}
		
	}
	function insertSuccess(data){
		if(data.res){
			alert('댓글이 등록되었습니다.');
			$('[name=co_content]').val('');
			choosePage(1);

		}else{
			alert('댓글 등록이 실패하였습니다.');
		}
		
	}
	function checkLogin(msg){
		if(${user== null}){
			if(confirm("로그인된 회원만 사용할 수 있는 기능입니다. \n로그인 페이지로 이동하시겠습니까?")){
				location.href='<c:url value="/login"></c:url>';
				return false;
			}else{
				alert(msg)
				return true;
			}
		}
	}
	function ajaxPost(obj, url, successFunction){
		$.ajax({
			async:false,
			type: 'POST',
			data: JSON.stringify(obj),
			url: url,
			dataType: "JSON",
			contentType:"application/json; charset=UTF-8",
			success : successFunction
			
			
		})
	}
				
					
					
	</script>
	