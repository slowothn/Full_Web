<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i=0;i<5;i++){
		
		if(i%2==0){
%>
	<h4><font color='red'><%= i %>: 안녕</font></h4>
<%
		}else{
%>
	<h4><font color='blue'><%= i %>: 안녕</font></h4>
<%
		}//end:if
	}//end:for
%>
</body>
</html>