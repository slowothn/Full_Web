package action;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//POJO(Plain Old Java Object) : 순수자바객체(오직 Object만 상속받은 객체)
public class BookAction {

	//목록을 처리하는 메소드
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		List<String> book_list = new ArrayList<String>();
		
		book_list.add("HTML");
		book_list.add("CSS");
		book_list.add("Javascript");
		book_list.add("JAVA");
		book_list.add("Oracle");
		book_list.add("Servlet");
		
		//request binding
		request.setAttribute("book_list", book_list);
		
		return "book_list.jsp";		//forward시킬 view 페이지 정보를  반환
	}

	public String view(HttpServletRequest request, HttpServletResponse response) {
		//view.do?book=HTML
		//view.do?book=JAVA
		//view.do?book=Oracle
		
		String book = request.getParameter("book").toUpperCase();
		
		String content = "";
		
		if(book.equals("HTML")) {
			content = "Hyper Text Markup Language로 태그 기반의 언어";
			
		}else if(book.equals("CSS")) {
			content= "Cascading Style Sheet로 모양을 내는 언어";
			
		}else if(book.equals("JAVASCRIPT")) {
			content= "Brower내의 이벤트나 모든 동작을 제어하는 언어";
			
		}else if(book.equals("JAVA")) {
			content= "대중적인 객체지향언어";
		
		}else if(book.equals("ORACLE")) {
			content= "현존하는 정형화된 데이터를 다루는 최고의 프로그램";
		
		}else if(book.equals("SERVLET")) {
			content= "Java언어로 만든 웹프로그램의 서비스 객체";
		}
		
		//request binding
		request.setAttribute("content", content);
		
		return "book_view.jsp";	//forward할 view페이지 return
	}
	
	
}
