package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.SawonVo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SawonDao;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/condition_list.do")
public class SawonConditionListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		// sawon/condition_list.do?deptno=20&sajob=과장&sasex=여자&year10=1990
		int deptno 		= 0;
		String sajob 	= null;
		String sasex	= null;
		String year10	= null;
		
		//parameter없이 들어오면 null이 되면서 끝나버림 > try catch 블록 지정(shift+ctrl+z) < 알아서 에러처리
		try {
			deptno = Integer.parseInt(request.getParameter("deptno"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}
		
		sajob = request.getParameter("sajob");
		if(sajob==null) sajob="all";
		
		sasex = request.getParameter("sasex");
		if(sasex==null) sasex="all";
		
		year10 = request.getParameter("year10");
		if(year10==null) year10="all";
		
		//검색조건을 담을 Map 객체 생성 ( 두개 이상의 정보를 묶어서 보내기)
		Map<String, Object> map = new HashMap<String, Object>();
		//전체 검색이 아니면 검색 조건 추가
		if(deptno!=0) {	map.put("deptno", deptno); }
		//전체 검색이 아니면 검색 조건 추가
		if(sajob.equals("all")==false) { map.put("sajob", sajob); }
		
		if(sasex.equals("all")==false) map.put("sasex", sasex);
		
		if(year10.equals("all")==false) map.put("year10", year10);
		
		//select * from sawon where deptno=10 and sajob='부장'
		
		//목록 가져오기 (method 만들기, mapper 생성)
		List<SawonVo> list = SawonDao.getInstance().selectConditionList(map);
			
		
		//request binding
		request.setAttribute("list", list);

		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}