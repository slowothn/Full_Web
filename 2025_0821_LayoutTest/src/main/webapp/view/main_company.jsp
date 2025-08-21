<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- JSTL Core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/mainmenu.css">
    <link rel="stylesheet" href="../css/submenu.css">
</head>
<body>
    <div id="main-box">
        <div id="header"><%@include file="header/header.jsp" %></div>
        <!-- 회사소개 서브메뉴 -->
        <div id="aside"><%@include file="menu/submenu_company.jsp" %></div>
        <!-- 내용 -->
        <!-- 
        	 main_company.jsp?menu=intro
 			 main_company.jsp?menu=history	       
        	 main_company.jsp?menu=location        
         -->
        <div id="content">
         <!-- 인사말 -->
         <c:if test="${ (empty param.menu) or (param.menu eq 'intro') }">
         	<%@include file="content/company/intro.jsp" %>
         </c:if>
         
         <!-- 연혁 -->
         <c:if test="${ param.menu eq 'history' }">
         	<%@include file="content/company/history.jsp" %>
         </c:if>
         
         <!-- 오시는길 -->
         <c:if test="${ param.menu eq 'location' }">
         	<%@include file="content/company/location.jsp" %>
         </c:if>
        
        </div>
        <div id="footer"><%@include file="footer/footer.jsp" %></div>
    </div>
</body>
</html>    
    
    
    