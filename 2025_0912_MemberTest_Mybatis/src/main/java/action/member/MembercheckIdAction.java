package action.member;

import java.io.IOException;

import dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MembercheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MembercheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// /member/check_id.do?mem_id=one
		
		//0.수신 인코딩
		//request.setCharacterEncoding("utf-8");
		
		//1.parameter 받기
		String mem_id = request.getParameter("mem_id");
		
		
		//2.mem_id를 이용해서 vo 추출
		MemberVo vo = MemberDao.getInstance().selectOne(mem_id);
		
		//vo가 null이어야 사용가능>true반환
		//3.결과
		boolean bResult = (vo==null);
		//boolean bResult = false; if(vo==null)bResult=true; 이 두 문장과 동일
		
		//4.결과 json 생성
		String json = String.format("{\"result\":%b}", bResult);
		
		//5.응답 처리
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(json);
		
	}

}