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
		
		//수정확인
		if(confirm("수정하시겠습니까?")==false){
			//페이지 다시 호출(새로 고침)
			location.href="";
			return;
		}
		
		//전송하기 
		f.action = "modify.do";		//MemberModifyAction
		
		f.submit();
	}

</script>

<!-- 초기화(이거 안하면 전부 일반이 초기값이 됨) -->
<script type="text/javascript">
	/* window.onload 대신 jquery 써봄 */
	/* document가 ready되면 함수 호출 */
	$(document).ready(function(){
		//회원구분의 값을 초기화
		// <select id="mem_grade"> 
		//앞$는 jquery, 뒤$는 EL (둘을 구분하기 위해 문자열로 적어주고 더블,싱글 다르게 표현)
		$("#mem_grade").val('${ vo.mem_grade }');
	
	});
</script>


</head>
<body>
	<form class="form-inline">
		<%-- <input type="hidden" name="mem_idx" value="${ vo.mem_idx }"> --%>
		<div id="box">
			<!-- Bootstrap Panel -->
		   <div class="panel panel-primary">
		     <div class="panel-heading"><h4>회원정보 수정</h4></div>
		     <div class="panel-body">
		     	<!-- 숨기지 않아도 됨(위에 주석처리한 hidden도 가능) -->
				<div class="common">
					<label>회원번호</label>
					<input class="form-control" name="mem_idx" value="${ vo.mem_idx }" readonly="readonly">
				</div>
				<div class="common">
					<label>이름</label>
					<input class="form-control" name="mem_name" value="${ vo.mem_name }">
				</div>
				<div class="common">
					<!-- 아이디는 변경하지 못하도록 설정(readonly) -->
					<label>아이디</label>
					<input class="form-control" name="mem_id" value="${ vo.mem_id }" readonly="readonly">
				</div>
				<div class="common">
					<label>비밀번호</label>
					<input class="form-control" type="password" name="mem_pwd" value="${ vo.mem_pwd }">
				</div>
				<div class="common">
					<label>이메일</label>
					<input class="form-control" name="mem_email" value="${ vo.mem_email }">
				</div>
				<div class="common">
					<label>우편번호</label>
					<input class="form-control" name="mem_zipcode" value="${ vo.mem_zipcode }" id="mem_zipcode">
					<input class="btn btn-basic" type="button" value="주소찾기" onclick="find_addr();">
					<br><br>
					<label>주소</label>
					<input class="form-control" name="mem_addr" id="mem_addr" size="65" value="${ vo.mem_addr }">
				</div>
				<!-- 회원등급 -->
				<div class="common">
					<label>회원등급</label>
					<select name="mem_grade" id="mem_grade" class="form-control">
						<option value="일반">일반</option>
						<option value="관리자">관리자</option>
					</select>
				</div>
				
				
				<div class="common" style="text-align: center;">
					<input type="button" class="btn btn-default" value="목록보기" onclick="location.href = 'list.do'">
					<input type="button" class="btn btn-success" value="회원정보 수정" onclick="send(this.form);">
				</div>



			</div>
		   </div>


			
		</div>
	</form>
</body>
</html>