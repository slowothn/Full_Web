<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	//EL(조회용 표현 언어)
	
	//JSP 내장객체 : pageContext, request, session, application
	//				 binding API   (bind:연결)
	pageContext.setAttribute("msg", "pageScope 영역");
	request.setAttribute("msg", "requestScope 영역");
	session.setAttribute("msg", "sessionScope 영역");
	application.setAttribute("msg", "applicationScope 영역");
	
	String name = "김철수";
	//						key, value	<- Map 형식
	request.setAttribute("name", name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 영역에 저장된 값이 아니므로 출력 안 됨 -->
이름 : ${  name }<br>

							  <%-- ${ 영역명.변수명 } --%>
pageContext 영역내의 데이터 : ${ pageScope.msg }<br>
requestScope 영역내의 데이터 : ${ requestScope.msg }<br>
sessionScope 영역내의 데이터 : ${ sessionScope.msg }<br>
applicationScope 영역내의 데이터 : ${ applicationScope.msg }<br>

<!-- EL에서 영역명을 생략하면 어떤 영역의 데이터가 사용될까? 
		참조순서 : pageScope -> requestScope -> sessionScope -> applicationScope
	page의 setAttribute를 주석처리하면 msg로 request 출력, 모든 영역 주석처리하면 msg라는 변수명을 지정한게 없으므로 아무것ㅅ도 안 나옴.
-->
???Scope : ${ msg }<br>

</body>
</html>