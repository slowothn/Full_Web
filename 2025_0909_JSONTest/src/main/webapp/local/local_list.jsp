<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap3.x ver -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

  <table class="table">
    
    <!-- title -->
    <tr>
       <th>순번</th>
       <th>상호(명)</th>
       <th>주소</th>
       <th>전화번호</th>
       <th>위치(위도/경도)</th>
       <th>거리(m)</th>
    </tr>
    
    <!-- data -->
    <!-- for(LocalVo vo : list)  -->
    <c:forEach var="vo"  items="${ list }" varStatus="i">
       <tr>
          <!-- /local/list.do?page=2&size=10& .. -->
          
          <td>${ (param.page-1)*param.size +  i.count }</td>
          <td><a href="${ vo.place_url }" target="_blank">${ vo.place_name }</a></td>
          <td>
             지번:${ vo.address_name } <br>
             도로:${ vo.road_address_name }
          </td>
          <td>${ vo.phone }</td>
          <td>
             위도:${ vo.y }<br>
             경도:${ vo.x }
          </td>
          <td>${ vo.distance }</td>
       </tr>
    </c:forEach>
  
  </table>


</body>
</html>


