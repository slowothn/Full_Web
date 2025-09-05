<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <!-- 주소찾기 -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style type="text/css">
	#box{
		width: 700px;
		margin: auto;
		margin-top:100px;
	}
	.common{
		border: 1px solid #ddddff;
		margin: 10px;
		padding: 10px;
	}
	label{
		width: 70px;
	}


</style>

<script type="text/javascript">
	function check_id(){

		//영문자+숫자만 가능하도록 정규식 작성해보기

		//처음부터 회원가입 버튼을 비활성화 상태에서 사용 가능 아이디 입력시에만 활성화
		let mem_id = $("#mem_id").val();
		//회원가입 버튼 비활성화, 비활성화 속성을 true
		$("#btn_register").prop("disabled",true);
		if(mem_id.length<3){
			$("#msg_id").html("아이디는 3글자 이상이어야 합니다").css("color", "red");
			return;
		}
		
		//서버에게 아이디 체크 요청
		$.ajax({
			url		 :	"check_id.do",			//MemberCheckAction
			data	 :	{"mem_id" : mem_id},	//check_id.do?mem_id=one
			dataType :	"json",
			success	 :	function(res_data){
				//res_data = {"result":true} or {"result":false}
				if(res_data.result){
					//사용 가능
					$("#msg_id").html("사용가능한 아이디입니다").css("color","blue");
					//회원가입 버튼 활성화
					$("#btn_register").prop("disabled",false);
				}else{
					//이미 사용 중
					$("#msg_id").html("이미 사용중인 아이디입니다").css("color","red");
				}
			},
			error	 :	function(err){
				alert(err.responseText);
			}
		});
	
	}
	
	function find_addr(){

		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            //console.log(data);
	            
	            $("#mem_zipcode").val(data.zonecode);
	            $("#mem_addr").val(data.address);
	            
	        }
	    }).open();
	
	}//end:find_addr();
	
	
	
	function send(f){
		//아이디(이미 검증 완)를 제외하고 입력값 검증 작업(입력유무),DB상 주소가 필수는 아니지만 그래도 채우도록 체크하기
		let mem_name 	= f.mem_name.value.trim();
		let mem_pwd		= f.mem_pwd.value.trim();
		let mem_email	= f.mem_email.value.trim();
		let mem_zipcode	= f.mem_zipcode.value.trim();
		let mem_addr	= f.mem_addr.value.trim();
		
		if(mem_name==""){
			alert("이름을 입력하세요");
			f.mem_name.value="";
			f.mem_name.focus();
			return;
		}
		
		if(mem_pwd==""){
			alert("비밀번호를 입력하세요");
			f.mem_pwd.value="";
			f.mem_pwd.focus();
			return;
		}
		
		if(mem_email==""){
			alert("이메일을 입력하세요");
			f.mem_email.value="";
			f.mem_email.focus();
			return;
		}
		
		if(mem_zipcode==""){
			alert("우편번호를 입력하세요");
			f.mem_zipcode.value="";
			f.mem_zipcode.focus();
			return;
		}
		
		if(mem_addr==""){
			alert("주소를 입력하세요");
			f.mem_addr.value="";
			f.mem_addr.focus();
			return;
		}
		
		
		//전송하기 
		f.action = "insert.do";		//MemberInsertAction
		
		f.submit();
	
	}



</script>


</head>
<body>
	<form class="form-inline">
		<div id="box">
			<!-- Bootstrap Panel -->
		   <div class="panel panel-primary">
		     <div class="panel-heading"><h4>회원가입</h4></div>
		     <div class="panel-body">
				<div class="common">
					<label>이름</label>
					<input class="form-control" name="mem_name">
				</div>
				<div class="common">
					<label>아이디</label>
					<input class="form-control" name="mem_id" id="mem_id" onkeyup="check_id();">
					<!-- 아이디 중복체크 (ajax) -->
					<span id="msg_id"></span>
				</div>
				<div class="common">
					<label>비밀번호</label>
					<input class="form-control" type="password" name="mem_pwd">
				</div>
				<div class="common">
					<label>이메일</label>
					<input class="form-control" name="mem_email">
				</div>
				<div class="common">
					<label>우편번호</label>
					<input class="form-control" name="mem_zipcode" id="mem_zipcode">
					<input class="btn btn-basic" type="button" value="주소찾기" onclick="find_addr();">
					<br><br>
					<label>주소</label>
					<input class="form-control" name="mem_addr" id="mem_addr" size="65">
				</div>
				
				
				<div class="common" style="text-align: center;">
					<input type="button" class="btn btn-default" value="목록보기" onclick="location.href = 'list.do'">
					<input type="button" class="btn btn-success" value="회원가입"
					 id="btn_register" disabled="disabled" onclick="send(this.form);">
				</div>



			</div>
		   </div>


			
		</div>
	</form>
</body>
</html>