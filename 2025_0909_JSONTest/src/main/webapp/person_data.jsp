<%@page import="java.util.Date"%>
<%@ page language="java" 
	contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
{
	"lastModifyDate" : "<%= new Date() %>", 
	"persons" : [
					{"name":"일길동", "age":21, "tel":"010-111-1234"},
					{"name":"이길동", "age":22, "tel":"010-222-1234"},
					{"name":"삼길동", "age":23, "tel":"010-333-1234"},
					{"name":"사길동", "age":24, "tel":"010-444-1234"},
					{"name":"오길동", "age":25, "tel":"010-555-1234"}
				] 
}    
    
    
    
    