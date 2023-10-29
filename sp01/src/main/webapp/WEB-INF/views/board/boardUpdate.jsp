<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>### Board Update ###</title>
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
	<form name="updateForm">	
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" name="bno" value="${boardInfo.bno }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${boardInfo.writer }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents }</textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image" value="${boardInfo.image }"></td>
			</tr>
		</table>
		<button type="button">저장</button>
		<button type="button" onclick="location.href = 'boardInfo?bno=${boardInfo.bno }'">취소</button>
	</form>
	<script>
		document.querySelector('form > button:nth-of-type(1)').addEventListener('click', function(e) {
			// form > button:nth-of-type(1)
			console.log(e);

			let info = getBoardInfo();

			fetch('boardUpdate', {
				method: 'post',
				headers: {
					'content-type' : 'application/json'
				},
				body: JSON.stringify(info)
			})
			.then(response => response.json())
			.then(result => {
				console.log(result);
				alert('수정되었습니다.');
			})
			.catch(err => {
				console.log('err', err);
			})
		});

		function getBoardInfo() {
			let formTag = document.getElementsByName('updateForm')[0];

			let formData = new FormData(formTag);
			// 입력과 관련된 태그만 남음

			// 필요없는걸 덜어내는 작업 필요
			let objData = {};

			formData.forEach((value, key) => {
				objData[key] = value;
			}) 

			return objData;
		}
	</script>
</body>
</html>