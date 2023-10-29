<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rentList }" var="rent">
				<tr>
					<td>${rent.bookNo }</td>
 					<td>${rent.bookName }</td>
					<td>${rent.rentTotal }</td>
					<td>${rent.rentCount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>