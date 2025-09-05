package action;

import java.io.IOException;

import dao.VisitDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitDeleteAction
 */
@WebServlet("/visit/delete.do")
public class VisitDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// visit/delete.do?idx=3
		//모든 parameter는 String 형으로 받고 나중에 형 변환
//		String str_idx 	= request.getParameter("idx");	// "3"
//		int idx			= Integer.parseInt(str_idx);			// "3" -> 3
		
		//한 줄로 쓸 수 있음
		//1. 삭제할 게시물 idx 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//2.DB delete
		int res = VisitDao.getInstance().delete(idx);
		
		//3.메인으로 이동(목록보기)
		response.sendRedirect("list.do");
		
		

	}

}
