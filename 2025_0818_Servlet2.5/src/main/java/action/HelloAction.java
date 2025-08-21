package action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */

public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
//default constructor
	public HelloAction() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----------HelloAction.service() call-----------");
	}

}
