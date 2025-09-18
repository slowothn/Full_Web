package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.MySearchUtil;
import util.MySearchUtilBook;
import vo.BookVo;
import vo.ProductVo;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/book/list.do")
public class BookListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        // /product/list.do?b_name=노트북&start=1&display=10 
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter받기
		String b_name = request.getParameter("b_name");
		
		int start   = 1;
		int display = 10;
		
		try {
			
			start	= Integer.parseInt(request.getParameter("start"));
			display = Integer.parseInt(request.getParameter("display"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Naver로부터 검색 상품 정보를 가져오기
		List<BookVo> list = MySearchUtilBook.search_book(b_name, start, display);
		
		//request binding
		request.setAttribute("list", list);
		
		
		//dispatcher(forward)
		String forward_page = "book_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}