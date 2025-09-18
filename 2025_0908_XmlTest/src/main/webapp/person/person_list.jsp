<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL Core lib -->    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<!-- table title -->
		<tr>
			<th>이름</th>
			<th>별명</th>
			<th>나이</th>
			<th>휴대전화번호</th>
			<th>집 전화번호</th>
		</tr>
		<!-- for(PersonVo vo : list) -->
		<c:forEach var="vo" items="${ list }">
			<tr>
				<td>${ vo.name }</td>
				<td>${ vo.nickname }</td>
				<td>${ vo.age }</td>
				<td>${ vo.tel }</td>
				<td>${ vo.hometel }</td>
			</tr>
		</c:forEach>
	
	
	
	</table>

</body>
</html>