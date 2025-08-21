package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloAction
 */

//http://localhost:8080/2025_0818_Servlet_Parameter/hello.do

@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	//						요청처리객체(client의 정보관리)    응답처리객체(client에게 응답:client정보 앎)				
	protected void service(   HttpServletRequest request,    	HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//			 ?query
		//			  전달인자(parameter)
		//	/hello.do?nation=kor&time=morning
		//	/hello.do?nation=eng
		//	/hello.do?nation=jpn
		//	/hello.do?nation=chn
		//	/hello.do?nation=ger
		//	/hello.do?nation=fra
		//	/hello.do
		
		String nation = request.getParameter("nation");
		//System.out.println(nation);
		//null exception 처리
		if(nation == null) {
			nation = "kor";
		}
		
		String time = request.getParameter("time");
		if(time == null) {time = "morning";}
		
		String nation_name = "?★?";
		String greeting = "⊙.⊙";
		
		
		if(nation.equals("kor")) {
			nation_name = "한국";
			if(time.equals("morning"))
				greeting = "좋은 아침입니다";
			else if(time.equals("afternoon"))
				greeting = "활기찬 하루 보내세요";
			else if(time.equals("evening"))
				greeting = "편안한 밤 보내세요";
		}else if(nation.equals("eng")) {
			nation_name = "미국/영국";
			if(time.equals("morning"))
				greeting = "Good morning~!";
			else if(time.equals("afternoon"))
				greeting = "Good afternoon~!";
			else if(time.equals("evening"))
				greeting = "Good evening~!";
		}else if(nation.equals("jpn")) {
			nation_name = "일본";
			if(time.equals("morning"))
				greeting = "오하요";
			else if(time.equals("afternoon"))
				greeting = "곤니치와";
			else if(time.equals("evening"))
				greeting = "곰방와";
		}else if(nation.equals("chn")) {
			nation_name = "중국";
			if(time.equals("morning"))
				greeting = "早安 [zǎo ān]";
			else if(time.equals("afternoon"))
				greeting = "中午好 [zhōng wǔ hǎo]";
			else if(time.equals("evening"))
				greeting = "晚上好 [wǎn shàng hǎo]";
		}else if(nation.equals("ger")) {
			nation_name = "독일";
			if(time.equals("morning"))
				greeting = "구텐모르겐";
			else if(time.equals("afternoon"))
				greeting = "구텐탁";
			else if(time.equals("evening"))
				greeting = "구텐아벤트";
		}else if(nation.equals("fra")) {
			nation_name = "프랑스";
			if(time.equals("morning"))
				greeting = "봉쥬르";
			else if(time.equals("afternoon"))
				greeting = "봉쥬";
			else if(time.equals("evening"))
				greeting = "봉수아";
		}
		
		String time_kor = "오전";
		if(time.equals("morning")) {time_kor="오전";}
		else if(time.equals("afternoon")) {time_kor="오후";}
		else if(time.equals("evening")) {time_kor="저녁";}
		//응답처리
		//			mime-type : image/jpg	image/tiff
		//						text/html	text/xml
		//						application/json  (또는 text/json)
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter(); //출력스트림 얻어옴
		//html 넘기기로 약속했으니까 html 작성
		//servlet 내에서 동적으로 HTML 생성 -> 전송
		out.print("<html>");
		out.print("<body>");
		out.print(String.format("<h2>%s어 [%s]인사말</h2>", nation_name, time_kor));
		out.print(String.format("<h4>%s</h4>", greeting));
		out.print("<br>");
		out.print("<a href='hello.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
