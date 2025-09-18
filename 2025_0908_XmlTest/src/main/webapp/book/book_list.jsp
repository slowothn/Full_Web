<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL Core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- JSTL Fmt -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap 3.x -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <style type="text/css">
  	img{
  		width: 100px;
  		height: 120px;
  	}
  </style>
  
</head>
<body>
	<table class="table">
		<tr class="info">
			<th>이미지</th>
			<th>도서명</th>
			<th>글쓴이</th>
			<th>판매가</th>
			<th>출판사</th>
		</tr>
		
		<%-- 통화표시가 깨지면 해당 코드 넣기(지역코드 잡아줌) <fmt:setLocale value="ko_kr"/> --%>
		<!-- for(ProductVo vo : list) -->
		<c:forEach var="vo" items="${ list }">
			<tr>
				<td><img src="${ vo.image }"></td>
				<td><a href="${ vo.link }" target="_blank">${ vo.title }</a></td>
				<td>${ vo.author }</td>
				<!-- 세자리마다 , 찍어줌 / type을 currency로 설정하면 통화표시해줌 -->
				<td><fmt:formatNumber type="currency" value="${ vo.discount }" /></td>
				<td>${ vo.publisher }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>