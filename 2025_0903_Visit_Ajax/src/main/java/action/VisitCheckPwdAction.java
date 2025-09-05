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
 * Servlet implementation class VisitCheckPwdAction
 */
@WebServlet("/visit/check_pwd.do")
public class VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /visit/check_pwd.do?idx=4&c_pwd=111
		
		//0.수신 인코딩 설정(특수문자나 한글은 필수)
		request.setCharacterEncoding("utf-8");
		
		//1.전달된 parameter 받기
		int idx 	 = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//2.idx에 해당되는 게시물 1건 정보 얻어오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		//3.비밀번호 비교
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		//JSON 형식 : {"result":true} ""형식을 지켜서 보내야 함!
		String json = String.format("{ \"result\" : %b }", bResult);
		
		//응답처리
		response.setContentType("application/json; charset=utf-8;");	//"text/json" 도 가능, 한글이 넘어갈 수 있으니 charset 설정
		response.getWriter().print(json);
		

	}

}
