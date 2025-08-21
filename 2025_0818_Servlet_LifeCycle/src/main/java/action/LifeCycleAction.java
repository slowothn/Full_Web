package action;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LifeCycleAction
 */
@WebServlet("/lifecycle.do")
public class LifeCycleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleAction() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("---1.LifeCycleAction()---");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		 System.out.println("---2.init()---");
	}

	/**
	 * @see Servlet#destroy()
	 */
//	code를 수정하면 tomcat이 알아차리고 컨테이너에서 기존 서블렛을 destroy
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("---4.destroy()---");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---3.service()---");
		
		//super.service(request, response);
		//요청방식
		String method = request.getMethod();
		System.out.println(method);
		
		//service 부분을 주석처리해도 재정의에 관해 해당 코드(if문)처럼 수행됨. 현업에서는 이 분기점까지 가지말고 서비스에서 종료하면 됨
		if(method.equals("GET")) {
			
			doGet(request,response);
			
		}else if(method.equals("POST")) {
			
			doPost(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--- 3-1.doGet() ---");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--- 3-2.doPost() ---");
	}

}
