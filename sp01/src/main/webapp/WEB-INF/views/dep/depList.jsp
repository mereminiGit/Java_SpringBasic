<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 부서 조회</title>
<style type="text/css">
	table, td, th {
		border: 1px solid navy;
		border-collapse: collapse;
		text-align: center;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='depInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>NO.</th>
				<th>department_id</th>
				<th>department_name</th>
				<th>manager_id</th>
				<th>location_id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${depList }" var="d" varStatus="sts">
				<tr onclick="location.href='depInfo?departmentId=${d.departmentId}'">
					<td>${sts.count }</td>
					<td>${d.departmentId }</td>
					<td>${d.departmentName }</td>
					<td>${d.managerId }</td>
					<td>${d.locationId }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>