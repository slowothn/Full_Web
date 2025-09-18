package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.SawonVo;

import java.io.IOException;
import java.util.List;

import dao.SawonDao;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// sawon/list.do?deptno=20
		int deptno = 0;
		//parameter없이 들어오면 null이 되면서 끝나버림 > try catch 블록 지정(shift+ctrl+z) < 알아서 에러처리
		try {
			deptno = Integer.parseInt(request.getParameter("deptno"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}	
		
		//목록 가져오기
		List<SawonVo> list = null;
			
		if(deptno==0) {
			list =	SawonDao.getInstance().selectList();
		}else {
			//부서별 조회
			list =	SawonDao.getInstance().selectListFromDeptno(deptno);
			
		}
				
		
		//request binding
		request.setAttribute("list", list);

		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}