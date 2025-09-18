package action;
//person list를 parsing 해서 화면에 출력


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.PersonVo;

/**
 * Servlet implementation class PersonLIstAction
 */
@WebServlet("/person/list.do")
public class PersonLIstAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String webPath = "/";
		ServletContext application = request.getServletContext();
		//웹 경로를 이용해서 절대 경로 구하기
		String absPath = application.getRealPath(webPath);
		/* System.out.println(absPath); */
		
		FileReader fr = null;
		
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		
		try {
			
			fr = new FileReader(absPath + "person.xml");
			
			//XML Parsing(해석) - 전체 문서 정보 (document)
			SAXBuilder builder = new SAXBuilder();
			org.jdom2.Document doc = builder.build(fr);
			
			//element 읽어옴
			//root element
			Element root = doc.getRootElement();
			//root 아래 children 리스트를 array_list로 받아옴 
			List<Element> person_list = root.getChildren("person");
			
			for(Element person : person_list) {
				
				String name 		= person.getChildText("name");
				//xml의 name이라는 태그에 대한 정보
				Element nameElement = person.getChild("name");
				//name 태그의 nickname 속성값을 얻어옴( 한줄로 쓰기도 가능)
				String nickname 	= nameElement.getAttributeValue("nickname");
				//age가 없는 경우가 생기면 parsing이 비정상적으로 진행되기 때문에 예외처리
				int age 			= 0;
				
				try {
					age = Integer.parseInt(person.getChildText("age"));
				} catch (Exception e) {
				}
				
				String tel		 	= person.getChildText("tel");
				String hometel		= person.getChild("tel").getAttributeValue("hometel");
				//생성자를 만들어두고 그 생성자에 포장
				PersonVo vo = new PersonVo(name, nickname, age, tel, hometel);
				//list에 추가
				list.add(vo);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			if(fr!=null) fr.close();
		}
		
		//request binding
		request.setAttribute("list", list);
		
		
		//dispatcher(forward)
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}