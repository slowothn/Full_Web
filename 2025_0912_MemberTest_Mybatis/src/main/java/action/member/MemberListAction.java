package action.member;

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

import dao.MemberDao;
import db.vo.MemberVo;

/**
 * Servlet implementation class MemberListAction
 */
@WebServlet("/member/list.do")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /list.do?search=mem_name&search_text=일
		
		request.setCharacterEncoding("utf-8");
		
		//parameter
		String search = request.getParameter("search");
		if(search==null) search="all";
		
		String search_text = request.getParameter("search_text");
		
		//검색 정보 담을 맵
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(search.equals("name_id")) {
			map.put("mem_name", search_text);
			map.put("mem_id", search_text);
			
		}else if(search.equals("mem_name")) {
			map.put("mem_name", search_text);
		}
		else if(search.equals("mem_id")) {
			map.put("mem_id", search_text);
		}
		
		
		//목록 가져오기
		List<MemberVo> list = MemberDao.getInstance().selectList(map);
		
		//request binding
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "member_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}