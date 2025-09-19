package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TestDao;

@Service
public class TestService {

	//자동엮기
	@Autowired
	TestDao  dao;
	
	public TestService() {
		// TODO Auto-generated constructor stub
		System.out.println("--2.TestService()--");
	}
	
	public List<String> selectList(){
		
		return dao.selectList();
	}
	
}
