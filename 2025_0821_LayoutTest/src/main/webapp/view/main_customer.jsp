<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
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
        <!-- header Tag, nav Tag, footer Tag 존재하지만 일단 이걸로 통일 -->
        <div id="header"><%@include file="header/header.jsp" %></div>
        <!-- 회사소개 서브메뉴 -->
        <div id="aside"><%@include file="menu/submenu_customer.jsp" %></div>
        
        <div id="content">
        <!-- q&a -->
        <c:if test="${(empty param.menu) or (param.menu eq 'question') }">
        	<%@include file="content/customer/question.jsp" %>
        </c:if>
        <!-- info -->
        <c:if test="${ param.menu eq 'info' }">
        	<%@include file="content/customer/info.jsp" %>
        </c:if>
        <!-- reference -->
        <c:if test="${ param.menu eq 'reference' }">
        	<%@include file="content/customer/reference.jsp" %>
        </c:if>
        
        </div>
        <div id="footer"><%@include file="footer/footer.jsp" %></div>
    </div>
</body>
</html>    
    
    
    