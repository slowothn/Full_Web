<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	map.put("name","홍길동");
	map.put("age", 30);
	map.put("gender", "남자");
	map.put("eye_left", 1.0);
	map.put("eye_right", 0.7);
	map.put("married",true);

	//왜? EL사용 위해
	pageContext.setAttribute("map", map);


%>
    
<hr>
	Map 목록
<hr>
	<c:forEach var="entry" items="${ map }">
		entry : ${ entry } <br>
		key : ${ entry.key } | value : ${ entry.value }<br>
		<hr>
	</c:forEach>    

    
    
    
    
    