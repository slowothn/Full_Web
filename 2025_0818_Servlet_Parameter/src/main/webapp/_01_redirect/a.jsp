<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//Java Code 작성
	
	System.out.println("a.jsp 왔다감--;");		//a.jsp에 왔다간 증거 남기기
	//client에게 재접속에 대한 정보 넘겨줌
	response.sendRedirect("b.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나는 a.jsp
</body>
</html>