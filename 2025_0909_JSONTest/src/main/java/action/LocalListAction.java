package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.KakaoSearchUtils;
import vo.LocalVo;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class LocalListAction
 */
@WebServlet("/local/list.do")
public class LocalListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /local/list.do?query=극장&page=1&size=3&radius=1000&latitude=37.481166&longitude=126.952147
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter 받기
		int page	= 1;
		int size	= 10;
		int radius	= 1000;
		
		String query	= request.getParameter("query");
		String x		= request.getParameter("longitude");
		String y		= request.getParameter("latitude");
		
		try {
			page	= Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}
		
		try {
			size 	= Integer.parseInt(request.getParameter("size"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			radius	= Integer.parseInt(request.getParameter("radius"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		//검색정보 가져오기
		List<LocalVo> list = KakaoSearchUtils.getSearchLocal(query, page, size, radius, x, y);
		
		//request binding
		request.setAttribute("list", list);

		//dispatcher(forward)
		String forward_page = "local_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}