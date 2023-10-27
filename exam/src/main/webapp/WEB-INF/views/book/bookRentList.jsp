<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookRentList }" var="rent">
				<tr>
					<td>${rent.rentNo }</td>
					<td>${rent.bookNo }</td>
					<td>${rent.rentPrice }</td>
					<td>${rent.rentStatus }</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>