<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<link href="<c:url value='/resources/css/summernote.min.css'></c:url>" rel="stylesheet">
<script src="<c:url value='/resources/js/summernote.min.js'></c:url>"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

<style>
.swiper {
      width: 100%;
      height: 200px;
    }

    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .swiper-slide2 img {
      display: block;
      width: 100%;
      height: 100%;
      object-fit: cover;
    }	
</style>

<div class="container-fluid mt-3">
	<h1>게시글 확인</h1>
		<div class="form-group">
			<label >게시판 : </label>
			<div class="form-control">${board.bt_name }</div>
			
			
			
		</div>
		<div class="form-group">
			<label >제목 : </label>
			<div class="form-control"  name="board.bo_title">${board.bo_title }</div>
		</div>
		<div class="form-group">
			<label>작성자 : </label>
			<div class="form-control"  name="board.bo_me_id">${board.bo_me_id}</div>
		</div>
		<div class="form-group">
			<label>작성일 : </label>
			<div class="form-control" name="bo_register_date">${board.bo_register_date}</div>
		</div>
		<div class="form-group">
			<label>조회수 : </label>
			<div class="form-control" name="bo_views">${board.bo_views}</div>
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
		<c:if test="${board.bt_type =='이미지' }">
			<div id="image" style="display">
				<div class="form-group mt-3">
					<label>이미지 : </label>
					<!-- input type="file"의 경우 accept를 입력하면 해당 유형의 파일들만 업로드창에서 보임. -->
					
				</div>
			</div>
						 
		</c:if>
		<!-- Swiper -->
		<div class="swiper mySwiper">
			 <div class="swiper-wrapper">
		 		<c:forEach items="${files}" var="file">
				   	<div class="swiper-slide">
						<img src="<c:url value='/download${file.fi_name}'></c:url>" height="200" width="auto">
				    </div>
				</c:forEach>
			 </div>
				<div class="swiper-button-next"></div>
			    <div class="swiper-button-prev"></div>
		 </div>
		<div class="pagination justify-content-center" style="margin:20px 0">
			<c:if test="${likes ==null}">
				<button class="btn btn-success btn-vote  btn-up">추천</button>
				<button class="btn btn-danger btn-vote  btn-down ml-2">비추천</button>
				
			</c:if>
			<c:if test="${likes !=null && likes.li_state ==1 }">
				<button class="btn btn-success btn-vote  btn-up">추천</button>
			</c:if>
			<c:if test="${likes !=null && likes.li_state !=1 }">
				<button class="btn btn-outline-success btn-vote btn-up">추천</button>
			</c:if>
			<c:if test="${likes !=null && likes.li_state ==-1 }">
				<button class="btn btn-danger btn-vote  btn-down ml-2">비추천</button>
			</c:if>
			<c:if test="${likes !=null && likes.li_state !=-1 }">
				<button class="btn btn-outline-danger btn-vote btn-down ml-2">비추천</button>
				
			</c:if>
		</div>
		<c:if test="${user != null && user.me_id == board.bo_me_id }">
			<div>
				<a href="<c:url value='/board/update/${board.bo_num }'></c:url>">
					<button class="btn btn-outline-primary btn-update">수정</button>
				</a>
				<a href="<c:url value='/board/delete/${board.bo_num }'></c:url>">
					<button class="btn btn-outline-primary btn-delete">삭제</button>
				</a>
			</div>
		</c:if>
		<c:if test="${board.bo_num == board.bo_ori_num }">
				<a href="<c:url value='/board/insert?bo_ori_num=${board.bo_num }'></c:url>">
					<button class="btn btn-outline-primary btn-reply">답글</button>
				</a>
		</c:if>
		<div class="comment-list mt-2 border border-dark rounded-sm">
			<div class="comment-row p-3">
				<div class="co_me_id">1</div>
				<div class="co_content">2</div>
				<div class="co_register_date">3</div>
				<button class="btn btn-outline-success btn-reply">답글</button>
				<button class="btn btn-outline-success btn-update">수정</button>
				<button class="btn btn-outline-success btn-delete">삭제</button>
				<div class="input-group mb-3 mt-3 reply-box">
					<textarea name="co_content" class="form-control" placeholder="답글을 입력하세요."></textarea>
					<div class="input-group-append">
					<button class="btn btn-success btn-reply-insert" type="submit">답글 등록</button>
				</div>
				
				<hr>
			</div>
		</div>
		<ul class="comment-pagination mt-2 pagination justify-content-center">
			  <li class="page-item" data-page=""><a class="page-link" href="#">이전</a></li>
			  <li class="page-item" data-page="1"><a class="page-link" href="#">1</a></li>
			  <li class="page-item" data-page=""><a class="page-link" href="#">다음</a></li>
		</ul>
		<div class="comment-box mt-2">
			<div class="input-group mb-3">
				<textarea name="co_content" class="form-control" placeholder="댓글을 입력하세요."></textarea>
			<div class="input-group-append">
				<button class="btn btn-success btn-comment-insert" type="submit">댓글 등록</button>
			</div>
		</div>
	
