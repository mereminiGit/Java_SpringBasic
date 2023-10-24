<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 날짜 숫자 등 포멧과 관련된 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
<style type="text/css">
	table, td, th {
		border: 1px solid navy;
		border-collapse: collapse;
		text-align: center;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>				
				<th>NO.</th>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty empList }">
					<tr><td>NOTHING</td></tr>
				</c:when>
				
				<c:otherwise>			
					<c:forEach items="${empList }" var="e" varStatus="sts">			
						<tr onclick="location.href = 'empInfo?employeeId=${e.employeeId}'">
							<td style="display:none;" id="sts">${sts }</td>
							<td>${sts.count }</td>
							<td>${e.employeeId }</td>
							<td>${e.firstName }</td>
							<td>${e.lastName }</td>
							<td>${e.email }</td>
							<td>
								<fmt:formatDate value="${e.hireDate }" pattern="yyyy년MM월dd일"/>
							</td>
							<td>${e.jobId }</td>
							<!-- 직접 접근할 때 사용하는 방식 -->
							<td>${empList[sts.index].salary }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<script type="text/javascript">
		console.log(document.querySelector("#sts").innerText);
	</script>
</body>
</html>