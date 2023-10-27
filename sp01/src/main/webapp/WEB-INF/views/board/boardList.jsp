<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>## Board List ##</title>
<style type="text/css">
	button{
		margin-bottom: 15px;
	}
	table, td {
		border: 1px solid black;
	}
	thead th{
		padding: 5px 15px 5px 15px;
		border: 2px solid #F2F2F2;
		border-bottom: 2px solid #262626;
		background-color: #262626;
		color: #F2F2F2;
	}
	thead th:first-child {
		border-left: 1px solid #262626;
	}
	thead th:last-child {
		border-right: 1px solid #262626;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href = 'boardInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="board">			
				<tr onclick="location.href = 'boardInfo?bno=${board.bno }'">
					<td>${board.bno }</td>
					<td>${board.title }</td>
					<td>${board.writer }</td>				
					<td><fmt:formatDate pattern="yyyy년MM월dd일" value="${board.regdate }"/></td>
					<!-- fmt는 포멧과 관련된 것들을 설정할 때 사용하는 라이브러리 -->
					<!-- 날짜만 포멧 정하는게 아니라, 숫자 문자에 대해서도 처리 가능 -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		if (`${result }` != ''){
			alert(`${result }`);
		}
	</script>
</body>
</html>