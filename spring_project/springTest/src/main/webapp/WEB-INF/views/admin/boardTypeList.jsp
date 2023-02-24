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
				<th style="display:none;">진짜 번호</th>
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
				<form action="<c:url value='/admin/board/type/update'></c:url>" method="post">
					<td>${status.count}</td>
					<td style="display:none;"> <input type=text id="bt_num" name="bt_num" value = " ${btVO.getBt_num() }"></td>
					<td>
						<select id="bt_type" name="bt_type">
							<option value="일반" <c:if test="${btVO.getBt_type() == '일반'}">selected </c:if>>일반</option>
							<option value="이미지" <c:if test="${btVO.getBt_type() == '이미지'}">selected </c:if>>이미지</option>
						</select>
					</td>
					<td>
						<input type="text" id="bt_name" name="bt_name" placeholder="게시판 명" value="${btVO.getBt_name() }">
					</td>
					<td>
						<select id="bt_r_authority" name="bt_r_authority">
							<option value="0" <c:if test="${btVO.getBt_r_authority() == 0}">selected</c:if>>비회원 이상</option>
							<option value="1" <c:if test="${btVO.getBt_r_authority() == 1}">selected</c:if>>회원 이상</option>
							<option value="9" <c:if test="${btVO.getBt_r_authority() == 9}">selected</c:if>>관리자 이상</option>
						</select>
					</td>
					<td>
						<select id="bt_w_authority" name="bt_w_authority">
							<option value="0" <c:if test="${btVO.getBt_w_authority() == 0}">selected</c:if>>비회원 이상</option>
							<option value="1" <c:if test="${btVO.getBt_w_authority() == 1}">selected</c:if>>회원 이상</option>
							<option value="9" <c:if test="${btVO.getBt_w_authority() == 9}">selected</c:if>>관리자 이상</option>
						</select>
					</td>
					<td>
						<button id="edit_button" class="btn btn-outline-success">수정</button>
						<a href="<c:url value='/admin/board/type/delete?bt_num=${btVO.bt_num }'></c:url>">
							<button id="delete_button" type="button" class="btn btn-outline-danger">삭제</button>
						</a>
					</td>
				</form>
			</tr>
		</c:forEach>
		<tfoot>
			<tr>
				<form action="<c:url value='/admin/board/type/insert'></c:url>" method="post">
					<td></td>
					<td style="display:none;"></td>
					<td>
						<select id="bt_type" name="bt_type">
							<option value="일반">일반</option>
							<option value="이미지">이미지</option>
						</select>
					</td>
					<td>
						<input type="text" id="bt_name" name="bt_name" placeholder="게시판 명">
					</td>
					<td>
						<select id="bt_r_authority" name="bt_r_authority">
							<option value="0">비회원 이상</option>
							<option value="1">회원 이상</option>
							<option value="9">관리자 이상</option>
						</select>
					</td>
					<td>
						<select id="bt_w_authority" name="bt_w_authority">
							<option value="1">회원 이상</option>
							<option value="9">관리자 이상</option>
						</select>
					</td>
					<td>
						<button id="submit_button" class="btn btn-outline-primary">등록</button>
					</td>
				</form>
			</tr>
		</tfoot>
	</tbody>
	
	</table>
	
</div>
