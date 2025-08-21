<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PersonVo p = new PersonVo("홍길동",30,"서울시 관악구 남부순환로");
	//EL 사용가능
	pageContext.setAttribute("p", p);



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${ p.name } <!-- p,getName()  --><br>
나이 : ${ p['age'] }<br>
주소 : ${ p.getAddr() }<br>
</body>
</html>