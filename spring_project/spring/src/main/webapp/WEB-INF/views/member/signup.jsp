<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<style>
	.error{
	color: red;
	}
</style>
  <link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.min.css'></c:url>">

<div class="container-fluid">
	<h1>회원가입</h1>
	<form action="<c:url value='/signup'></c:url>" method="post">
		<div class="form-group">
			<label for="id">아이디 : </label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<button type="button" class="btn btn-outline-success btn-check-id col-12">아이디 중복체크</button>
		
		<div class="form-group">
			<label for="pw">비밀번호 : </label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-group">
			<label for="pw2">비번확인 : </label>
			<input type="password" class="form-control" id="pw2" name="me_pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일 : </label>
			<input type="text" class="form-control" id="email" name="me_email">
		</div>
		<div class="form-group">
			<label for="birthday">생년월일 : </label>
			<input type="text" class="form-control" id="birthday" name="me_birthday">
		</div>
			<button class="btn btn-outline-success col-12">회원가입 신청</button>
	
	</form>
</div>

<script src="<c:url value='/resources/js/jquery.validate.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/additional-methods.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/jquery-ui.min.js'></c:url>"></script>

<script>
	$('form').validate({
		rules : {
			me_id : {
				required : true,
				regex : /^[a-zA-Z][a-zA-Z0-9!@#$]{4,12}$/
			},
			me_pw : {
				required : true,
				regex : /^[a-zA-Z0-9!@#$]{8,20}$/
			},
			me_pw2 : {
				equalTo : pw // 해당 요소의 id
			},
			me_email : {
				required : true,
				email: true
			},
			me_birthday : {
				required : true,
				date: true // /^\d{4}-(0\d|10|11|12)-(0\d|1\d|2\d|30|31)$/
			}
		},
		messages: {
			me_id : {
				required : '필수항목입니다.',
				regex : '아이디는 영문자로 시작하며, 영문, 숫자 !@#$를 이용하여 5~13자까지 가능합니다.'
			},
			me_pw : {
				required : '필수항목입니다.',
					regex : '비밀번호는 영문, 숫자 !@#$를 이용하여 8~20자까지 가능합니다.'
			},
			me_pw2 : {
				equalTo : '비밀번호와 일치하지 않습니다.'
			},
			me_email : {
				required : '필수항목입니다',
				email: '이메일 형식이 아닙니다.'
			},
			me_birthday : {
				required : '필수항목입니다.',
				date: '날짜 형식이 아닙니다.'
			}
		},
		
		submitHandler: function(form) {
			if(!idCheck){
				alert('아이디 중복 체크를 하세요.');
				return false;
			}
			return true;
		
			
			}
		});
	$.validator.addMethod(
		    "regex",
		    function(value, element, regexp) {
		        var re = new RegExp(regexp);
		        return this.optional(element) || re.test(value);
		    },
		    "Please check your input."
		);
	
	$( function() {
	    $( "#birthday" ).datepicker({
	    	dateFormat: 'yy-mm-dd'
	    	
	    });
	    
	  });
	$('.btn-check-id').click(function(){
		let me_id = $('[name=me_id]').val();
		let obj = {
				me_id : me_id
		}
		console.log(obj);
		$.ajax({
	        async:true,
	        type:'POST',
	        data:JSON.stringify(obj),
	        url: "<c:url value='/check/id'></c:url>", 
	        dataType:"json",
	        contentType:"application/json; charset=UTF-8",
	        success : function(data){
	            if(data.res){
	            	alert('사용 가능한 아이디입니다.');
	            	idCheck=true;
	            }else{
	            	alert('이미 사용 중인 아이디 입니다.');
	            }
	        }
	    });
	})
	$('[name=me_id]').change(function(){
		idCheck=false;
	});
let idCheck = false;
	
</script>