<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//Script Let (Java Code 작성 가능)
	
	 //수신인코딩 설정, 송수신 동일한 인코딩방식으로 설정 (요즘은 대부분 utf-8이긴함)
		request.setCharacterEncoding("utf-8"); 
		
		//특수문자는 16진수로 표현 %40 == @
		//member_register.do?name=홍홍홍&id=hong&pwd=hr23&email=h%402&gender=남자&hobby=독서&friend=&friend=&friend=&blood=A&intro=i
		String name		= request.getParameter("name");
		String id		= request.getParameter("id");
		String pwd		= request.getParameter("pwd");
		String email	= request.getParameter("email");
		String gender	= request.getParameter("gender");
		String blood	= request.getParameter("blood");
		String intro	= request.getParameter("intro");
		
		//parameter가 동일한 이름으로 여러개 있는 경우 -> 배열로 받기
		//chechbox라 체크를 안 하면 아무것도 안 넘어갈 수도 있음 > null 체크
		String [] hobby_arr		= request.getParameterValues("hobby");
		
		//input이라 빈값으로 넘겨도 값이 넘어감
		String [] friend_arr	= request.getParameterValues("friend");
		
		
		String hobby_list = "취미없음";
		//		member_register.do? name=홍홍홍&hobby=독서&hobby=영화
		//String [] hobby_arr = {"독서","영화"};
		if(hobby_arr != null) {
			//list += hobby로 하면 메모리 낭비가 심하므로 버퍼사용
			StringBuffer sb1 = new StringBuffer();
			for(String hobby : hobby_arr) {
				sb1.append("[");
				sb1.append(hobby);
				sb1.append("] ");
			}
			hobby_list = sb1.toString();
		}
		
		//member_register.do?name=홍홍홍&friend=&friend=&friend=&intro=j.....
		//String [] friend_arr = {"","",""};
		StringBuffer sb2 = new StringBuffer();
		for(String fd:friend_arr) {
			sb2.append(fd);
			sb2.append(" ");
		}
		String friend_list = sb2.toString().trim();		//공백제거
		if(friend_list.isEmpty())		//if(friend_list.equals(""))와 동일(쌍따옴표사이 공백 안 생기게 주의)
			friend_list = "친구없음";
		
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
</head>
<body>
	<table width='400' border='1'>
		<caption>::::회원정보::::</caption>
		<tr>
			<th>이름</th>
			<td><%= name %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%= id %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%= pwd %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= email %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%= gender %></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><%= blood %></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><%= hobby_list %></td>
		</tr>
		<tr>
			<th>친구</th>
			<td><%= friend_list %></td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td><%= intro %></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><a href='input_member.html'>다시하기</a></td>
		</tr>
	</table>


</body>
</html>