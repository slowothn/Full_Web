package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/map.do")
	@ResponseBody
	public Map map() {
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("name", "홍길동");
		map.put("age", 20);
		map.put("addr", "서울 강남 서초");
		
		
		return map;
	}
}
