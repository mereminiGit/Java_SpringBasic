<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
	<div class="sb-sidenav-menu">
		<div class="nav">
			<div class="sb-sidenav-menu-heading">Web</div>
			<a class="nav-link" href="${pageContext.request.contextPath}/empList">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> 조회
			</a> <a class="nav-link"
				href="${pageContext.request.contextPath}/empInsert">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> 등록
			</a> 
			<a class="nav-link"
				href="${pageContext.request.contextPath}/bookInsert">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> 도서등록
			</a>
			<a class="nav-link"
				href="${pageContext.request.contextPath}/bookList">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> 도서목록조회/수정
			</a>
			<a class="nav-link"
				href="${pageContext.request.contextPath}/bookRentList">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> 대여현황조회
			</a> <a class="nav-link"
				href="${pageContext.request.contextPath}/index">
				<div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				</div> 홈으로
			</a>
		</div>
	</div>