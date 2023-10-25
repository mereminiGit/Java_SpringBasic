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
		//let temp = ${result }
		
		if(`${result }` != ""){	
			alert(`${result }`);	
		}
		
		// JSP가 가지고 있는 컴파일 순서
		// JSP -> servlet -> java -> 클라이언트(html -> css -> js) 순으로 컴파일 일어남
		// 이 순으로 진행되므로 이엘태그 html, css, js에서 사용할 수 있다.
		// js사용하려면 ``빽팁을 써야한다. 또 빈 이엘태그 사용하면 안 된다.(이 부분은 jsp라서 먼저 읽기 때문에 주석처리가 안 된다.)
	</script>
	<script type="text/javascript">
		console.log(document.querySelector("#sts").innerText);
	</script>
</body>
</html>