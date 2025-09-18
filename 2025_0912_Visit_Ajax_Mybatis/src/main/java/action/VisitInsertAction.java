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
 * Servlet implementation class VisitInsertAction
 * //forward 형이 아니기 때문에 일단 만들어놓고 forward 지움
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// parameter : 요청시 전달인자(name, content, pwd)
		//  /visit/insert.do?name=홍홍홍&content=잘+들어가나ㅏㅏㅏㅏ&pwd=1234
		
		//0.수신 인코딩 (수신객체가 request)
		request.setCharacterEncoding("utf-8");
		
		//1.parameter 받기
		String name 	= request.getParameter("name");
		//			<textarea> : \r\n		 <div> : <br>
		//				입력					출력	
		//						\r\n -> <br> 변환	
		String content 	= request.getParameter("content").replace("\n", "<br>"); 
		String pwd 		= request.getParameter("pwd");
		
		//2.ip구하기
		String ip 		= request.getRemoteAddr(); //전송자(client) IP
		
		//3.VisitVo 포장 (Visitvo 에 생성자 만들기)
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		
		//4.DB Insert	//res가 1이면 성공 0이면 실패, res는 안 받아놔도 괜찮
		int res = VisitDao.getInstance().insert(vo);
		
		

		//Redirect : 목록보기로 재접속정보 응답 (insert, update, delete) <-> forward는 select할 때
		response.sendRedirect("list.do");

	}

}