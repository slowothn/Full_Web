package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.VisitDao;
import db.vo.VisitVo;

/**
 * Servlet implementation class VisitModifyFormAction
 */
@WebServlet("/visit/modify_form.do")
public class VisitModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /visit/modify_form.do?idx=2
		
		//1.idx 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//2.idx에 해당되는 1건의 데이터를 얻어옴
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		//textarea에 수정 데이터 원본을 넣기 위해 html로 저장된 <br>을 textarea(윈도우:\r\n, 유닉스계열:\n)의 \n으로 바꿔줘야함
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
		
		//request binding
		request.setAttribute("vo", vo);
		

		//dispatcher(forward)
		String forward_page = "visit_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}