package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import action.BookAction;

/**
 * Servlet implementation class FrontController
 * 모든 요청을 다 받겠다는 의미로 *.do로 설정 (그냥 /도 똑같이 반응하긴 함)
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookAction action = new BookAction();
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//모든 요청을 받았기 때문에 어떤 요청인지 분석
		//요청 URL : http://localhost:8080/2025_0915_MVCTest/list.do
		//요청 URI : /2025_0915_MVCTest/list.do (전체주소 - 서버주소)
		
		String uri = request.getRequestURI();
		//System.out.println(uri);
		
		String forward_page = "";
		
		if(uri.contains("list.do")) {
			//전체목록 보기
			forward_page = action.list(request, response);
			
		}else if(uri.contains("view.do")) {
			//상세보기
			forward_page = action.view(request, response);
		}
		
		

		//dispatcher(forward)
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}