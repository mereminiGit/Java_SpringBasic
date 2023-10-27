<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>### Board Insert ###</title>
<style type="text/css">
	button{
		margin-top: 15px;
	}
	table, td {
		border: 1px solid black;
	}
	th{
		padding: 5px 15px 5px 15px;
		border: 2px solid #F2F2F2;
		border-right: 1px solid #262626;
		background-color: #262626;
		color: #F2F2F2;
	}
	tr:first-child th{
		border-top: 1px solid #262626;
	}
	tr:last-child th{
		border-bottom: 1px solid #262626;
	}
	input, textarea {
		text-align: left;
	}
</style>
</head>
<body>
<!-- not null 제약조건 필요 -->
	<form action="boardInsert" method="post" name="insertForm" accept-charset="utf-8">	
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='boardList'">목록</button>
	</form>
	<script type="text/javascript">
		/* 'submit', boardInsertHandler() -> 이 코드가 실행하는 시점에 그냠 함수로 본다는 이야기 / 핸들러를 붙는 순간 함수 이름만 적고 밑에 함수 코드 작성 */
		document.querySelector('form').addEventListener('submit', function(e){
			e.preventDefault();
			
			console.log(document.querySelector('input[name=title]'));
			let title = document.querySelector('input[name=title]');
			let writer = document.querySelector('input[name=writer]');

			if(title.value == ''){
				alert('제목이 입력되지 않았습니다.');
				title.focus();
				return;
			}

			if(writer.value == ''){
				alert('작성자가 입력되지 않았습니다.');
				writer.focus();
				return;
			}

			insertForm.submit();
		})
	</script>
</body>
</html>