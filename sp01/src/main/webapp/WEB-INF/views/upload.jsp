<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 폼의 기반으로 이미지 보내려면 서버쪽에는 멀티파트리졸브 등록해줘야함 -->
	
	<!-- 
	
	<form action="" enctype="multipart/form-data">
		<input type="file" name="images" multiple="multiple">
		<button type="submit">전송</button>
	</form> 
	
	-->
	
	
	<div id="img">
		<input name="uploadFiles" type="file" multiple>
		<button class="uploadBnt">전송</button>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
	document.querySelector('.uploadBnt').addEventListener('click', function(e) {
		// formData : 폼이 가지고 있는 내부데이터를 하나의 클래스로 가지는것
		let formData = new FormData();  // jQuery.serializer() or jQuery.serializerArray()와 유사
									   // jQuery의 매소드
		// 폼태그 내부데이터를 한번에 들고오는 특징

		// 역할(formData)
		// 1) Form태그 내부의 데이터를 한번에 담음
		// 2) Ajax(비동기통신)를 이용해서 'content-type:multipart/form-data'를 보내는 경우
		
		let imageFile = document.querySelector('input[name="uploadFiles"]');
		let fileList = imageFile.files;	// files라는 객체를 사용해야함 (파일에 대한 모든 것)

		// 순수하게 데이터만 가져오는 작업
		for(let file of fileList){
			formData.append("uploadFiles", file);	//append를 이용해서 특정한 이름으로 데이터 넣음 / 배열형태로 추가되서 이름 하나만 써도 되는 것
		}

		// fetch
		fetch('uploadsAjax', {
			method : 'post',
			body : formData
		})
		.then(response => response.json())
		.then(data => console.log(data))
		.catch(err => console.log(err));
		
		//jQuery.ajax
        $.ajax({
            url: 'uploadsAjax',	
            type: 'post',
            processData: false,	// 기본값은 true, ajax 통신을 통해 데이터를 전송할 때, 기본적으로 key와 value값을 Query String으로 변환해서 보냅니다.
            contentType: false,	// multipart/form-data타입을 사용하기위해 false 로 지정합니다.
            data: formData,               
            success: function(result){
            	for(let image of result){
            		/* let imgTag = $('<img/>').prop('src', 'images/'+image).css('width', '200px');
            		$('#img').append(imgTag);
            		console.log(imgTag);*/
            		console.log(image);
            		
            	}
                console.log(result);
            },
            error: function(reject){	
                console.log(reject);
            }
		
        }); 

		

	});
</script>
</body>
</html>