</div>
<script>
	$(function(){
		$('.btn-vote').click(function(){
			if('${user}'== '' ){
				let res = confirm('로그인한 회원만 추천을 할 수 있습니다.\n로그인 페이지로 이동하겠습니까?');
				if(res){
					location.href="<c:url value='/login'></c:url>"
				}
				
			}
			let li_state = 1;
			if($(this).hasClass('btn-down'))
				li_state = -1;
			// ajax를 이용하여 추천/비추천 작업
		  $.ajax({
			  //async: 비동기화
			  // 동기화는 ajax 작업이 다 끝난 후 아래 코드가 실행
			  // 비동기는 ajax 작업이 끝나든 말든 아래 코드가 실행
		        async:true,
		        type:'GET',
		        //data:JSON.stringify(),
		        url:"<c:url value='/board/like/"+li_state+"/${board.bo_num}'></c:url>",
		        // 서버에서 받는 데이터 타입
		        dataType:"json",
		        // 서버에서 보내는 데이터 타입
		        contentType:"application/json; charset=UTF-8",
		        // 성공적으로 실행되었을때의 콜백함수
		        success : function(data){
		            $('.btn-up').removeClass('btn-success').addClass('btn-outline-success');
		            $('.btn-down').removeClass('btn-danger').addClass('btn-outline-danger');
		            if(data.res == 1){
		            	alert('추천을 했습니다.');
		            	$('.btn-up').addClass('btn-success').removeClass('btn-outline-success');
		            }else if(data.res== -1){
		            	alert('비추천을 했습니다.');
			            $('.btn-down').addClass('btn-danger').removeClass('btn-outline-danger');

		            }else{
		            	if(li_state ==1){
		            		alert('추천을 취소했습니다.');
		            	}else{
		            		alert('비추천을 취소했습니다.');
		            	}
		            }
		            	
		        }
		    });
		});
		
	})

