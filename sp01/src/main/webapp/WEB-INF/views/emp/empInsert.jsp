<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form div{
		width: 350px;
		height: 30px;
	}
	form input{
		float: right;
	}
	form div:last-child {
		clear: both;
	}
</style>
</head>
<body>
	<form action="empInsert" method="post">
		<div>
			<label>first_name : <input type="text" name="firstName"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"></label>
		</div>
		<div>
			<label>email : <input type="text" name="email"></label>
		</div>
		<div>
			<label>hire_date : <input type="date" name="hireDate" placeholder="yyyy/MM/dd"></label>
		</div>
		<div>
			<label>job_id : <input type="text" name="jobId"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"></label>
		</div>
		<div>
			<button type="submit">저장</button>
			<button type="button" onclick="location.href='empList'">목록</button>
		</div>
	</form>
</body>
</html>