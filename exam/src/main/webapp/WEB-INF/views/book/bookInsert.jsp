<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서등록</title>
</head>
<body>
	<form action="bookInsert" method="post" name="bookInsertForm">
		<table>
			<tr>
				<th>도서번호</th>
				<td><input type="number" name="bookNo" value="${no }" readonly="readonly"></td>
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
				<td><input type="date" name="bookDate" placeholder="yyyy/MM/dd"></td>
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
		document.querySelector('form[name=bookInsertForm]').addEventListener('submit', function(e) {
			e.preventDefault();
			console.log(e.target);
			
			let bookNo = document.querySelector('input[name=bookNo]');
			let bookName = document.querySelector('input[name=bookName]');

			if (bookNo.value == '') {
				alert('도서코드가 입력되지 않았습니다.');
				bookNo.focus();
				return;
			}
			if (bookName.value == '') {
				alert('도서명이 입력되지 않았습니다.');
				bookName.focus();
				return;
			}

			bookInsertForm.submit();
		})
	</script>
</body>
</html>