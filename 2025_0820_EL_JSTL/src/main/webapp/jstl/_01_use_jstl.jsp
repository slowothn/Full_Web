<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSTL을 사용하려면 : core library
	<c:forEach ...> <c:if...> <choose...>
 --%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSTL내에 들어가는 변수(수식)은 모두 EL사용 -->
<c:forEach var="i" begin="0" end="4">
	<c:if test="${ i%2 eq 0 }">
		<h4><font color="red">${ i } :안녕</font></h4> <%-- 자기만 쓰는 변수는 pageScope에 임시로 저장하고 사용 =>i는 pageScope.i와 동일 --%>
	</c:if> 
	<c:if test="${ i%2 eq 1 }">
		<h4><font color="blue">${ i } :안녕</font></h4> <%-- 자기만 쓰는 변수는 pageScope에 임시로 저장하고 사용 =>i는 pageScope.i와 동일 --%>
	</c:if>
</c:forEach>
</body>
</html>