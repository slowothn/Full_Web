package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TestService;

@Controller
public class HomeController{

	@Autowired
	TestService service;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("--HomeController()--");
	}
	
	@RequestMapping("/home.do")
	@ResponseBody
	public String home(){
		
		
		return "home";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model){
		
		List<String> list = service.selectList();
		model.addAttribute("list", list);
		
		return "list";
		
	}
}
