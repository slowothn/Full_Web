<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//Script Let (Java Code 작성 가능)
	
		
		//--------[↑]-------- : Business Logic ( Data 관리 로직 )
		
		//--------[↓]-------- : Presentation Logic ( 화면 로직 )
		
		
		/* 
		
		
		//응답처리							전송시 인코딩방식 설정
		response.setContentType("text/html; charset=utf-8;");
		
		
		 OutputStream os = response.getOutputStream(); //PrintStream ps = new
		 PrintStream(os); PrintWriter out1 = new PrintWriter(os);
		
		
		PrintWriter out1 = response.getWriter();
		
		//HTML생성 -> StringBuffer에 누적
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<table width='400' border='1'>");
		sb.append("<caption>::::회원정보::::</caption>");
		sb.append(String.format("<tr><th>이름</th><td>%s</td></tr>", name));
		sb.append(String.format("<tr><th>아이디</th><td>%s</td></tr>", id));
		sb.append(String.format("<tr><th>비밀번호</th><td>%s</td></tr>", pwd));
		sb.append(String.format("<tr><th>이메일</th><td>%s</td></tr>", email));
		sb.append(String.format("<tr><th>성별</th><td>%s</td></tr>", gender));
		sb.append(String.format("<tr><th>혈액형</th><td>%s</td></tr>", blood));
		sb.append(String.format("<tr><th>취미</th><td>%s</td></tr>", hobby_list));
		sb.append(String.format("<tr><th>친구</th><td>%s</td></tr>", friend_list));
		sb.append(String.format("<tr><th>자기소개</th><td>%s</td></tr>", intro));
		sb.append("<tr><td colspan='2' align='center'><a href='input_member.html'>다시하기</a></td></tr>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		//응답(전송)
		out1.print(sb.toString()); 
		
	*/
		


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{width='400';}
</style>
</head>
<body>
	<table border='1'>
		<caption>::::회원정보::::</caption>
		<tr>
			<th>이름</th>
			<td>${ map.name }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${ map.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${ map.pwd }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${ map.email }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${ map.gender }</td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td>${ map.blood }</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>${ map.hobby_list }</td>
		</tr>
		<tr>
			<th>친구</th>
			<td>${ map.friend_list }</td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td>${ map.intro }</td>
		</tr>
		<tr>
			<td colspan='2' align='center'><a href='input_member.html'>다시하기</a></td>
		</tr>
	</table>


</body>
</html>