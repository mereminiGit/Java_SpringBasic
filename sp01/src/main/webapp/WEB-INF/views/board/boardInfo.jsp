<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>## Board Info ##</title>
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
</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${boardInfo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardInfo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardInfo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="2" style="width: 200px;" readonly>
				${boardInfo.contents }
				</textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<c:choose>
				<c:when test="${not empty boardInfo.image }">					
					<%-- <td><img src="${pageContext.request.contextPath }/resources/image/${boardInfo.image }" style="width: 200px"></td> --%>
					<td><img src="<c:url value="/resources/image/${boardInfo.image }" />" style="width: 200px"></td>
				</c:when>
				<c:otherwise>
					<td>파일 없음</td>
				</c:otherwise>
			</c:choose>
		</tr>		
		<tr>
			<th>작성일자</th>
			<td><fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy/MM/dd"/></td>			
		</tr>
	</table>
	<button type="button" onclick="location.href = 'boardUpdate?bno=${boardInfo.bno }'">수정</button>
	<button type="button" onclick="location.href = 'boardDelete?bno=${boardInfo.bno }'">삭제</button>
<!-- 	<script>
		document.querySelector('button:nth-of-type(2)').addEventListener('click', function(e) {
			console.log(e.target);
		});
	</script> -->
</body>
</html>