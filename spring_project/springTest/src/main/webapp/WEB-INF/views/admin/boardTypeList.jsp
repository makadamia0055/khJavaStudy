<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
  

<div class="container-fluid">
	<h1>게시판 설정</h1>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>타입</th>
				<th>게시판 명</th>
				<th>읽기 권한</th>
				<th>쓰기 권한</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="btVO" items="${btVOList }" varStatus="status">
			<tr>
				<form action="" method="get">
					<td>${btVO.getBt_num() }</td>
					<td>
						<c:if test="${btVO.getBt_type() == '일반'}">
							<select id="bt_type">
								<option value="일반" selected>일반</option>
								<option value="이미지">이미지</option>
							</select>
						</c:if>
						<c:if test="${btVO.getBt_type() == '이미지'}">
							<select id="bt_type">
								<option value="일반">일반</option>
								<option value="이미지" selected>이미지</option>
							</select>
						</c:if>
						
					</td>
					<td>
						<input type="text" id="by_name" placeholder="게시판 명" value="${btVO.getBt_name() }">
					</td>
					<td>
						<select id="bt_r_authority">
							<c:choose>
								<c:when test="${btVO.getBt_r_authority() == 0 }">
									<option value="0" selected>비회원 이상</option>
									<option value="1">회원 이상</option>
									<option value="9">관리자 이상</option>
								</c:when>
								<c:when test="${btVO.getBt_r_authority() == 1 }">
									<option value="0" >비회원 이상</option>
									<option value="1" selected>회원 이상</option>
									<option value="9">관리자 이상</option>
								</c:when>
								<c:when test="${btVO.getBt_r_authority() == 9 }">
									<option value="0">비회원 이상</option>
									<option value="1">회원 이상</option>
									<option value="9"  selected>관리자 이상</option>
								</c:when>
							</c:choose>
						</select>
					</td>
					<td>
						<select id="bt_w_authority">
							<c:choose>
								<c:when test="${btVO.getBt_w_authority() == 0 }">
									<option value="0" selected>비회원 이상</option>
									<option value="1">회원 이상</option>
									<option value="9">관리자 이상</option>
								</c:when>
								<c:when test="${btVO.getBt_w_authority() == 1 }">
									<option value="0" >비회원 이상</option>
									<option value="1" selected>회원 이상</option>
									<option value="9">관리자 이상</option>
								</c:when>
								<c:when test="${btVO.getBt_w_authority() == 9 }">
									<option value="0">비회원 이상</option>
									<option value="1">회원 이상</option>
									<option value="9"  selected>관리자 이상</option>
								</c:when>
							</c:choose>
						</select>
					</td>
					<td>
						<button id="edit_button" class="btn btn-outline-success">수정</button>
						<button id="delete_button" class="btn btn-outline-danger">삭제</button>
					</td>
				</form>
			</tr>
		</c:forEach>
		<tr>
			<form action="" method="">
				<td></td>
				<td>
					<select id="bt_type">
						<option value="일반">일반</option>
						<option value="이미지">이미지</option>
					</select>
				</td>
				<td>
					<input type="text" id="by_name" placeholder="게시판 명">
				</td>
				<td>
					<select id="bt_r_authority">
						<option value="0">비회원 이상</option>
						<option value="1">회원 이상</option>
						<option value="9">관리자 이상</option>
					</select>
				</td>
				<td>
					<select id="bt_w_authority">
						<option value="1">회원 이상</option>
						<option value="9">관리자 이상</option>
					</select>
				</td>
				<td>
					<button id="submit_button" class="btn btn-outline-primary">등록</button>
				</td>
			</form>
		</tr>
	</tbody>
	
	</table>
	
</div>
