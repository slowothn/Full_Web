<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%!
	//JSP선언부
	
	//변수 선언
	int n;

	//메소드 선언
	void info(){
		System.out.println("정보출력");
	}

%>

<%
	//Script Let
	// _jspService(HttpServiceRequest request, HttpServiceResponse response)내의 영역
	int x=10;

	String ip = request.getRemoteAddr();

	System.out.println(application.getRealPath("/"));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
---[ JSP ]--- <br>
<!-- JSP표현식 -->
x = <%= x %>
</body>
</html>