package action.member;

import java.io.IOException;

import dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /member/login.do?mem_id=one&mem_pwd=1234

		//0.수신 인코딩
		//request.setCharacterEncoding("utf-8");
		
		//1.parameter 받아오기
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");
		
		//2.mem_id를 이용 selectOne으로 객체정보 얻어오기
		MemberVo user = MemberDao.getInstance().selectOne(mem_id);
		
		//아이디가 없으면 null로 리턴됨
		//서블릿만 나타나게되면 사용자가 이유를 모르니까 query로 알려줌 (=session tracking) 
		if(user==null) {
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		
		//비밀번호가 틀린 경우
		if(user.getMem_pwd().equals(mem_pwd)==false) {
			response.sendRedirect("login_form.do?reason=fail_pwd&mem_id=" + mem_id);
			return;
		}
		
		//정상적 로그인 처리
		HttpSession session = request.getSession();	//세션정보 얻어옴
		session.setAttribute("user", user);			//세션에 로그인 정보 넣음
		
		//메인페이지로 이동
		response.sendRedirect("list.do");
		

	}

}
