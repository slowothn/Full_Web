<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
		EL(Expression Language) : 표현언어
		
		1.문자, 숫자, boolean, null 표현 가능
		2.각 scope내 또는 parameter에 저장된 값만 표현 가능
		3.형식	:	${ 표현식 }
		

		
	*/



%>

<!-- HTML 주석 
		EL 형식 : \${  } \를 붙이면 문자열로 취급됨
-->
<%-- JSP 주석 : JSP->jsp 서블릿 변환시 안 넘어감 --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<h4>EL 연산자</h4>
<hr>
\${ 3+1 } → ${ 3+1 }<br>
\${ 3-1 } → ${ 3-1 }<br>
\${ 3*2 } → ${ 3*2 }<br>
\${ 10/3 }<%-- or \${ 10 div 3 } --%> → ${ 10/3 } <br> <%-- html의 <div>랑 겹친다고 err, 결과는 나옴 --%>
\${ 10%3 } → ${ 10%3 } or ${ 10 mod 3 }<br>

<hr>
	<h4>EL 연산자(관계)</h4>
<hr>
<!-- gt : greater than -->
\${ 3 > 2 } → ${ 3 > 2 } or ${ 3 gt 2 }<br>
<!-- ge : greater equal -->
\${ 3 >= 2 } → ${ 3 >= 2 } or ${ 3 ge 2 }<br>
<!-- lt : less than -->
\${ 3 < 2 } → ${ 3 < 2 } or ${ 3 lt 2 }<br>
<!-- le : less equal -->
\${ 3 <= 2 } → ${ 3 <= 2 } or ${ 3 le 2 }<br>

<!-- eq : equal -->
\${ 3 == 2 } → ${ 3 == 2 } or ${ 3 eq 2 }<br>
<!-- ne : not equal -->
\${ 3 != 2 } → ${ 3 != 2 } <%-- or ${ 3 ne 2 } --%><br> <%-- ne 잘 작동하는데 예약어가 있는지 err뜸 --%>

<hr>
	<h4>EL 연산자(3항연산자 및 empty)</h4>
<hr>
\${ (3>=0) ? '양수' : '음수' } → ${ (3>=0) ? '양수':'음수' }<br>
<!-- el1.jsp?msg=안녕 -->
전달 메시지 : ${ (empty param.msg) ? '전달 메시지 없음' : param.msg }<br>



</body>
</html>