</script>

 <script>
    var swiper = new Swiper(".mySwiper", {
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
        
      },
      loop: true,
    });
  </script>
  <script>
  $('.btn-comment-insert').click(function(){
	  //로그인 여부 체크
	  if('${user.me_id}'==''){
		  alert('로그인 하세요.');
		  return;
	  }
	  // ajax를 이용하여 댓글 등록
	  // 댓글 정보를 가진 객체를 생성
	  let co_content = $('[name=co_content]').val();
	  if(co_content.trim().length==0){
		  alert('댓글 내용을 입력하세요.');
		  return;
	  }
	  let comment = {
			co_content : co_content,
	  		co_bo_num: bo_num
	  }
	  insertComment(comment);
	 
  })
  function ajax(method, obj, url, successFunc, errorFunc){
	  $.ajax({
	        async:false,
	        type:method,
	        data:JSON.stringify(obj),
	        url: url, 
	        dataType:"json",
	        contentType:"application/json; charset=UTF-8",
	        success : successFunc,
	        error: errorFunc
	    });
  };
  // 댓글 객체가 주어지면 댓글을 등록하는 함수
  function insertComment(comment){
	  ajax('POST', comment, "<c:url value='/comment/insert'></c:url>", 
	  function(data){
		  if(data.result){
			  alert('댓글을 등록 했습니다.');
			  selectCommentList(1, bo_num);
		  }else{
			  alert('댓글 등록에 실패했습니다.');
		  }
	  })
  }
  // 댓글 페이지 네이션을 클릭하면
  $(document).on('click', '.comment-pagination a', (function(e){
	  e.preventDefault();
	  page = $(this).parent().data('page');
	  selectCommentList(page, bo_num);
  }))
  
  $(document).on('click', '.comment-list .btn-delete', function(){
  		// 댓글 번호 확인
  		let co_num = $(this).data('num');

  		let comment = {
  				co_num : co_num
  		}
  		// deleteComment 호출
	  	deleteComment(comment, page); // 이때 page는 전역변수 page
  })
  $(document).on('click', '.comment-list .btn-reply', function(){
	  let str ='';
	  str += 
		  '<div class="input-group mb-3 mt-3 reply-box">'+
		'<textarea name="co_content" class="form-control" placeholder="답글을 입력하세요."></textarea>'+
		'<div class="input-group-append">'+
		'<button class="btn btn-success btn-reply-insert" type="submit" data-num="'+co_ori_num+'">답글 등록</button>'+
	'</div>';
	$('.reply-box').remove();
	$(this).siblings('hr').before(str);
	$('.comment-row button').show();
	$(this).hide().siblings('button').hide();
	
		
  })
  $(document).on('click', '.btn-reply-insert', function(){
	let co_ori_num = $(this).data('num');
	let co_content =$('[name=co_content_reply]').val();
	let comment = {
		co_content: co_content,
		co_ori_num : co_ori_num, 
		co_bo_num : bo_num
	}
	console.log(comment);
  })
  const bo_num = '${board.bo_num}';
  let page = 1;
 selectCommentList(1, bo_num);
  
  function deleteComment(comment, page){
	  ajax('POST', comment, "<c:url value='/comment/insert'></c:url>", 
			  function(data){
		  		console.log(data)
				  if(data.result){
					  alert('댓글을 삭제 했습니다.');
					  selectCommentList(1, bo_num);
				  }else{
					  alert('댓글 삭제에 실패했습니다.');
				  }
			  })
  }
  
  function selectCommentList(page, bo_num){
	  //현제 페이지 정보
	  let cri ={
			  page: page 
	  }
	  ajax('POST', cri, '<c:url value="/comment/list/' +bo_num+'"></c:url>',
		  function(data){
		  	let str ='';
		  	let list = data.list;
		  	for(i=0; i<list.length; i++){
		  		let pl = 0;
		  	if(list[i].co_num != list[i].co_ori_num){
		  		pl = 30;
		  	}	
		  	str += '<div class="comment-row p-3">'+
		  	'<div style="padding-left : '+pl+'px">'+
			'<div class="co_me_id">'+list[i].co_me_id +'</div>'+
			'<div class="co_content">'+list[i].co_content +'</div>'+
			'<div class="co_register_date">'+list[i].co_register_date +'</div>'+
			'<button class="btn btn-outline-success btn-reply" data-num="'+list[i].co_ori_num+'">답글</button>';
			if('${user.me_id}'== list[i].co_me_id){
			str +=
				'<button class="btn btn-outline-success btn-update ml-2" data-num="'+list[i].co_num+'">수정</button>'+
				'<button class="btn btn-outline-success btn-delete ml-2" data-num="'+list[i].co_num+'">삭제</button>';	
			}
			str +=
			'</div>'+
			'<hr>'+
			'</div>'
		  	}
			$('.comment-list').html(str);
			str ='';
			let pm = data.pm;
			if(pm.prev)
				str+=
			  '<li class="page-item" data-page="'+(pm.startPage-1)+'"><a class="page-link" href="#">이전</a></li>'
		  for(i = pm.startPage; i<=pm.endPage; i++){
				let active = i == pm.cri.page ? 'active' : '';
			  str+=
			  '<li class="page-item '+active+' "data-page="'+i+'"><a class="page-link" href="#">'+i+'</a></li>'
		  }
		  if(pm.next)
			  str+=
			  '<li class="page-item" data-page="'+(pm.endPage+1)+'"><a class="page-link" href="#">다음</a></li>'
			  
			  $('.comment-pagination').html(str);
		});
  }
  </script>