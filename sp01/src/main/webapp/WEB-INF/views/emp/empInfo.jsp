<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
		text-align: center;
	}
</style>
</head>
<body>
	<form>
		<div>
			<label>employee_id : <input class="read" type="number" name="employeeId" value="${empInfo.employeeId }" readonly="readonly"></label>
		</div>
		<div>
			<label>first_name : <input type="text" name="firstName" value="${empInfo.firstName }"></label>
		</div>
		<div>
			<label>last_name : <input class="read" type="text" name="lastName" value="${empInfo.lastName }" readonly="readonly"></label>
		</div>
		<div>
			<label>email : <input type="text" name="email" value="${empInfo.email }"></label>
		</div>
		<div>
			<label>hire_date : <input class="read" type="date" name="hireDate" 
								value="<fmt:formatDate value= "${empInfo.hireDate }" pattern="yyyy-MM-dd" />" readonly="readonly"></label>
		</div>
		<div>
			<label>job_id : <input class="read" type="text" name="jobId" value="${empInfo.jobId }" readonly="readonly"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary" value="${empInfo.salary }"></label>
		</div>
		<div>
			<button type="button" id="updateBnt">수정</button>
			<button type="button" onclick="location.href='empDelete?employeeId=${empInfo.employeeId}'">삭제</button>
			<button type="button" onclick="location.href='empList'">목록</button>
		</div>
	</form>
	<script>
		// JS 
		document.querySelector('#updateBnt')
				.addEventListener('click', updateEmpInfo);

		function updateEmpInfo(e) {
			// 해당 form 태그 내부의 input을 기반으로 수정할 대상 정보를 가져옴
			let empInfo = getEmpInfo();

			// 해당 정보를 기반으로 Ajax - QueryString 형태로
			fetch('empUpdate', {
				method : 'post',
				// date 보내주는 fetch일 때 QueryString 형태로 보내는 법
				body : new URLSearchParams(empInfo)
			})
			.then(response => response.json())
			.then(result => {
				console.log('QueryString', result);
			})
			.catch(err => {
				console.log('QueryString err', err);
			})

			// 해당 정보를 기반으로 Ajax - JSON 형태로
			fetch('empUpdateAjax', {
				method : 'post',
				headers : {
					'content-type' : 'application/json'
				},
				// 객체를 JSON으로 변환해주는 메소드
				body : JSON.stringify(empInfo)
			})
			.then(response => response.json())
			.then(result => {
				console.log('JSON', result);
			})
			.catch(err => {
				console.log('JSON err', err);
			})

			// return false;
		};

		function getEmpInfo() {
			let inputList = document.querySelectorAll('form input');
			
			let objData = {};

			// 배열을 객체로 변환해야함
			inputList.forEach(item => {
				//		키			 키에 대응되는 값
				objData[item.name] = item.value;
			});

			return objData;
		}
	</script>

	<script>
		// jQuery
		$('#updateBnt').on('click', updateEmpInfoAjax);

		function updateEmpInfoAjax(e) {
			let empInfo = getEmpInfoAjax();

			// Ajax -> Query String
			// 기본 세팅이 Query String이라서 따로 설정할게 없음
			$.ajax('empUpdate', {
				type : 'post',
				data : empInfo
			})
			// resonse => 이 작업 필요x $ajax가 알아서 인식해서 처리해줌(스트링이든 json이든) 바로 result
			.done(result => {
				console.log('Query String', result);
			})
			.fail(err => console.log(err));


			// Ajax -> JSON
			$.ajax('empUpdateAjax', {
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(empInfo)
			})
			.done(result => {
				console.log('JSON',result);
			})
			.fail(err => console.log(err));


			return false;
		}

		function getEmpInfoAjax() {
			// form태그 기반으로 해서 사용하는 메소드
			let formData = $('form').serializeArray();
			console.log(formData);
			// [{name: 'employeeId', value : '123'}, {name: '', value : ''}]로 구성되어 있음
			// employeeId 가 value가 된다 -> 우리는 키 형태면 좋은데

			let objData = {};
			// jQuery에서의 forEach가 $.each임
			$.each(formData, (idx, obj) => {
				objData[obj.name] = obj.value;
				//     키			  벨류
				//  {employeeId : '123', lastName : 'Min'} 이런 형태로 변경됨
			});

			return objData;
		}
	</script>
</body>
</html>