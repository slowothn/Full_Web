package action.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutAction
 */
@WebServlet("/member/logout.do")
public class MemberLogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//세션에서 user 정보를 없애면 로그아웃
		HttpSession session = request.getSession();		//id가 저장된 request의 세션정보를 얻어옴
		
		//System.out.println(session.getId()); 	//로 확인가능, remove로 삭제하면 다시 로그인했을 때 동일한 세션 아이디사용
		
		//user 정보 삭제
		session.removeAttribute("user");		//이전에 쓰던 세션을 재활용
		
		//session.invalidate();		//완전히 삭제,session 리스너 사용 가능 //새로운 세션을 만들어줌(이전에 쓰던 세션 삭제)
		
		//메인 페이지로 이동
		response.sendRedirect("list.do");
		
	}

}