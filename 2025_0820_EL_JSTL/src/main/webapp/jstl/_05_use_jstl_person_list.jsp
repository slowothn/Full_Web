<%@page import="vo.PersonVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	List<PersonVo> p_list = new ArrayList<PersonVo>();
	p_list.add(new PersonVo("일이삼",21,"서울시 관악구 서울대입구역 1번 출구"));
	p_list.add(new PersonVo("이삼사",22,"서울시 관악구 서울대입구역 2번 출구"));
	p_list.add(new PersonVo("삼사오",23,"서울시 관악구 서울대입구역 3번 출구"));
	p_list.add(new PersonVo("사오육",24,"서울시 관악구 서울대입구역 4번 출구"));
	p_list.add(new PersonVo("오오오",25,"서울시 관악구 서울대입구역 5번 출구"));

	//EL
	pageContext.setAttribute("p_list", p_list);
	
%>    
    
<table width="600" border="1">
	<!-- title -->
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>나이</th>
		<th>주소</th>
	</tr>
	<!-- data -->
	<!-- for(PersonVo p : p_list) 와 동일 -->
	<c:forEach var="p" items="${ p_list }" varStatus="i">
		<tr>
			<td>${ i.count }</td>
			<td>${ p.name }</td> <!-- dot표기법 -->
			<td>${ p['age'] }</td> <!-- square bracket -->
			<td>${ p.getAddr() }</td> <!-- getter call -->
		</tr>
	</c:forEach>

</table>
    
    
    