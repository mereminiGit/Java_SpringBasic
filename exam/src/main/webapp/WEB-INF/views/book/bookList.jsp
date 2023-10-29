<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList }" var="book">
				<tr>
					<td>${book.bookNo }</td>
					<td>${book.bookName }</td>
					<c:choose>
						<c:when test="${not empty book.bookCoverimg }">						
							<td><img src="<c:url value="/resources/images/${book.bookCoverimg }" />" style="width: 100px"></td>
						</c:when>
						<c:otherwise>
							<td>파일 없음</td>
						</c:otherwise>
					</c:choose>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${book.bookDate }"/></td>
					<td>${book.bookPrice }</td>
					<td>${book.bookPublisher }</td>
					<td>${book.bookInfo }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>