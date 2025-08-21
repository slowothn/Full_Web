<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//dispatcher 방식을 forward 방식이라고도 함 (c->d로 전진)
	System.out.println("---c.jsp가 d.jsp를 부른다---");	
	//서버내부에서 이동시키는 방식
	RequestDispatcher disp = request.getRequestDispatcher("d.jsp");

	disp.forward(request, response);
	//client는 d.jsp의 주소를 모름. c에 요청하면 d가 결과를 알려줌>주소창은 c인데 출력은 d
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나는 c.jsp
</body>
</html>