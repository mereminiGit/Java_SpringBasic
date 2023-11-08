<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<sec:csrfMetaTags/>
<!-- ajax를 이용할 경우 -->
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">		
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>
	
	<!-- authorize 이 부분은 누가 볼 수 있다. -->
	<sec:authorize access="isAuthenticated()">	
		<sec:authentication property="principal.username" />
		<form action="logout" method="post">
			<sec:csrfInput/>
			<!-- 폼 태그에서 사용 -->
			<button>로그아웃</button>
		</form>
	</sec:authorize>
</body>
</html>