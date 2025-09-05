<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 반복문 작성 위해 -->
<!-- JSTL Core : forEach, If, Choose -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JSTL Functions : substring,indexOf,length... -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#box {
	width: 700px;
	margin: auto;
	margin-top: 50px;
}

#title {
	text-align: center;
	font-weight: bold;
	font-size: 28px;
	color: rgb(51, 122, 183);
	text-shadow: 1px 1px 1px black;
}

#error_msg {
	color: red;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
}

.common{
	border: 1px solid #dddddd;
	padding: 5px;
	margin-bottom: 5px;
	box-shadow: 1px 1px 1px #aaaaaa;
}

.content{
	min-height: 80px;
}

</style>


<script type="text/javascript">

	function del(f){
			
		let idx = f.idx.value;				//게시물번호
		let c_pwd = f.c_pwd.value.trim();	//확인비번
		
		if(c_pwd==""){
			alert("삭제할 게시물의 비밀번호를 입력하세요");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		
		//Ajax 이용해서 비밀번호 체크
		$.ajax({
			
			url		:	"check_pwd.do",				// VisitCheckPwdAction
			data	:	{"idx":idx, "c_pwd":c_pwd},	// check_pwd.do?idx=5&c_pwd=1234
			dataType:	"json",						// 수신데이터 Type (생략시 html)
			success	:	function(res_data){
				// res_data = {"result":true} or {"result":false}
				if(res_data.result==false){
					alert("비밀번호가 일치하지 않습니다");
					return;
				}
				
				//삭제 진행
				//삭제확인
				if(confirm("정말 삭제하시겠습니까?")==false) return;
				
				//삭제처리요청			//form submit을 하면 idx,pwd,c_pwd 등의 필요없는 정보도 다 넘어감 -> get방식으로 직접 보냄
				location.href = "delete.do?idx=" + idx;		//VisitDeleteAction
			
			},
			error	:	function(err){
				alert(err.responseText);
			}
		});
		
		
	}

	//수정 폼 띄우는 함수
	function modify_form(f){
			
		let idx = f.idx.value;				//게시물번호
		let c_pwd = f.c_pwd.value.trim();	//확인비번
		
		if(c_pwd==""){
			alert("수정할 게시물의 비밀번호를 입력하세요");
			f.c_pwd.value="";
			f.c_pwd.focus();
			return;
		}
		
		//비밀번호 맞는지 여부 체크
		//Ajax 이용해서 비밀번호 체크
		$.ajax({
			
			url		:	"check_pwd.do",				// VisitCheckPwdAction
			data	:	{"idx":idx, "c_pwd":c_pwd},	// check_pwd.do?idx=5&c_pwd=1234
			dataType:	"json",						// 수신데이터 Type (생략시 html)
			success	:	function(res_data){
				// res_data = {"result":true} or {"result":false}
				if(res_data.result==false){
					alert("비밀번호가 일치하지 않습니다");
					return;
				}
				
				//수정 진행
				//수정폼 띄우기					//게시물을 식별할 수 있는 정보 넘기기(모든 파라미터를 넘길 수는 없음)
				location.href = "modify_form.do?idx=" + idx;
			
			},
			error	:	function(err){
				alert(err.responseText);
			}
		});
		
		
	}


</script>


</head>
<body>
	<div id="box">
		<h1 id="title">::방명록::</h1>

		<div style="margin-top: 30px; margin-bottom: 5px;">
			<input class="btn btn-primary" type="button" value="글쓰기" 
					onclick="location.href='insert_form.do'">
		</div>

		<!-- 데이터 출력 -->

		<!-- 데이터가 없을 경우 -->
		<c:if test="${ empty list }">
			<div id="error_msg">등록된 게시물이 없습니다.</div>
		</c:if>

		<!-- for(VisitVo vo : list)와 동일 -->
		<c:forEach var="vo" items="${ list }">
			<div class="panel panel-primary">
				<!-- 게시글 제목 -->
				<div class="panel-heading"><h4><b>${ vo.name }</b>님의 글</h4></div>
				<!-- 게시글 내용 -->
				<div class="panel-body">
					<form class="form-inline">
						<input type="hidden" name="idx" value="${ vo.idx }">
						<div class="common content">${ vo.content }</div>
						<div class="common regdate"> <!-- milisec까지 표시됨 -->
							<%--분까지만 나오도록
								regdate = "2025-09-01 11:08:15:0"
							 --%>
							<lable>등록일자</lable>:${ fn:substring(vo.regdate,0,16) }
													(${ vo.ip })
						</div>
						<div class="common pwd">
							<label>비밀번호(${ vo.pwd })</label>:<input class="form-control" 	type="password" name="c_pwd">
									 <input class="btn btn-success" type="button" value="수정" onclick="modify_form(this.form);">
									 <input class="btn btn-danger" 	type="button" value="삭제" onclick="del(this.form);">
						</div>
					</form>
				</div>
			</div>

		</c:forEach>

	</div>
</body>
</html>