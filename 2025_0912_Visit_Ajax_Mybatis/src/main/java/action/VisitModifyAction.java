package action;

import java.io.IOException;

import dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitModifyAction
 */
@WebServlet("/visit/modify.do")
public class VisitModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//  /visit/modify.do?idx=8&name=수정&content=음음&pwd=111
		
		//1.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter 받기
		int idx			= Integer.parseInt(request.getParameter("idx"));
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content").replaceAll("\n", "<br>");
		String pwd	   	= request.getParameter("pwd");
		
		//(+ 2.IP 받기
		String ip		= request.getRemoteAddr();
		
		//3.VisitVo 로 포장 (5가지 항목을 넣는 생성자 추가로 만들기)
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);
		
		//DB update
		int res = VisitDao.getInstance().update(vo);
		
		//5.메인화면(목록보기)		
		response.sendRedirect("list.do");
		
		

	}

}
