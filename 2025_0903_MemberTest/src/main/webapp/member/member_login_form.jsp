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
  
  <style type="text/css">
  	#box{
  		width: 400px;
  		margin: auto;
  		margin-top: 130px;
  	}
  	/* input:button */
  	input[type='button']{
  		width: 80px;
  	}
  	th{
  		vertical-align: middle !important;
  	}
  </style>
  <script type="text/javascript">
  	function send(f){

		let mem_id = f.mem_id.value.trim();
		let mem_pwd = f.mem_pwd.value.trim();
		
		if(mem_id==""){
			alert("아이디를 입력해주세요");
			f.mem_id.focus();
			return;
		}
		if(mem_pwd==""){
			alert("비밀번호를 입력해주세요");
			f.mem_pwd.focus();
			return;
		}
  	
		f.action = "login.do"	//MemberLoginAction
		f.submit();
  	}
  
  </script>
  <script type="text/javascript">
  	//document내의 모든 element가 배치가 완료되면 호출(초기화 이벤트)
  	window.onload=function(){
		//일회성, 지정된 시간(0.1초)이 지나면 show_message가 호출 
		//-> 시간차를 준 이유? 화면이 랜더링될 시간(0.1초)을 주고 호출해서 메시지 뜨도록
  		setTimeout(show_message, 100);
  	};
  	
  	function show_message(){
		// /login_form.do?reason=fail_id 		
			//jquery와 헷갈리지 않도록 문자열로 넣어줌 -> 비교해야하므로 true도 문자열로 넣어줌
  		if("${ param.reason eq 'fail_id' }" == "true"){
			alert("존재하지 않는 아이디입니다");
  		}
			
  		if("${ param.reason eq 'fail_pwd' }" == "true"){
			alert("비밀번호가 일치하지않습니다");
  		}
  	}
  </script>

</head>
<body>
<form>
	<div id="box">
		<!-- Bootstrap Panel -->
	   <div class="panel panel-primary">
	     <div class="panel-heading"><h5>로그인</h5></div>
	     <div class="panel-body">
	     	<table class="table">
	     		<tr>
	     			<th>아이디</th>
	     			<td><input class="form-control" name="mem_id" value="${ param.mem_id }"></td>
	     		</tr>
	     		<tr>
	     			<th>비밀번호</th>
	     			<td><input class="form-control" type="password" name="mem_pwd"></td>
	     		</tr>
	     		<tr>
	     			<td colspan="2" align="center">
	     				<input type="button" class="btn btn-default" value="메인화면" onclick="location.href='list.do'">
	     				<input type="button" class="btn btn-primary" value="로그인" onclick="send(this.form);">
	     			</td>
	     		</tr>
	     	</table>
	     </div>
	   </div>
	</div>
</form>	
</body>
</html>