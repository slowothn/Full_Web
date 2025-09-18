package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.VisitDao;
import db.vo.VisitVo;

/**
 * Servlet implementation class VisitListAction
 */
@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 처음 메인 페이지 접속 시 /list.do  <<parameter값이 null
		//  /list.do?search=content&search_text=내가 
		
		request.setCharacterEncoding("utf-8");
		
		//parameter
		String search = request.getParameter("search");
		if(search==null) search="all";
		
		String search_text = request.getParameter("search_text");	//list.jsp에서 이미 null인지 확인했음
		
		//검색 정보를 담을 맵 선언
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(search.equals("name_content")) {
			map.put("name", search_text);
			map.put("content", search_text);
			
		}else if(search.equals("name")) {
			map.put("name", search_text);
			
		}else if(search.equals("content")) {
			map.put("content", search_text);
		}
		
		//방명록 목록가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//request binding
		request.setAttribute("list", list);

		//dispatcher(forward)
		String forward_page = "visit_list.jsp"; //visit폴더에서 찾음
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}