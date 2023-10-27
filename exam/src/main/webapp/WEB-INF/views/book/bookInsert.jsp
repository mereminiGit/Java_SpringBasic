<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서등록</title>
</head>
<body>
	<form action="bookInsert" method="post" name="insertForm"
		accept-charset="utf-8">
		<%-- 		<div>
			<c:forEach items="">
			
			</c:forEach>
		</div> --%>
		<table>
			<tr>
				<th>도서번호</th>
				<td><input type="number" name="bookNo"></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" name="bookName"></td>
			</tr>
			<tr>
				<th>도서표지</th>
				<td><input type="text" name="bookCoverimg"></td>
			</tr>
			<tr>
				<th>출판일자</th>
				<td><input type="date" name="bookDate"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="number" name="bookPrice"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input type="text" name="bookPublisher"></td>
			</tr>
			<tr>
				<th>도서소개</th>
				<td><textarea name="bookInfo"></textarea></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='bookList'">조회</button>
	</form>
	
	<script type="text/javascript">
		document.querySelector('form').addEventListener('submit', function(e) {
			e.preventDefault();

			console.log(document.querySelector('input[name=bookName]'));
			let bookName = document.querySelector('input[name=bookName]');

			if (bookName.value == '') {
				alert('도서명이 입력되지 않았습니다.');
				bookName.focus();
				return;
			}

			insertForm.submit();
		});
	</script>
</body>
</html>