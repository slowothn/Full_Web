package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register2.do")		//url 패턴은 /로 시작해야함, 똑같은 이름의 url매핑이 있으면 err
public class MemberRegister2Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//수신인코딩 설정, 송수신 동일한 인코딩방식으로 설정 (요즘은 대부분 utf-8이긴함)
		request.setCharacterEncoding("utf-8"); 
		
		//특수문자는 16진수로 표현 %40 == @
		//member_register.do?name=홍홍홍&id=hong&pwd=hr23&email=h%402&gender=남자&hobby=독서&friend=&friend=&friend=&blood=A&intro=i
		String name		= request.getParameter("name");
		String id		= request.getParameter("id");
		String pwd		= request.getParameter("pwd");
		String email	= request.getParameter("email");
		String gender	= request.getParameter("gender");
		String blood	= request.getParameter("blood");
		String intro	= request.getParameter("intro");
		
		//parameter가 동일한 이름으로 여러개 있는 경우 -> 배열로 받기
		//chechbox라 체크를 안 하면 아무것도 안 넘어갈 수도 있음 > null 체크
		String [] hobby_arr		= request.getParameterValues("hobby");
		
		//input이라 빈값으로 넘겨도 값이 넘어감
		String [] friend_arr	= request.getParameterValues("friend");
		
		
		String hobby_list = "취미없음";
		//		member_register.do? name=홍홍홍&hobby=독서&hobby=영화
		//String [] hobby_arr = {"독서","영화"};
		if(hobby_arr != null) {
			//list += hobby로 하면 메모리 낭비가 심하므로 버퍼사용
			StringBuffer sb1 = new StringBuffer();
			for(String hobby : hobby_arr) {
				sb1.append("[");
				sb1.append(hobby);
				sb1.append("] ");
			}
			hobby_list = sb1.toString();
		}
		
		//member_register.do?name=홍홍홍&friend=&friend=&friend=&intro=j.....
		//String [] friend_arr = {"","",""};
		StringBuffer sb2 = new StringBuffer();
		for(String fd:friend_arr) {
			sb2.append(fd);
			sb2.append(" ");
		}
		String friend_list = sb2.toString().trim();		//공백제거
		if(friend_list.isEmpty())		//if(friend_list.equals(""))와 동일(쌍따옴표사이 공백 안 생기게 주의)
			friend_list = "친구없음";
		
		//--------[↑]-------- : Business Logic ( Data 관리 로직 )
		
		//--------[↓]-------- : Presentation Logic ( 화면 로직 )
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		map.put("email", email);
		map.put("gender", gender);
		map.put("blood", blood);
		map.put("hobby_list", hobby_list);
		map.put("friend_list", friend_list);
		map.put("intro", intro);
		
		//request binding
		request.setAttribute("map", map);
		
		//출력은 result_member2.jsp 에게 시키려고 호출
		RequestDispatcher disp = request.getRequestDispatcher("result_member2.jsp");
		disp.forward(request, response);
		
	}

}
