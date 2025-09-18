package action;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJsonAction
 */
@WebServlet("/test.do")
public class TestJsonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// " 사용하기 위해 \을 따로 붙여줘야 하므로 주석처리한거 복붙하기(알아서 \붙여줌)
		// { "name":"홍길동","age":21,"tel":"010-111-1234" }
		String json_data = "{ \"name\":\"홍길동\",\"age\":21,\"tel\":\"010-111-1234\" }";

		JSONObject json = new JSONObject(json_data);

		// parsing
		String name = json.getString("name");
		int age = json.getInt("age");
		String tel = json.getString("tel");

		System.out.printf("[%s]-[%d]-[%s]\n", name, age, tel);

		// { "name":"홍길동", "hobby": ["낚시","독서","영화"] }
		String json_data2 = "{ \"name\":\"홍길동\", \"hobby\": [\"낚시\",\"독서\",\"영화\"] }";

		JSONObject json2 = new JSONObject(json_data2);

		String name2 = json2.getString("name");
		JSONArray hobbyArray = json2.getJSONArray("hobby");
		System.out.println("---[json2]---");
		System.out.printf("이름:%s\n", name2);
		System.out.print("취미:");
		for (int i = 0; i < hobbyArray.length(); i++) {
			String hobby = hobbyArray.getString(i);
			System.out.print(hobby + " ");
		}

	}

}