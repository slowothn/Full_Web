<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<String> sido_list = new ArrayList<String>();
	sido_list.add("서울");	//0
	sido_list.add("경기");	//1
	sido_list.add("인천");	//2
	sido_list.add("강원");	//3
	sido_list.add("제주");	//4
	
	//							key			value(값이 들어가야 한다는 거 주의! 여기도 ""쓰면 그냥 문자열됨)		
	pageContext.setAttribute("sido_list", sido_list);
	
%>

<hr>
	시도목록
<hr>
	<ul>
			<!-- for(String sido : sido_list) 와 동일
				varStatus="i"
					index = 첨자
					count = 순번
			 -->
		<c:forEach var="sido" items="${ sido_list }" varStatus="i"> <!-- varStatus는 객체>순서도 존재 -->
			<li>${i.count}번째 : ${ sido } (${ i.index })</li>
		</c:forEach>
	</ul>
