package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TestAction
 */
@WebServlet("/TestAction")
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//변수 선언
	int n;
	//메소드 선언
	void info() {
		System.out.println("정보출력");
	}
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//변수선언
		int x = 10;
		
		response.getWriter().print(x);
	}

}
