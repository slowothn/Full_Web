package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//원격 컴퓨터 제어를 위해 1.IP 2.Port 번호를 알아야 함
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//str_su1,str_su2 로 받고 int형으로 변환해도 됨
		
		int su1 = Integer.parseInt(request.getParameter("su1"));
		
		int su2 = Integer.parseInt(request.getParameter("su2"));
		//나누기,나머지 연산 예외처리
		/*
		 * String divs = ""; String mod = ""; if(su2==0) { divs=" '0'으로 나눌 수 없습니다";
		 * mod="  '0'으로 나눌 수 없습니다"; } else { divs = Double.toString(1.0*su1/su2); mod =
		 * Integer.toString(su1%su2); }
		 */
		
		
		//응답처리
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
//		+, -, * , /, %
		//Server -> Client로 내용 전송(응답)
		out.print("<html>");
		out.print("<body>");
		out.print("<h2>:::계산 결과:::</h2>");
		out.printf("%d + %d = %d<br>",su1,su2,su1+su2);
		out.printf("%d - %d = %d<br>",su1,su2,su1-su2);
		out.printf("%d * %d = %d<br>",su1,su2,su1*su2);
		
		//나누기, 나머지 연산 예외처리(내가 작성한 코드보다 훨씬 깔끔)
		if(su2==0) {
			out.print("<font color='red'>0으로 나눌 수 없습니다.<br></font>");
		}else {
			out.printf("%d / %d = %f<br>",su1,su2, (su1*1.0/su2));
			out.printf("%d %% %d = %d<br>",su1,su2,(su1%su2));
		}
		
		
		out.print("<a href='Calc.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
